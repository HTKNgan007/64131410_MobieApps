package com.example.bmiapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtWeight, edtHeight;
    Button btnBMI;
    TextView tvKq;

    void getControls () {
        edtWeight = findViewById(R.id.editTextNumber);
        edtHeight = findViewById(R.id.editTextNumber2);
        btnBMI = findViewById(R.id.btnBMI);
        tvKq = findViewById(R.id.tvKq);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getControls();
        btnBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }
    private void calculateBMI() {
        // Kiểm tra nếu dữ liệu nhập vào không hợp lệ
        if (edtWeight.getText().toString().isEmpty() || edtHeight.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter both weight and height!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            // Lấy giá trị từ EditText
            double weight = Double.parseDouble(edtWeight.getText().toString());
            double height = Double.parseDouble(edtHeight.getText().toString());

            // Kiểm tra chiều cao phải lớn hơn 0
            if (height <= 0) {
                Toast.makeText(MainActivity.this, "Chiều cao phải lớn hơn 0!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Tính BMI
            double bmi = weight / (height * height);

            // Phân loại theo BMI
            String category;
            if (bmi < 18.5) {
                category = "Thiếu cân";
            } else if (bmi >= 18.5 && bmi < 24.9) {
                category = "Bình thường";
            } else if (bmi >= 25 && bmi < 29.9) {
                category = "Thừa cân";
            } else {
                category = "Béo phì";
            }

            // Hiển thị kết quả
            tvKq.setText(String.format("Your BMI: %.2f (%s)", bmi, category));
        } catch (NumberFormatException e) {
            Toast.makeText(MainActivity.this, "Invalid input!", Toast.LENGTH_SHORT).show();
        }
    }
}
package com.example.vidu2;

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
import com.example.vidu1.R;

public class BmiActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_bmi);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main1), (v, insets) -> {
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
            Toast.makeText(BmiActivity.this, "Please enter both weight and height!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            // Lấy giá trị từ EditText
            double weight = Double.parseDouble(edtWeight.getText().toString());
            double height = Double.parseDouble(edtHeight.getText().toString());

            // Kiểm tra chiều cao phải lớn hơn 0
            if (height <= 0) {
                Toast.makeText(BmiActivity.this, "Height must be greater than zero!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Tính BMI
            double bmi = weight / (height * height);

            // Hiển thị kết quả BMI
            tvKq.setText(String.format("Your BMI: %.2f", bmi));
        } catch (NumberFormatException e) {
            Toast.makeText(BmiActivity.this, "Invalid input!", Toast.LENGTH_SHORT).show();
        }
    }
}
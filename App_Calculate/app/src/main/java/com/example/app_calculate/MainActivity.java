package com.example.app_calculate;

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
    //1. Khai báo các điều khiển,
    Button bCong, bTru, bNhan, bChia;
    EditText editTextA, editTextB;
    TextView textViewKetQua;
    //2. Hàm tìm các điều khiển, cất vào biến ở trên
    void getControls () {
        bCong = findViewById(R.id.btnCong);
        bTru = findViewById(R.id.btnTru);
        bNhan = findViewById(R.id.btnNhan);
        bChia = findViewById(R.id.btnChia);
        editTextA = findViewById(R.id.edtA);
        editTextB = findViewById(R.id.edtB);
        textViewKetQua = findViewById(R.id.tvKetQua);
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
        //3.Gọi hàm
        getControls();

        // B2: gắn bộ lắng nghe vào nút trừ
        bTru.setOnClickListener(langNgheTru);
    }
    // B1: tạo bộ lắng  và đáp ứng lại sự kiện use cl trên nút trừ
    View.OnClickListener langNgheTru = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            double a = Double.parseDouble(editTextA.getText().toString());
            double b = Double.parseDouble(editTextB.getText().toString());
            double kq = a - b;
            textViewKetQua.setText(String.valueOf(kq));
        }
    };

    // Xu ly sư kiện
    public void Xuly_Cong(View v) {
        //Vì đã tìm đk rồi, nên ta chỉ sử dụng thôi
        double a=  Double.parseDouble( editTextA.getText().toString());
        double b=  Double.parseDouble( editTextB.getText().toString());
        double kq = a+b;
        textViewKetQua.setText(String.valueOf(kq) );

    }

    // Hàm xử lý phép nhân
    public void Xuly_Nhan(View view) {
        double a = Double.parseDouble(editTextA.getText().toString());
        double b = Double.parseDouble(editTextB.getText().toString());
        double ketQua = a * b;
        textViewKetQua.setText(String.valueOf(ketQua));
    }

    // Hàm xử lý phép chia
    public void Xuly_Chia(View view) {
        double a = Double.parseDouble(editTextA.getText().toString());
        double b = Double.parseDouble(editTextB.getText().toString());

        // Kiểm tra chia cho 0
        if (b != 0) {
            double ketQua = a / b;
            textViewKetQua.setText(String.valueOf(ketQua));
        } else {
            textViewKetQua.setText("Không thể chia cho 0");
        }
    }
}
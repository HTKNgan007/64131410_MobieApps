package com.example.vidu1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
    }
    public void sayHello(View v){
        EditText soThuNhat = findViewById(R.id.edtNumber1);
        EditText soThuHai = findViewById(R.id.edtNumber2);
        //Lấy dữ liệu bằng getter
        String s1 = soThuNhat.getText().toString();
        String s2 = soThuHai.getText().toString();
        //Chuyển kiểu
        int num1 = Integer.parseInt(s1);
        int num2 = Integer.parseInt(s2);
        //Tính toán
        int tong = num1 + num2;
        //Xuất chuyển từ int sang string
        String chuoiXuat= "Tổng là: " + String.valueOf(tong);

        Toast.makeText(this, chuoiXuat, Toast.LENGTH_SHORT).show();
    }
}
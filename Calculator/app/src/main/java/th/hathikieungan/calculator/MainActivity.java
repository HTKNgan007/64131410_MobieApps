package th.hathikieungan.calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Tham chiếu các thành phần giao diện
        EditText soA = findViewById(R.id.edtSoA);
        EditText soB = findViewById(R.id.edtSoB);
        TextView ketQua = findViewById(R.id.txtKetQua);
        Button nutCong = findViewById(R.id.nutCong);
        Button nutTru = findViewById(R.id.nutTru);
        Button nutNhan = findViewById(R.id.nutNhan);
        Button nutChia = findViewById(R.id.nutChia);
        Button nutTinhToan = findViewById(R.id.nutTinhToan);

        // Tạo đối tượng Controller và truyền giao diện vào
        CalculatorController cal = new CalculatorController(soA, soB, ketQua);

        // Đặt sự kiện cho các nút
        cal.datSuKienChoNut(nutCong, nutTru, nutNhan, nutChia);
        cal.datSuKienChoNutTinhToan(nutTinhToan);
    }
}
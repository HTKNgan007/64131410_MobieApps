package th.hathikieungan.calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
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
        Button nutTinhToan = findViewById(R.id.nutTinhToan);
        RadioGroup radioGroupPhepToan = findViewById(R.id.radioGroupPhepToan); // Nhóm các phép toán

        // Tạo đối tượng Controller và truyền giao diện vào
        CalculatorController cal = new CalculatorController(soA, soB, ketQua, radioGroupPhepToan);

        // Đặt sự kiện cho nút "Tính toán"
        cal.datSuKienChoNutTinhToan(nutTinhToan);
    }
}
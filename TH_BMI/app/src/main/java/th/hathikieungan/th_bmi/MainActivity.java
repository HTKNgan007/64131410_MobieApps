package th.hathikieungan.th_bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText heightInput, weightInput;
    private CheckBox asiaCheckbox;
    private TextView bmiResult, bmiEvaluation;
    private Button calculateBtn;

    private BMIController bmiController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo các view
        heightInput = findViewById(R.id.heightInput);
        weightInput = findViewById(R.id.weightInput);
        asiaCheckbox = findViewById(R.id.asiaCheckbox);
        bmiResult = findViewById(R.id.bmiResult);
        bmiEvaluation = findViewById(R.id.bmiEvaluation);
        calculateBtn = findViewById(R.id.calculateBtn);

        // Khởi tạo BMIController
        bmiController = new BMIController();

        // Set click listener cho button tính toán BMI
        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        // Lấy thông tin người dùng nhập vào
        String heightText = heightInput.getText().toString();
        String weightText = weightInput.getText().toString();
        boolean isAsia = asiaCheckbox.isChecked();

        // Kiểm tra dữ liệu nhập vào
        if (!bmiController.isValidInput(heightText, weightText)) {
            bmiResult.setText("Vui lòng nhập đầy đủ thông tin!");
            bmiEvaluation.setText("");
            return;
        }

        // Tính BMI
        float bmi = bmiController.calculateBMI(heightText, weightText);
        if (bmi == 0) {
            bmiResult.setText("Dữ liệu không hợp lệ, vui lòng kiểm tra lại!");
            bmiEvaluation.setText("");
            return;
        }

        // Hiển thị kết quả BMI
        bmiResult.setText(String.format("BMI: %.2f", bmi));

        // Đánh giá BMI
        String evaluation = bmiController.evaluateBMI(bmi, isAsia);
        bmiEvaluation.setText("Đánh giá: " + evaluation);
    }
}
package th.hathikieungan.calculator;

import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class CalculatorController {
    private EditText soA, soB;
    private TextView ketQua;
    private RadioGroup radioGroupPhepToan;

    public CalculatorController(EditText soA, EditText soB, TextView ketQua, RadioGroup radioGroupPhepToan) {
        this.soA = soA;
        this.soB = soB;
        this.ketQua = ketQua;
        this.radioGroupPhepToan = radioGroupPhepToan;
    }

    // Đặt sự kiện cho nút "Tính toán" 
    public void datSuKienChoNutTinhToan(Button nutTinhToan) {
        nutTinhToan.setOnClickListener(v -> {
            String chuoiSoA = soA.getText().toString();
            String chuoiSoB = soB.getText().toString();

            if (chuoiSoA.isEmpty() || chuoiSoB.isEmpty()) {
                ketQua.setText("Vui lòng nhập đủ 2 số!");
                return;
            }

            try {
                double giaTriA = Double.parseDouble(chuoiSoA);
                double giaTriB = Double.parseDouble(chuoiSoB);

                // Xác định phép toán được chọn
                int selectedId = radioGroupPhepToan.getCheckedRadioButtonId();
                String phepToan = "+"; // Mặc định là phép cộng
                if (selectedId != -1) {
                    RadioButton radioButton = radioGroupPhepToan.findViewById(selectedId);
                    phepToan = radioButton.getText().toString();
                }

                // Tính toán và hiển thị kết quả
                double ketQuaTinhToan = thucHienTinhToan(giaTriA, giaTriB, phepToan);
                ketQua.setText("Kết quả: " + giaTriA + " " + phepToan + " " + giaTriB + " = " + ketQuaTinhToan);
            } catch (NumberFormatException e) {
                ketQua.setText("Số nhập vào không hợp lệ!");
            } catch (ArithmeticException e) {
                ketQua.setText(e.getMessage());
            } catch (IllegalArgumentException e) {
                ketQua.setText("Phép toán không hợp lệ!");
            }
        });
    }

    private double thucHienTinhToan(double a, double b, String phepToan) throws ArithmeticException {
        switch (phepToan) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "×": // Sử dụng ký tự "×" cho phép nhân
                return a * b;
            case "÷": // Sử dụng ký tự "÷" cho phép chia
                if (b == 0) {
                    throw new ArithmeticException("Không thể chia cho 0!");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Phép toán không hợp lệ!");
        }
    }
}

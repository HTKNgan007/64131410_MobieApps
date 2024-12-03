package th.hathikieungan.calculator;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorController {
    private EditText soA, soB;
    private TextView ketQua;
    private String phepToan = "+";

    public CalculatorController(EditText soA, EditText soB, TextView ketQua) {
        this.soA = soA;
        this.soB = soB;
        this.ketQua = ketQua;
    }

    // Đặt sự kiện cho các nút phép toán
    public void datSuKienChoNut(Button nutCong, Button nutTru, Button nutNhan, Button nutChia) {
        nutCong.setOnClickListener(v -> phepToan = "+");
        nutTru.setOnClickListener(v -> phepToan = "-");
        nutNhan.setOnClickListener(v -> phepToan = "*");
        nutChia.setOnClickListener(v -> phepToan = "/");
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
                double ketQuaTinhToan = thucHienTinhToan(giaTriA, giaTriB, phepToan);

                // Tạo chuỗi mô tả kết quả
                String chuoiKetQua = String.format("Kết quả của phép tính %.2f %s %.2f là: %.2f", giaTriA, phepToan, giaTriB, ketQuaTinhToan);
                ketQua.setText(chuoiKetQua);
            } catch (NumberFormatException e) {
                ketQua.setText("Số nhập vào không hợp lệ!");
            } catch (ArithmeticException e) {
                ketQua.setText(e.getMessage());
            } catch (IllegalArgumentException e) {
                ketQua.setText("Phép toán không hợp lệ!");
            }
        });
    }

    // Logic tính toán
    private double thucHienTinhToan(double a, double b, String phepToan) throws ArithmeticException {
        switch (phepToan) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Không thể chia cho 0!");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Phép toán không hợp lệ!");
        }
    }
}

package th.hathikieungan.th_bmi;

public class BMIController {
    // Tính BMI 
    public float calculateBMI(String heightText, String weightText) {
        try {
            // Chuyển đổi dữ liệu từ String sang float
            float height = Float.parseFloat(heightText);
            float weight = Float.parseFloat(weightText);

            // Kiểm tra giá trị chiều cao và cân nặng
            if (height <= 0 || weight <= 0) {
                return 0; // Trả về 0 nếu giá trị không hợp lệ
            }

            // Tính toán BMI
            return weight / (height * height);
        } catch (NumberFormatException e) {
            return 0; // Trả về 0 nếu gặp lỗi khi chuyển đổi
        }
    }

    // Hàm kiểm tra đầu vào
    public boolean isValidInput(String heightText, String weightText) {
        return !heightText.isEmpty() && !weightText.isEmpty();
    }

    // Hàm đánh giá BMI (giữ nguyên)
    public String evaluateBMI(float bmi, boolean isAsia) {
        if (isAsia) {
            if (bmi < 17.50) return "Gầy";
            else if (bmi < 23.00) return "Bình thường";
            else if (bmi < 28.00) return "Thừa cân";
            else return "Béo phì";
        } else {
            if (bmi < 18.50) return "Gầy";
            else if (bmi < 25.00) return "Bình thường";
            else if (bmi < 30.00) return "Thừa cân";
            else return "Béo phì";
        }
    }
}

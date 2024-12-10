package th.hathikieungan.th_bai5_quizappgui;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Java extends AppCompatActivity {

    private LinearLayout linearLayoutA, linearLayoutB, linearLayoutC, linearLayoutD;
    private LinearLayout selectedLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_java);

        // Khởi tạo các LinearLayout
        linearLayoutA = findViewById(R.id.layoutC);
        linearLayoutB = findViewById(R.id.linearLayout3);
        linearLayoutC = findViewById(R.id.linearLayout4);
        linearLayoutD = findViewById(R.id.linearLayout6);

        // Gán sự kiện click cho từng layout
        setOnClick(linearLayoutA);
        setOnClick(linearLayoutB);
        setOnClick(linearLayoutC);
        setOnClick(linearLayoutD);
    }

    private void setOnClick(LinearLayout layout) {
        layout.setOnClickListener(view -> {
            // Đặt lại background mặc định cho layout trước đó
            if (selectedLayout != null) {
                selectedLayout.setBackgroundResource(R.drawable.form);
            }
            // Đặt viền đỏ cho layout được click
            layout.setBackgroundResource(R.drawable.red_border);
            // Lưu layout đã chọn
            selectedLayout = layout;
        });

    }
}
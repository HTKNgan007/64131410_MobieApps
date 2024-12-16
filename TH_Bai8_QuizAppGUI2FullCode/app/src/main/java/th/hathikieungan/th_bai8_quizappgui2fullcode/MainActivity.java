package th.hathikieungan.th_bai8_quizappgui2fullcode;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

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

        // Chuyển sang màn hình câu hỏi sau 3 giây
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
            startActivity(intent);
            finish();
        }, 3000); // 3000ms = 3 giây
    }
}
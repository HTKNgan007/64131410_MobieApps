package th.hathikieungan.th_bai6_quizappfullcode;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private CardView layoutC, layoutJava, layoutPython;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        layoutC = findViewById(R.id.layoutC);
        layoutJava = findViewById(R.id.layoutJava);
        layoutPython = findViewById(R.id.layoutPython);

        // Gán sự kiện click cho layout C++
        layoutC.setOnClickListener(view -> {
            // Chuyển sang CActivity
            Intent intent = new Intent(MainActivity.this, ActivityC.class);
            startActivity(intent);
        });

        // Gán sự kiện click cho layout Java
        layoutJava.setOnClickListener(view -> {
            // Chuyển sang JavaActivity
            Intent intent = new Intent(MainActivity.this, JavaActivity.class);
            startActivity(intent);
        });

        // Gán sự kiện click cho layout Python
        layoutPython.setOnClickListener(view -> {
            // Chuyển sang JavaActivity
            Intent intent = new Intent(MainActivity.this, PythonActivity.class);
            startActivity(intent);
        });
    }
}
package th.hathikieungan.app_tracnghiem;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ToanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_toan);

        // Gắn Fragment 1 vào fragment_container1
        T1_Fragment fragment1 = new T1_Fragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentT1, fragment1)
                .commit();

        // Gắn Fragment 2 vào fragment_container2
        T2_Fragment fragment2 = new T2_Fragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentT2, fragment2)
                .commit();

    }
}
package th.hathikieungan.app_tracnghiem;

import android.os.Bundle;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class TiengAnhActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tieng_anh);

        // Gắn Fragment 1 vào fragment_container1
        E1_Fragment fragment1 = new E1_Fragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentE1, fragment1)
                .commit();

        // Gắn Fragment 2 vào fragment_container2
        E2_Fragment fragment2 = new E2_Fragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentE2, fragment2)
                .commit();

        // Gắn Fragment 3 vào fragment_container3s
        E3_Fragment fragment3 = new E3_Fragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentE3, fragment3)
                .commit();
    }
}
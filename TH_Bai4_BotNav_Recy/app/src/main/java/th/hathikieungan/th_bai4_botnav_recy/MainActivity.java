package th.hathikieungan.th_bai4_botnav_recy;

import th.hathikieungan.th_bai4_botnav_recy.R;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setItemIconTintList(null);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            if (item.getItemId() == R.id.nav_cn1) {
                selectedFragment = new CN1Fragment();
            } else if (item.getItemId() == R.id.nav_cn2) {
                selectedFragment = new CN2Fragment();
            } else if (item.getItemId() == R.id.nav_cn3) {
                selectedFragment = new CN3Fragment();
            } else if (item.getItemId() == R.id.nav_cn4) {
                selectedFragment = new CN4Fragment();
            }
            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();
            }
            return true;
        });

        // Hiển thị CN1fragment đầu tiên khi mở app
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new CN1Fragment())
                    .commit();
        }
    }
}
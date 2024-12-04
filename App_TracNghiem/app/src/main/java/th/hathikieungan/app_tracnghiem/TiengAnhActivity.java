package th.hathikieungan.app_tracnghiem;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class TiengAnhActivity extends AppCompatActivity{
    private int currentFragmentIndex = 0;
    private final Fragment[] fragments = {new E1_Fragment(), new E2_Fragment(), new E3_Fragment()};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tieng_anh);

        // Hiển thị fragment đầu tiên
        replaceFragment(fragments[currentFragmentIndex]);

        // Ánh xạ các nút
        Button buttonLeft = findViewById(R.id.btn_prev);
        Button buttonRight = findViewById(R.id.btn_next);

        // Xử lý sự kiện nút Trái
        buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentFragmentIndex > 0) {
                    currentFragmentIndex--;
                    replaceFragment(fragments[currentFragmentIndex]);
                }
            }
        });

        // Xử lý sự kiện nút Phải
        buttonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentFragmentIndex < fragments.length - 1) {
                    currentFragmentIndex++;
                    replaceFragment(fragments[currentFragmentIndex]);
                }
            }
        });
    }

    // Hàm thay thế fragment
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }

}
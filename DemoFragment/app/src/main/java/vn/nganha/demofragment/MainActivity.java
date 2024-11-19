package vn.nganha.demofragment;

import android.os.Bundle;

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

        // Gắn Fragment 1 vào fragment_container1
        Fragment1 fragment1 = new Fragment1();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container1, fragment1)
                .commit();

        // Gắn Fragment 2 vào fragment_container2
        Fragment2 fragment2 = new Fragment2();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container2, fragment2)
                .commit();
    }
}
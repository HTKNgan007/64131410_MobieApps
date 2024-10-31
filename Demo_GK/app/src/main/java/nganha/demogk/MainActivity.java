package nganha.demogk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
    }
    public void MHCau1(View v){
        // Tao intent
        Intent iNH1 = new Intent(MainActivity.this, MH1Activity.class);
        // Chuyen man hinh
        startActivity(iNH1);
    }
    public void MHCau2(View v){
        // Tao intent
        Intent iNH2 = new Intent(MainActivity.this, MH2Activity.class);

        // Chuyen man hinh
        startActivity(iNH2);
    }
    public void MHCau3(View v){
        // Tao intent
        Intent iNH3 = new Intent(MainActivity.this, MH3Activity.class);
        // Chuyen man hinh
        startActivity(iNH3);
    }
    public void MHCau4(View v){
        // Tao intent
        Intent iNH4 = new Intent(MainActivity.this, MH4Activity.class);
        // Chuyen man hinh
        startActivity(iNH4);
    }
}
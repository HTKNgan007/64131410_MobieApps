package nganha.demointent;

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

    public void ChuyenSangManHinh2(View v){
        //1. tao intent
        Intent iNH2 = new Intent(MainActivity.this, MainActivity2.class);

        //2. goi du lieu
//        iNH2.putExtra("ten", "Ngan Ha");

        //3. chuyen man hinh
        startActivity(iNH2);
    }
}
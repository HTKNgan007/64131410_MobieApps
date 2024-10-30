package nganha.demointent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
    }

    public void ChuyVeManHinhChinh(View v){
        //1. Lay du lieu ve
        Intent iNhan = getIntent();

        //2. Boc Du Lieu
        String data = iNhan.getStringExtra("ten");

        //3. hien len
        Toast.makeText(getBaseContext(), data, Toast.LENGTH_SHORT).show();
         //4. Chuyen ve man hinh chinh
        Intent iNHChinh = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(iNHChinh);

    }
}
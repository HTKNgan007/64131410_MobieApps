package th.hathikieungan.app_tracnghiem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button buttonTiengAnh = findViewById(R.id.TiengAnh);
        Button buttonToan = findViewById(R.id.Toan);
        Button buttonLapTrinh = findViewById(R.id.LapTrinh);

        buttonTiengAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TiengAnhActivity.class);
                startActivity(intent);
            }
        });

        buttonToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ToanActivity.class);
                startActivity(intent);
            }
        });

        buttonLapTrinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LapTrinhActivity.class);
                startActivity(intent);
            }
        });
    }
}
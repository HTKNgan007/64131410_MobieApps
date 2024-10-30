package nganha.demogk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MH4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mh4);
    }

    public void QuayVeManHinhChinh(View v){
        // Lay du lieu ve
        Intent iNhan = getIntent();

        // Chuyen ve man hinh chinh
        Intent iNHChinh = new Intent(MH4Activity.this, MainActivity.class);
        startActivity(iNHChinh);

    }
}
package nganha.demogk;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MH2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mh2);
    }
    public void QuayVeManHinhChinh(View v){
        // Chuyen ve man hinh chinh
        Intent iNHChinh = new Intent(MH2Activity.this, MainActivity.class);
        startActivity(iNHChinh);
    }

    // Hàm mở trang Facebook
    public void openFacebookPage(View view) {
        String fbUrl = "https://www.facebook.com/profile.php?id=100016827634933"; // URL đến facebook cá nhân
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(fbUrl));

        // Sử dụng ActivityCompat để mở
        try {
            ActivityCompat.startActivity(this, intent, null);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "Không tìm thấy trình duyệt", Toast.LENGTH_SHORT).show();
        }
    }

}
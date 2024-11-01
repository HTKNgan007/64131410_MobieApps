package vn.hathikieungan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CustomItemActivity extends AppCompatActivity {

    private TextView nameTextView, infoTextView;
    private ImageView avatarImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_item);

        nameTextView = findViewById(R.id.nameTextView);
        infoTextView = findViewById(R.id.infoTextView);
        avatarImageView = findViewById(R.id.avatarImageView);

        // Nhận dữ liệu User từ Intent
        String userName = getIntent().getStringExtra("userName");
        String userInfo = getIntent().getStringExtra("userInfo");
        int userAvatar = getIntent().getIntExtra("userAvatar", 0);

        // Hiển thị dữ liệu lên UI
        nameTextView.setText(userName);
        infoTextView.setText(userInfo);
        avatarImageView.setImageResource(userAvatar);
    }

    public void QuayLaiBai3(View v){
        // Chuyen ve man hinh chinh
        Intent iNHChinh = new Intent(CustomItemActivity.this, activityBai3.class);
        startActivity(iNHChinh);
    }
}
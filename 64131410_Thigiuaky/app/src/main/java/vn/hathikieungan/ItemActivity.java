package vn.hathikieungan;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ItemActivity extends AppCompatActivity {

    private TextView urlTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        urlTextView = findViewById(R.id.urlTextView);

        // Nhận URL từ Intent
        String selectedUrl = getIntent().getStringExtra("selectedUrl");

        // Hiển thị URL lên TextView
        if (selectedUrl != null) {
            urlTextView.setText(selectedUrl);
        }
    }
}
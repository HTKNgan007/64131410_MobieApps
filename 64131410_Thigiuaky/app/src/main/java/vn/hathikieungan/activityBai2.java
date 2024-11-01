package vn.hathikieungan;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class activityBai2 extends AppCompatActivity {

    private ListView rssListView;
    private ArrayList<String> rssUrls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai2);

        // Khởi tạo ListView và danh sách URL
        rssListView = findViewById(R.id.rssListView);
        rssUrls = new ArrayList<>();

        // Thêm các địa chỉ RSS vào danh sách
        rssUrls.add("https://vnexpress.net/rss/tin-moi-nhat.rss");
        rssUrls.add("https://tuoitre.vn/rss/tin-moi-nhat.rss");
        rssUrls.add("https://thanhnien.vn/rss/home.rss");
        rssUrls.add("https://nhandan.vn/rss/home.rss");

        // Sử dụng ArrayAdapter để hiển thị danh sách URL
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, rssUrls);
        rssListView.setAdapter(adapter);

        // Bắt sự kiện khi một mục trong ListView được nhấn
        rssListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Lấy URL từ danh sách
                String selectedUrl = rssUrls.get(position);

                // Tạo Intent để mở URL trong trình duyệt
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(selectedUrl));
                startActivity(intent);
            }
        });
    }

    public void QuayVeManHinhChinh(View v){
        // Chuyen ve man hinh chinh
        Intent iNHChinh = new Intent(activityBai2.this, MainActivity.class);
        startActivity(iNHChinh);
    }
}
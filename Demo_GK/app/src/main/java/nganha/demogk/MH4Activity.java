package nganha.demogk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MH4Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private List<User> userList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mh4);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Tạo danh sách dữ liệu mẫu
        userList = new ArrayList<>();
        User u1 = new User("Pikachu", "Hệ điện", R.drawable.pikachu);
        User u2 = new User("Gekkoga", "Hệ nước", R.drawable.gekkoga);
        User u3 = new User("Jukain Mega", "Hệ cỏ", R.drawable.jukain_mega);
        userList.add(u1);
        userList.add(u2);
        userList.add(u3);
        userList.add(u1);
        userList.add(u2);
        userList.add(u3);
        userList.add(u1);
        userList.add(u2);
        userList.add(u3);

        // Tạo adapter và gán vào RecyclerView
        myAdapter = new MyAdapter(userList);
        recyclerView.setAdapter(myAdapter);
    }

    public void QuayVeManHinhChinh(View v){
        // Chuyen ve man hinh chinh
        Intent iNHChinh = new Intent(MH4Activity.this, MainActivity.class);
        startActivity(iNHChinh);

    }
}
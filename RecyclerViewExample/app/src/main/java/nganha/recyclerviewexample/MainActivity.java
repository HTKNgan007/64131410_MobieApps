package nganha.recyclerviewexample;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private List<User> userList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Tạo danh sách dữ liệu mẫu
        userList = new ArrayList<>();
        userList.add(new User("Pikachu", "Hệ điện", R.drawable.pikachu));
        userList.add(new User("Gekkoga", "Hệ nước", R.drawable.gekkoga));
        userList.add(new User("Jukain Mega", "Hệ cỏ", R.drawable.jukain_mega));

        // Tạo adapter và gán vào RecyclerView
//        myAdapter = new MyAdapter(userList);
//        recyclerView.setAdapter(myAdapter);
        // Tạo adapter và gán vào RecyclerView với OnItemClickListener
        myAdapter = new MyAdapter(userList, user -> {
            // Hiển thị thông tin người dùng khi click
            showUserInfo(user);
        });
        recyclerView.setAdapter(myAdapter);
    }

    // Phương thức hiển thị thông tin người dùng
    private void showUserInfo(User user) {
        // Sử dụng Toast để hiển thị thông tin
        Toast.makeText(this, "Name: " + user.getName() + "\nInfo: " + user.getInfo(), Toast.LENGTH_SHORT).show();
    }
}
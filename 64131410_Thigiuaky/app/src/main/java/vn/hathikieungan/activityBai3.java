package vn.hathikieungan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class activityBai3 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private List<User> userList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai3);

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
        myAdapter = new MyAdapter(userList, user -> {
            // Hiển thị thông tin người dùng khi click
            showUserInfo(user);
        });
        recyclerView.setAdapter(myAdapter);
    }

    // Phương thức hiển thị thông tin dùng toast
//    private void showUserInfo(User user) {
//        // Sử dụng Toast để hiển thị thông tin
//        Toast.makeText(this, "Name: " + user.getName() + "\nInfo: " + user.getInfo(), Toast.LENGTH_SHORT).show();
//    }
    // Phương thức hiển thị thông tin
    private void showUserInfo(User user) {
        // Tạo Intent để chuyển sang CustomItemActivity
        Intent intent = new Intent(activityBai3.this, CustomItemActivity.class);
        intent.putExtra("userName", user.getName());
        intent.putExtra("userInfo", user.getInfo());
        intent.putExtra("userAvatar", user.getAvatarResId());
        startActivity(intent);
    }

    public void QuayVeManHinhChinh(View v){
        // Chuyen ve man hinh chinh
        Intent iNHChinh = new Intent(activityBai3.this, MainActivity.class);
        startActivity(iNHChinh);

    }

}
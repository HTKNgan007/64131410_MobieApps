package com.example.listviewapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> dsBaiTho;
    ListView lvBaiTho;
    Button btnThemBT;
    EditText edtTenBaiTho;
    ArrayAdapter<String> adapterBaiTho;
    void getControl(){
        lvBaiTho = findViewById(R.id.lvBT);
        btnThemBT = findViewById(R.id.btnThem);
        edtTenBaiTho = findViewById(R.id.edtTenBT);
    }
    //Ham doc du lieu
    ArrayList<String> getData(){
        ArrayList<String> lstTenBaiTho = new ArrayList<>();
        lstTenBaiTho.add("Tay tien");
        lstTenBaiTho.add("Dat nuoc");
        lstTenBaiTho.add("Banh troi nuoc");
        lstTenBaiTho.add("Song");
        return lstTenBaiTho;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getControl();
        dsBaiTho = getData();
        ArrayAdapter<String> adapterBaiTho;
        adapterBaiTho = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dsBaiTho);
        lvBaiTho.setAdapter(adapterBaiTho);
        lvBaiTho.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                XuLyKhiNhanVaoViTri(i);
            }
        });
        btnThemBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenBai = edtTenBaiTho.getText().toString();
                dsBaiTho.add(tenBai);
                adapterBaiTho.notifyDataSetChanged();
            }
        });
    }

    void XuLyKhiNhanVaoViTri(int pos){
        String item = dsBaiTho.get(pos);
        Toast.makeText(getApplicationContext(), item, Toast.LENGTH_SHORT).show();
    }
}
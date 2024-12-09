package th.hathikieungan.th_bai4_botnav_recy;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class CN2Fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cn2, container, false);
            // Khởi tạo RecyclerView
            RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

            // Tạo dữ liệu mẫu
            List<Item> itemList = new ArrayList<>();
            itemList.add(new Item(R.drawable.rocket, "Tóm tắt 1"));
            itemList.add(new Item(R.drawable.rocket, "Tóm tắt 2"));
            itemList.add(new Item(R.drawable.rocket, "Tóm tắt 3"));
            itemList.add(new Item(R.drawable.rocket, "Tóm tắt 4"));

            // Thiết lập Adapter
            ItemAdapter adapter = new ItemAdapter(itemList);
            recyclerView.setAdapter(adapter);

            return view;
        }
}
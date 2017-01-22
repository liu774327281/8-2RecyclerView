package org.mobiletrain.a8_2recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import org.mobiletrain.a8_2recyclerview.decorator.MyItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        initData();
        //像ListView一样来显示RecyclerView
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this);
        //第二个参数表示滚动方向
        //第三个参数表示是否反转，是的话，则从最后一个item开始显示
        /*LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(this, 3);
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(this, 3, GridLayoutManager.HORIZONTAL, true);*/
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        //设置布局管理器，必须设置
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
//        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL_LIST));
//        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        recyclerView.addItemDecoration(new MyItemDecoration(1));
        MyAdapter adapter = new MyAdapter(this, list);
        recyclerView.setAdapter(adapter);
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add("张三：" + i);
        }
    }
}

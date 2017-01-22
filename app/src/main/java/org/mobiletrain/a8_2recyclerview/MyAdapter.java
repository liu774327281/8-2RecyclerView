package org.mobiletrain.a8_2recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by 王松 on 2016/6/21.
 */
public class MyAdapter extends RecyclerView.Adapter {
    private List<String> list;
    private Context context;
    private LayoutInflater inflater;

    public MyAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    //初始化ViewHolder，类似于BaseAdapter中getView方法的if(){}功能
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.recyclerview_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(itemView);
        return viewHolder;
    }

    //数据绑定，类似于BaseAdapter中getView方法中数据绑定的功能
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        ((MyViewHolder) holder).name.setText(list.get(position));
    }

    //返回RecyclerView中条目总数
    @Override
    public int getItemCount() {
        return list.size();
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView name;

        //itemView表示布局文件
        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "position:" + getLayoutPosition(), Toast.LENGTH_SHORT).show();
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    //holder.getLayoutPosition()方法表示获得当前所点击item的真正位置
                    list.remove(getLayoutPosition());
                    //该方法会将整个列表刷新，添加或者删除时item的position不会错位，但是添加和删除都没有动画
                    //不推荐使用这种方式
                    //notifyDataSetChanged();
                    notifyItemRemoved(getLayoutPosition());
                    return true;
                }
            });
        }
    }
}

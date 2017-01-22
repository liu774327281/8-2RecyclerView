package org.mobiletrain.a8_2recyclerview.decorator;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by 王松 on 2016/6/21.
 */
public class MyItemDecoration extends RecyclerView.ItemDecoration {
    private int space;

    public MyItemDecoration(int space) {
        this.space = space;
    }

    //获取每一个ChildView的上下左右四个方向的偏移量
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = space;
        outRect.bottom = space;
        outRect.right = space;
//        parent.getChildLayoutPosition(view)表示获取childView在父容器中的位置
        if (parent.getChildLayoutPosition(view) == 0 || parent.getChildLayoutPosition(view) == 1 || parent.getChildLayoutPosition(view) == 2) {
            outRect.top = space;
        }
        if (parent.getChildLayoutPosition(view) % 3 != 2) {
            outRect.right = 0;
        }
    }

    //绘制分隔线，这个方法绘制出来的分隔线和childView在同一个平面上
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
    }

    //绘制分隔线，这里绘制出来的分隔线在RecyclerView之上
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }
}

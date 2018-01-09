package com.example.lithography.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lithography.R;
import com.example.lithography.bean.XiangqingBean;

import java.util.List;

/**
 * Created by 柴晓凯 on 2018/1/3.
 */

public class ListMoveAdapter extends RecyclerView.Adapter<ListMoveAdapter.ViewHolder>{
    private Context context;
    private List<XiangqingBean.RetBean.ListBean.ChildListBean> list ;

    //recycle点击事件
    public interface OnClickitemListener{
        void onItemclick(int postion);
    }

    //封装私有变量
    private OnClickitemListener onRecycleViewListener;

    public void setRecycleOnClickListener(OnClickitemListener onClickListener){
        this.onRecycleViewListener = onClickListener;
    };

    public ListMoveAdapter(Context context,  List<XiangqingBean.RetBean.ListBean.ChildListBean> list) {
        this.context = context;
        this.list = list;
    }
    @Override
    public ListMoveAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.dianywenz, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ListMoveAdapter.ViewHolder holder, final int position) {
        Glide.with(context).load(list.get(position).getPic()).into(holder.im);
        //一体的点击事件
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //获取对应条目
                    onRecycleViewListener.onItemclick(position);
                }
            });
        holder.tv.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    //优化extends RecyclerView.ViewHolder
    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView im;
        private TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            im = itemView.findViewById(R.id.list_movie);
            tv=itemView.findViewById(R.id.list_movie_name);
        }
    }
}

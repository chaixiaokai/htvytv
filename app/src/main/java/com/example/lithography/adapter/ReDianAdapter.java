package com.example.lithography.adapter;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.lithography.R;
import com.example.lithography.bean.ReDianBean;

import java.util.List;

/**
 * Created by 柴晓凯 on 2018/1/4.
 */

public class ReDianAdapter extends RecyclerView.Adapter<ReDianAdapter.ViewHolder> {
    private Context context;
    private List<ReDianBean.RetBean.ListBean> list;

    //
    //recycle点击事件
    //一:自定义一个接口
    public interface OnClickitemListener{
        //一个对应条目
        void onItemclick(int postion);
    }

    //
    //封装私有变量
    private OnClickitemListener onRecycleViewListener;

    public void setRecycleOnClickListener(OnClickitemListener onClickListener){
        this.onRecycleViewListener = onClickListener;
    };


    public ReDianAdapter(Context context, List<ReDianBean.RetBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        private final ImageView img1;
        private final TextView tv1;

        public ViewHolder(View itemView) {
            super(itemView);
            img1=itemView.findViewById(R.id.re_img);
            tv1 =itemView.findViewById(R.id.re_tv);
        }
    }

    @Override
    public ReDianAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.redian, null);
        ViewHolder holder = new ViewHolder(view);
        return  holder;
    }

    @Override
    public void onBindViewHolder(final ReDianAdapter.ViewHolder holder, final int position) {
        Glide.with(context).load(list.get(position).getPic()).into(holder.img1);
        holder.tv1.setText(list.get(position).getTitle());
        //
        //一体的点击事件
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onRecycleViewListener.onItemclick(position);
                }
            });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

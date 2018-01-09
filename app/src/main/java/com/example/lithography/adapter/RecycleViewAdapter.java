package com.example.lithography.adapter;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.lithography.R;
import com.example.lithography.bean.Img;

import java.util.List;

/**
 * Created by 柴晓凯 on 2018/1/2.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>{
    private Context context;
    private List<Img> list;

    public RecycleViewAdapter(Context context, List<Img> list) {
        this.context = context;
        this.list = list;
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        private final ImageView img1;
        private final TextView tv1;
        public ViewHolder(View itemView) {
            super(itemView);
            img1=itemView.findViewById(R.id.img);
            tv1 =itemView.findViewById(R.id.title);
        }
    }


    @Override
    public RecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.adapter, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecycleViewAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getImg()).into(holder.img1);
        holder.tv1.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}

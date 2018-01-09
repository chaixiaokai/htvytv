package com.example.lithography.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lithography.R;
import com.example.lithography.bean.Dabean;
import com.example.lithography.jiekou.FoundJk;

import java.util.List;

//专题的适配器

/**
 * Created by 柴晓凯 on 2018/1/4.
 */

public class twoRecycleviewAdapter extends RecyclerView.Adapter<twoRecycleviewAdapter.ViewHolder> {
    private Context context;
    private List<Dabean.RetBean.ListBean> list;
    private FoundJk jiekou;//

    public twoRecycleviewAdapter(Context context, List<Dabean.RetBean.ListBean> list,FoundJk jiekou) {
        this.context = context;
        this.list = list;
        this.jiekou=jiekou;//
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        private final ImageView img1;
        private final TextView tv1;
        private View v;
        //
        public View  getV(){
            return  v;
        }
        public ViewHolder(View itemView) {
            super(itemView);
            this.v=itemView;//
            img1=itemView.findViewById(R.id.two_img);
            tv1 =itemView.findViewById(R.id.two_tv);
        }
    }

    @Override
    public twoRecycleviewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.tworecycle, null);
        ViewHolder holder = new ViewHolder(view);
        return  holder;
    }

    @Override
    public void onBindViewHolder(twoRecycleviewAdapter.ViewHolder holder, final int position) {
        Glide.with(context).load(list.get(position).getChildList().get(0).getPic()).into(holder.img1);
        holder.tv1.setText(list.get(position).getTitle());
        //
        holder.getV().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jiekou.Chuanzhi(position);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

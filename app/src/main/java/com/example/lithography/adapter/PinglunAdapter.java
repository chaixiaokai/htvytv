package com.example.lithography.adapter;
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.lithography.R;

import java.util.List;

/**
 * Created by 柴晓凯 on 2018/1/3.
 */

public class PinglunAdapter extends RecyclerView.Adapter<PinglunAdapter.ViewHolder> {

    private List<PinglunBean.RetBean.ListBean> list;
    private Context context;

    public PinglunAdapter(List<PinglunBean.RetBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public PinglunAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.pinglun, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PinglunAdapter.ViewHolder holder, int position) {
        holder.name.setText(list.get(position).getPhoneNumber());
        holder.time.setText(list.get(position).getTime());
        holder.msg.setText(list.get(position).getMsg());
       // Glide.with(context).load(list.get(0).getUserPic()).into(holder.img);
        Uri parse = Uri.parse(list.get(position).getUserPic());
        holder.img.setImageURI(parse);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView name,time,msg;

        private final ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            time = itemView.findViewById(R.id.time);
            msg=itemView.findViewById(R.id.msg);
        }
    }
}

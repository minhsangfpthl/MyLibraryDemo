package com.example.demorecyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.MyViewHolder> {
    List<Chapter> chapters;

    public MyCustomAdapter(List<Chapter> li) {
        this.chapters = li;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_chapter, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imv.setBackgroundResource(chapters.get(position).getAvatar_id());
        holder.tv_title.setText(chapters.get(position).getTitle());
        holder.tv_des.setText(chapters.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return chapters.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imv;
        TextView tv_title;
        TextView tv_des;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imv = itemView.findViewById(R.id.imv_avatar);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_des = itemView.findViewById(R.id.tv_des);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    // lam recyclerview, bat su kien, truyen chapter sang
                    // man hinh moi , show thong tin chapter ben man hinh moi
                    Context context = itemView.getContext();
                    Intent intent = new Intent(context, InforActivity.class);

                    int index = getAdapterPosition();
                     intent.putExtra("id", chapters.get(index).getAvatar_id());
                     intent.putExtra("title", chapters.get(index).getTitle());
                     intent.putExtra("des", chapters.get(index).getDescription());

                    context.startActivity(intent);
                }
            });
        }
    }

}

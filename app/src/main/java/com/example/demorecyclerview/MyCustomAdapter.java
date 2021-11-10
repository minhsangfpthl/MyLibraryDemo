package com.example.demorecyclerview;

import android.content.Context;
import android.content.Intent;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.MyViewHolder> {
    List<Book> books;

    public MyCustomAdapter(List<Book> chapters) {
        this.books = chapters;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // tao ra view chua rox_chapter là từng book
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_chapter, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //set cac thuoc tinh
        holder.imv.setBackgroundResource(books.get(position).getImageUrl());
        holder.tv_name.setText(books.get(position).getName());

        holder.txtAuthor.setText(books.get(position).getAuthor());
        holder.txtDescription.setText(books.get(position).getShortDesc());

        // bam mui ten thi hien ra thong tin
        if(books.get(position).isExpanded()){
            //TransitionManager.beginDelayedTransition(holder.par);
            holder.expandedReLayout.setVisibility(View.VISIBLE);
            holder.downArrow.setVisibility(View.GONE);
        }else{
            holder.expandedReLayout.setVisibility(View.GONE);
            holder.downArrow.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imv;
        TextView tv_name;

        private ImageView downArrow, upArrow;
        private RelativeLayout expandedReLayout;
        private TextView txtAuthor , txtDescription;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imv = itemView.findViewById(R.id.imv_avatar);
            tv_name = itemView.findViewById(R.id.tv_name);
            downArrow = itemView.findViewById(R.id.btnDownArro);
            upArrow = itemView.findViewById(R.id.btnUpArrow);
            expandedReLayout = itemView.findViewById(R.id.expandedReLayout);

            txtAuthor = itemView.findViewById(R.id.authorText);
            txtDescription = itemView.findViewById(R.id.shortDes);


            downArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Book book = books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
            // bam mui ten len thi sao kbiet luon
            upArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Book book = books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }

}

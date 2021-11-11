package com.example.demorecyclerview.Adapters;

import static com.example.demorecyclerview.Actitivies.BookActivity.BOOK_ID_KEY;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demorecyclerview.Actitivies.BookActivity;
import com.example.demorecyclerview.Object.Book;
import com.example.demorecyclerview.R;
import com.example.demorecyclerview.assets.Utils;

import java.util.List;

public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.MyViewHolder> {
    List<Book> books;
    Context mContext;
    String parentActivity;


    public MyCustomAdapter(List<Book> books, String parentActivity) {
        this.books = books;
        this.parentActivity = parentActivity;
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
        int mLastPosition = holder.getAdapterPosition();
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), BookActivity.class);
                intent.putExtra(BOOK_ID_KEY,books.get(mLastPosition).getId());


                v.getContext().startActivity(intent);
            }
        });

        holder.txtAuthor.setText(books.get(position).getAuthor());
        holder.txtDescription.setText(books.get(position).getShortDesc());

        // bam mui ten thi hien ra thong tin
        if(books.get(position).isExpanded()){
            //TransitionManager.beginDelayedTransition(holder.par);
            holder.expandedReLayout.setVisibility(View.VISIBLE);
            holder.downArrow.setVisibility(View.GONE);

            if(parentActivity.equals("allBooks")){
                holder.btnDelete.setVisibility(View.GONE);
            }else if(parentActivity.equals("alreadyRead")){
                holder.btnDelete.setVisibility(View.VISIBLE);
                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                     /*   if(Utils.getInstance().removeAlreadyRead(books.get(mLastPosition))){
                            Toast.makeText(v.getContext(),"Removed",Toast.LENGTH_SHORT).show();
                            notifyDataSetChanged();
                        }else{
                            Toast.makeText(v.getContext(),"Wrong, Try Again",Toast.LENGTH_SHORT).show();
                        }*/

                        AlertDialog.Builder builer = new AlertDialog.Builder(v.getContext());
                        builer.setMessage("Are you sure want to delete" + books.get(mLastPosition).getName()+ "?");
                        builer.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if(Utils.getInstance().removeAlreadyRead(books.get(mLastPosition))){
                                    Toast.makeText(v.getContext(),"Book Removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }
                            }
                        });

                        builer.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        builer.create().show();
                    }
                });
            }else if(parentActivity.equals("wantToRead")){
                holder.btnDelete.setVisibility(View.VISIBLE);
                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog.Builder builer = new AlertDialog.Builder(v.getContext());
                        builer.setMessage("Are you sure want to delete" + books.get(mLastPosition).getName()+ "?");
                        builer.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if(Utils.getInstance().removeWantToRead(books.get(mLastPosition))){
                                    Toast.makeText(v.getContext(),"Book Removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }
                            }
                        });

                        builer.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        builer.create().show();
                    }
                });
            }else if(parentActivity.equals("favoriteRead")){
                holder.btnDelete.setVisibility(View.VISIBLE);
                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog.Builder builer = new AlertDialog.Builder(v.getContext());
                        builer.setMessage("Are you sure want to delete" + books.get(mLastPosition).getName()+ "?");
                        builer.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if(Utils.getInstance().removeFavoriteRead(books.get(mLastPosition))){
                                    Toast.makeText(v.getContext(),"Book Removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }
                            }
                        });

                        builer.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        builer.create().show();
                    }
                });
            }else if(parentActivity.equals("currentlyRead")){
                holder.btnDelete.setVisibility(View.VISIBLE);
                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog.Builder builer = new AlertDialog.Builder(v.getContext());
                        builer.setMessage("Are you sure want to delete" + books.get(mLastPosition).getName()+ "?");
                        builer.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if(Utils.getInstance().removeCurrentlyRead(books.get(mLastPosition))){
                                    Toast.makeText(v.getContext(),"Book Removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }
                            }
                        });

                        builer.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        builer.create().show();
                    }
                });
            }else {

            }

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

        private TextView btnDelete;

        private ConstraintLayout parent;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imv = itemView.findViewById(R.id.imv_avatar);
            tv_name = itemView.findViewById(R.id.tv_name);
            downArrow = itemView.findViewById(R.id.btnDownArro);
            upArrow = itemView.findViewById(R.id.btnUpArrow);
            expandedReLayout = itemView.findViewById(R.id.expandedReLayout);

            txtAuthor = itemView.findViewById(R.id.authorText);
            txtDescription = itemView.findViewById(R.id.shortDes);

            btnDelete = itemView.findViewById(R.id.btnDelete);

            parent = itemView.findViewById(R.id.root);

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

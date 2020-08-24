package com.example.searchbooks.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.searchbooks.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.ItemViewHolder> {

    private ArrayList<ItemBookList> list;
    private Context context;
    private OnItemClickListener itemClickListener;

    public BookListAdapter(Context context, ArrayList<ItemBookList> list, OnItemClickListener itemClickListener){
        this.context = context;
        this.list = list;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_view, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ItemBookList currentBook = list.get(position);
        Picasso.get().load(currentBook.getImage()).placeholder(R.mipmap.ic_launcher).into(holder.imageBook);
        String title = context.getString(R.string.item_title) + currentBook.getTitle();
        holder.titleBook.setText(title);
        String subTitle = context.getString(R.string.item_subtitle) + currentBook.getSubTitle();
        holder.subTitleBook.setText(subTitle);
        String price = context.getString(R.string.item_price) + currentBook.getPrice();
        holder.priceBook.setText(price);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface OnItemClickListener{
        void onItemClick(String idBook);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imageBook;
        private TextView titleBook;
        private TextView subTitleBook;
        private TextView priceBook;

        public ItemViewHolder(View view){
            super(view);
            imageBook = view.findViewById(R.id.image_book);
            titleBook = view.findViewById(R.id.title);
            subTitleBook = view.findViewById(R.id.subTitle);
            priceBook = view.findViewById(R.id.price);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            ItemBookList currentBook = list.get(getAdapterPosition());
            itemClickListener.onItemClick(currentBook.getId());
        }
    }
}

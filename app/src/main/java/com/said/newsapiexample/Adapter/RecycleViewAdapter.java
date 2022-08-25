package com.said.newsapiexample.Adapter;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.said.newsapiexample.Details.News;
import com.said.newsapiexample.R;
import com.squareup.picasso.Picasso;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    public News news;

    public RecycleViewAdapter(News news) {
        this.news = news;
    }

    @NonNull
    @Override
    public RecycleViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.news_row,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewAdapter.MyViewHolder holder, int position) {

        holder.newTitle.setText(news.getNews().get(position).title);
        holder.newSite.setText(news.getNews().get(position).author);
        holder.newsDate.setText(news.getNews().get(position).newsDate.substring(11,16));
        Picasso.get().load(news.getNews().get(position).imageUrl).into(holder.newsImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse(news.getNews().get(position).url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);

                holder.itemView.getContext().startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return news.getNews().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView newTitle, newSite,newsDate;
        ImageView newsImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            newTitle=itemView.findViewById(R.id.newTitle);
            newSite=itemView.findViewById(R.id.newsSite);
            newsImage=itemView.findViewById(R.id.imageView);
            newsDate=itemView.findViewById(R.id.newsDate);

        }
    }
}

package com.example.newsapp1.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp1.R;
import com.example.newsapp1.viewModel.Articles;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<Articles> mDataset;
    private  Context context;
    private Listener listener;


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public CardView mCardView;
        public TextView mTextView,msubtitle;
        public ImageView imageView;
        public MyViewHolder(View v){
            super(v);

            mCardView = (CardView) v.findViewById(R.id.card_view);
            mTextView = (TextView) v.findViewById(R.id.title_text);
            msubtitle = v.findViewById(R.id.subtitle);
            imageView = v.findViewById(R.id.iv_image);


        }

    }

    public MyAdapter(ArrayList<Articles> articleList, Context context,Listener listener){
        mDataset = articleList;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        holder.mTextView.setText(mDataset.get(position).getAuthor());
        holder.msubtitle.setText(mDataset.get(position).getDescription());
        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        String imgUrl = mDataset.get(position).getUrlToImage();

        if(!TextUtils.isEmpty(imgUrl)){
            Picasso.get()
                    .load(imgUrl)
                    .resize(1280, 720)
                    .noFade()
                    .into(holder.imageView);
        }

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              listener.onItemClickListener(mDataset.get(position));
            }
        });
    }

    @Override
    public int getItemCount() { return mDataset.size(); }

    public interface  Listener{
        void onItemClickListener(Articles articles);
    }

}
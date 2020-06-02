package com.example.newsapp1.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp1.R;
import com.example.newsapp1.WebViewActivity;
import com.example.newsapp1.adapter.MyAdapter;
import com.example.newsapp1.viewModel.Articles;

import java.util.ArrayList;

public class OneFragment extends Fragment implements MyAdapter.Listener{
    ArrayList<Articles> articlesList;
    public OneFragment(ArrayList<Articles> articlesList) {
        // Required empty public constructor
        this.articlesList = articlesList;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_one, container, false);

        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view);
        rv.setHasFixedSize(true);
        MyAdapter adapter = new MyAdapter(articlesList,getContext(),this);
        rv.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        return rootView;
    }

    @Override
    public void onItemClickListener(Articles articles) {
        Toast.makeText(getContext().getApplicationContext(),"onItemClickListener get called",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getActivity().getApplicationContext(), WebViewActivity.class);
        intent.putExtra(WebViewActivity.kEY,articles.getUrl());
        startActivity(intent);
    }
}

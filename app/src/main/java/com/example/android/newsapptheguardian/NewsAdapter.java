package com.example.android.newsapptheguardian;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(@NonNull Context context, ArrayList<News> newsList) {
        super(context, 0, newsList);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        News currentNews = getItem(position);

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.news_list_item, parent, false);
        }

        String trimmedDate = currentNews.getDate().substring(0, 10);

        TextView tvTitle = (TextView) view.findViewById(R.id.title);
        tvTitle.setText(currentNews.getTitle());

        TextView tvAuthor = (TextView) view.findViewById(R.id.author);
        tvAuthor.setText(currentNews.getAuthor());

        TextView tvSection = (TextView) view.findViewById(R.id.section);
        tvSection.setText(currentNews.getSection());

        TextView tvDate = (TextView) view.findViewById(R.id.date);
        tvDate.setText(trimmedDate);

        return view;
    }

}

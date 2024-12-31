package com.one.apicall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.one.apicall.databinding.CardViewBinding;
import com.one.apicall.room.Quote;

import java.util.ArrayList;
import java.util.List;

public class NewAdapter extends RecyclerView.Adapter<NewAdapter.ViewHolder> {

    List<Quote> Quote;
    Context context;

    public NewAdapter(List<com.one.apicall.room.Quote> quote, Context context) {
        Quote = quote;
        this.context = context;
    }

    @NonNull
    @Override
    public NewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardViewBinding cardViewBinding = CardViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new NewAdapter.ViewHolder(cardViewBinding);
    }


    @Override
    public void onBindViewHolder(@NonNull NewAdapter.ViewHolder holder, int position) {

        Quote quote = Quote.get(position);
        holder.cardViewBinding.author.setText(quote.getAuthor());
        holder.cardViewBinding.quote.setText(quote.getQuote());
    }
    @Override
    public int getItemCount() {
        return Quote.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CardViewBinding cardViewBinding;

        public ViewHolder(CardViewBinding cardViewBinding) {
            super(cardViewBinding.getRoot());
            this.cardViewBinding = cardViewBinding;        }
    }
}

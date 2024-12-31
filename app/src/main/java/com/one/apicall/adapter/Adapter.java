package com.one.apicall.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.one.apicall.activity.SubquoteActivity;
import com.one.apicall.databinding.CardViewBinding;
import com.one.apicall.model.ApiModel;
import com.one.apicall.room.Quote;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    List<ApiModel> model;
    Context context;

    public Adapter(List<ApiModel> model, Context context) {
        this.model = model;
        this.context = context;
    }


    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {
        CardViewBinding cardViewBinding = CardViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(cardViewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ApiModel apiModel = model.get(position);
        holder.cardViewBinding.author.setText(apiModel.getAuthor());
        holder.cardViewBinding.quote.setText(apiModel.getQuote());

        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(context, "quote number" + position, Toast.LENGTH_SHORT).show();
            Intent i = new Intent(context, SubquoteActivity.class);
            i.putExtra("position", position);
            context.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardViewBinding cardViewBinding;

        public ViewHolder(CardViewBinding cardViewBinding) {
            super(cardViewBinding.getRoot());
            this.cardViewBinding = cardViewBinding;
        }
    }
}

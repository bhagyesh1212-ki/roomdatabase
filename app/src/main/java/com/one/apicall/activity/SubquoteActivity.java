package com.one.apicall.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.one.apicall.R;
import com.one.apicall.Utils;
import com.one.apicall.databinding.ActivitySubquoteBinding;

public class SubquoteActivity extends AppCompatActivity {
    ActivitySubquoteBinding binding;

    int position = 0;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivitySubquoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        position = getIntent().getIntExtra("position", 0);
        binding.quote.setText(Utils.model.get(position).getQuote());
        binding.author.setText(Utils.model.get(position).getAuthor());
        binding.previous.setOnClickListener(v -> {
            if (position > 0) {
                binding.quote.setText(Utils.model.get(position--).getQuote());
                binding.author.setText(Utils.model.get(position--).getAuthor());
            }
        });

        binding.next.setOnClickListener(v -> {
            if (position < Utils.model.size()-1) {
                binding.quote.setText(Utils.model.get(position++).getQuote());
                binding.author.setText(Utils.model.get(position++).getAuthor());
            }
        });
    }
}
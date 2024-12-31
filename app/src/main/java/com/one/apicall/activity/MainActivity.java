package com.one.apicall.activity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.one.apicall.ApiInterface;
import com.one.apicall.R;
import com.one.apicall.adapter.NewAdapter;
import com.one.apicall.databinding.ActivityMainBinding;
import com.one.apicall.room.Quote;
import com.one.apicall.room.QuoteRepository;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ApiInterface apiInterface;
    NewAdapter adapter;
    Handler handler = new Handler();

    //    List<ApiModel> alldata = new ArrayList<>();
//    ArrayList<ApiModel> displaydata = new ArrayList<>();
    private QuoteRepository quoteRepository;
    List<Quote> quote;

    private int curruntindex = 0;
    private static final int objectsize = 20;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        quoteRepository = new QuoteRepository(getApplication());
        quote = new ArrayList<>();

//        ApiInterface apiInterfacee = ApiClient.getClient().create(ApiInterface.class);
//        Call<ArrayList<Quote>> modelCall = apiInterfacee.getquote();
//        modelCall.enqueue(new Callback<ArrayList<Quote>>() {
//            @Override
//            public void onResponse(Call<ArrayList<Quote>> call, Response<ArrayList<Quote>> response) {
//                if (response.isSuccessful() && response.body() != null) {
//                    List<Quote> quoteList = response.body();
//                    quoteRepository.insert(quoteList);
//                    quoteRepository.getall().observe(MainActivity.this, new Observer<List<Quote>>() {
//                        @Override
//                        public void onChanged(List<Quote> quoteList) {
//                            quote.clear();
//                            quote.addAll(quoteList);
//                            Log.d("TAG@@", "onResponse: "+quote);
//                            adapter.notifyDataSetChanged();
//                        }
//                    });
//                } else {
//                    Toast.makeText(MainActivity.this, "Failed to fetch quotes", Toast.LENGTH_SHORT).show();
//                }
////                binding.main.setRefreshing(false);
//            }
//            @Override
//            public void onFailure(Call<ArrayList<Quote>> call, Throwable throwable) {
//                Toast.makeText(MainActivity.this, "API call failed", Toast.LENGTH_SHORT).show();
//            }
//        });

//        modelCall.enqueue(new Callback<ArrayList<ApiModel>>() {
//            @Override
//            public void onResponse(Call<ArrayList<ApiModel>> call, Response<ArrayList<ApiModel>> response) {
//                if (response.isSuccessful() && response.body() != null) {
//                    alldata.addAll(response.body());
//                    Utils.model = response.body();
//                    refreshQuotes();
//                } else {
//                    Toast.makeText(MainActivity.this, "Failed to fetch quotes", Toast.LENGTH_SHORT).show();
//                }
//                binding.main.setRefreshing(false);
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<ApiModel>> call, Throwable throwable) {
//                Toast.makeText(MainActivity.this, "Failed ", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        binding.main.setOnRefreshListener(() -> {
//                    refreshQuotes();
//                    binding.main.setRefreshing(false);
//                }
//        );

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                quoteRepository.insertdata();
                quoteRepository.quoteDao.getAll().observe(MainActivity.this, quote -> {
//                    for (int i = 0; i < quote.size(); i++) {

                        NewAdapter newAdapter = new NewAdapter(quote, MainActivity.this);
                        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
                        binding.rcv.setLayoutManager(layoutManager);
                        binding.rcv.setAdapter(newAdapter);
//                        Log.i("TAG@@@@", "onCreate: " + quote.get(i).getQuote());
//                        Log.i("TAG@@@@", "onCreate: " + quote.get(i).getAuthor());

                   // }
                });
            }
        }, 1000);
    }

//    @SuppressLint("NotifyDataSetChanged")
//    private void refreshQuotes() {
//        if (alldata.isEmpty()) {
//            Toast.makeText(this, "No data available", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        curruntindex = (curruntindex + objectsize) % alldata.size();
//        int endIndex = Math.min(curruntindex + objectsize, alldata.size());
//        displaydata.clear();
//        displaydata.addAll(alldata.subList(curruntindex, endIndex));
//        adapter.notifyDataSetChanged();
    //  }
}

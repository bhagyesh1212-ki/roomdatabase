package com.one.apicall.room;
import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.one.apicall.ApiClient;
import com.one.apicall.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuoteRepository {
    private AppDatabase appDatabase;
    private LiveData<List<Quote>> getall;
    public  QuoteDao quoteDao;
    private ApiInterface apiInterface;
    private ArrayList<Quote> quote = new ArrayList<>();

    public QuoteRepository(Application application) {
        appDatabase = AppDatabase.getInstance(application);
        getall = appDatabase.quoteDao().getAll();
        quoteDao = appDatabase.quoteDao();

    }

    public void insertdata(){
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ArrayList<Quote>> call = apiInterface.getquote();
        call.enqueue(new Callback<ArrayList<Quote>>() {
            @Override
            public void onResponse(Call<ArrayList<Quote>> call, Response<ArrayList<Quote>> response) {
                quote = response.body();
                quoteDao.insertAll(quote);
            }

            @Override
            public void onFailure(Call<ArrayList<Quote>> call, Throwable throwable) {
                Log.d("TAG", "onFailure: "+throwable);
            }
        });
        quoteDao.getAll();
    }



//    public void insert(List<Quote> quoteList) {
//        new InsertAsync(appDatabase).execute(quoteList);
//    }
//
//    public LiveData<List<Quote>> getall() {
//        return getall;
//    }
//
//    static class InsertAsync extends AsyncTask<List<Quote>, Void, Void> {
//        private  QuoteDao quoteDao;
//
//        public InsertAsync(AppDatabase appDatabase) {
//            quoteDao = appDatabase.quoteDao();
//        }
//
//        @Override
//        protected Void doInBackground(List<Quote>... lists) {
//            quoteDao.insertAll(lists[0]);
//            return null;
//        }
//    }
}

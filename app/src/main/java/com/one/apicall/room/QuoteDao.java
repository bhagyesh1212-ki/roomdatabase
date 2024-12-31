package com.one.apicall.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface QuoteDao {

    @Insert
    void insertAll(List<Quote> quotes);

    @Query("SELECT * FROM quotes")
    LiveData<List<Quote>> getAll();

}

package com.one.apicall.room;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "quotes")
public class Quote {

        @PrimaryKey(autoGenerate = true)
        private int uid;

        @ColumnInfo(name = "quote")
        private String quote;

        @ColumnInfo(name = "author")
        private String author;

        public Quote(String author, String quote, int uid) {
                this.author = author;
                this.quote = quote;
                this.uid = uid;
        }

        public int getUid() {
                return uid;
        }

        public void setUid(int uid) {
                this.uid = uid;
        }

        public String getAuthor() {
                return author;
        }

        public void setAuthor(String author) {
                this.author = author;
        }

        public String getQuote() {
                return quote;
        }

        public void setQuote(String quote) {
                this.quote = quote;
        }
}

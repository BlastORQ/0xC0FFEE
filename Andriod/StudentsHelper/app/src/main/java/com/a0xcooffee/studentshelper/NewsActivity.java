package com.a0xcooffee.studentshelper;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import java.util.ArrayList;


public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.news_list);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ListView view = (ListView) findViewById(R.id.simpleListView);
                    ApiHelper helper = new ApiHelper();
                    ArrayList<News> data = helper.getNewsList();
                    view.setAdapter(new NewsListAdapter(NewsActivity.this, data));
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        super.onCreate(savedInstanceState);
    }
}

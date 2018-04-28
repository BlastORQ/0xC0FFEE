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
        ListView view = (ListView) findViewById(R.id.simpleListView);

        ArrayList<News> data = new ArrayList<News>();

        for(int i = 0;i<10;i++){
            data.add(new News("Гурток бальних танців розшукує вбивцю", "Учасники бальних танців були шоковані....\n Читати далі", ""));
        }

        view.setAdapter(new NewsListAdapter(this, data));
        super.onCreate(savedInstanceState);
    }
}

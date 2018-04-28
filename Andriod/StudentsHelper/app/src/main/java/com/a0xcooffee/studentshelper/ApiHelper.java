package com.a0xcooffee.studentshelper;

import android.support.annotation.ArrayRes;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ApiHelper {

    public String getNewsTitle() throws Exception{
        return get("http://coffee.in/API/Dashboard.get");
    }



    public ArrayList<News> getNewsList() throws Exception{
        String json = get("http://coffee.in/API/Feed.get");
        JSONArray object = new JSONArray(json);
        ArrayList<News> newsList = new ArrayList<News>();
        for(int i = 0;i<object.length();i++){
            JSONObject el = (JSONObject) object.get(i);
            String img_url = "";
            try {
                img_url = el.getString("image");
            }catch (Exception e){

            }
            News news = new News(new String(el.getString("title").getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8) , new String(el.getString("text").getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8), img_url);
            newsList.add(news);
        }
        return newsList;
    }
    private static String get(String uri)throws Exception{
        URL url = new URL(uri);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "KateMobileAndroid/43-414 (Android 5.1; SDK 22; x86; unknown ANDROID_LOLIPOPKA; en)");
        connection.connect();
        CookieHandler.setDefault( new CookieManager( null, CookiePolicy.ACCEPT_ALL ) );
        BufferedReader br;
        if (200 <= connection.getResponseCode() && connection.getResponseCode() <= 299) {
            br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } else {
            br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
        }
        String out = "", output;
        while ((output = br.readLine()) != null) {
            out = output.concat(out);
        }
        return out;
    }
}

package com.a0xcooffee.studentshelper;

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

public class ApiHelper {

    static String json = "{\"calendar\":[{\"id\":1257923,\"time\":[1524871938945,1524871902345],\"title\":\"\\u0414\\u0438\\u0441\\u043a\\u0440\\u0435\\u0442\\u043d\\u0430 \\u043c\\u0435\\u0442\\u0435\\u043c\\u0430\\u0442\\u0438\\u043a\\u0430\",\"text\":\"\\u041046, \\u0414\\u0443\\u043c\\u0430\\u043d\\u0441\\u044c\\u043a\\u0438\\u0439 \\u041e. \\u0406.\",\"calendar\":\"lessons\"},{\"id\":2747263,\"time\":[1524871958945,1524871992345],\"title\":\"\\u0412\\u043f\\u0438\\u0441\\u043a\\u0430 \\u0443 \\u041c\\u0430\\u0440\\u043a\\u0430\",\"text\":\"+380 98 765 4321\",\"calendar\":\"leisure\"}],\"sleep\":{\"mean\":28743,\"condition\":70},\"news\":[{\"id\":1,\"title\":\"\\u0442\\u0435\\u0441\\u0442 1\",\"text\":\"\\u041f\\u043e\\u043a\\u0430\\u0434\\u0440\\u043e\\u0432\\u0430\\u044f \\u0430\\u043d\\u0438\\u043c\\u0430\\u0446\\u0438\\u044f \\u2014 \\u043d\\u0435\\u0432\\u0435\\u0440\\u043e\\u044f\\u0442\\u043d\\u043e \\u043a\\u0440\\u043e\\u043f\\u043e\\u0442\\u043b\\u0438\\u0432\\u0430\\u044f \\u0438 \\u0441\\u043b\\u043e\\u0436\\u043d\\u0430\\u044f \\u0440\\u0443\\u0447\\u043d\\u0430\\u044f \\u0440\\u0430\\u0431\\u043e\\u0442\\u0430, \\u043a\\u043e\\u0442\\u043e\\u0440\\u0430\\u044f \\u0443\\u0434\\u0438\\u0432\\u043b\\u044f\\u0435\\u0442 \\u0441\\u0432\\u043e\\u0438\\u043c \\u043f\\u0440\\u043e\\u0446\\u0435\\u0441\\u0441\\u043e\\u043c \\u0441\\u043e\\u0437\\u0434\\u0430\\u043d\\u0438\\u044f.\",\"date\":\"22:27 27.04.2018\",\"category\":\"main\",\"tags\":[\"important\"]},{\"id\":2,\"title\":\"\\u0442\\u0435\\u0441\\u0442 2\",\"text\":\"\\u0422\\u0430\\u043a\\u0438\\u043c \\u043e\\u0431\\u0440\\u0430\\u0437\\u043e\\u043c, \\u043b\\u044e\\u0434\\u0438, \\u0437\\u0430\\u043d\\u0438\\u043c\\u0430\\u044e\\u0449\\u0438\\u0435\\u0441\\u044f \\u043f\\u0440\\u043e\\u0438\\u0437\\u0432\\u043e\\u0434\\u0441\\u0442\\u0432\\u043e\\u043c \\u043f\\u043e\\u043a\\u0430\\u0434\\u0440\\u043e\\u0432\\u044b\\u0445 \\u043c\\u0443\\u043b\\u044c\\u0442\\u0444\\u0438\\u043b\\u044c\\u043c\\u043e\\u0432, \\u0434\\u0435\\u0439\\u0441\\u0442\\u0432\\u0438\\u0442\\u0435\\u043b\\u044c\\u043d\\u043e \\u0432\\u0441\\u0435\\u0439 \\u0434\\u0443\\u0448\\u043e\\u0439 \\u043b\\u044e\\u0431\\u044f\\u0442 \\u044d\\u0442\\u043e, \\u0438\\u043d\\u0430\\u0447\\u0435 \\u0438\\u043c \\u0431\\u044b \\u043d\\u0435 \\u0445\\u043e\\u0442\\u0435\\u043b\\u043e\\u0441\\u044c \\u0442\\u0440\\u0430\\u0442\\u0438\\u0442\\u044c \\u0441\\u0442\\u043e\\u043b\\u044c\\u043a\\u043e \\u0441\\u0438\\u043b. \",\"date\":\"22:27 27.04.2018\",\"category\":\"main\",\"tags\":[\"important\"]}]}";
    public static void main(String[] args) {

        try {
            JSONObject object = new JSONObject(json);
            JSONArray array =  object.getJSONArray("news");

            /*for(Object element : array){

            }*/
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public String getNewsTitle() throws Exception{
        return get("http://coffee.in/API/Dashboard.get");
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

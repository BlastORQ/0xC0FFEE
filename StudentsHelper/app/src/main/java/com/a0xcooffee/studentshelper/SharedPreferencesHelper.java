package com.a0xcooffee.studentshelper;


import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesHelper {

    private SharedPreferences sharedPref = null;

    public SharedPreferencesHelper(Context context, String preferenceName){
        sharedPref = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
    }

    public void writeString(String key, String value){
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        editor.apply();
    }
    public String getPreferenceString(String key){
        return sharedPref.getString(key, "");
    }

}

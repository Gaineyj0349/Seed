package com.gainwise.seed;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String num = "4654654";

        Toast.makeText(this, addDelimiter(num), Toast.LENGTH_SHORT).show();


    }

    public <T> String joinToString(List<T> list, String delimeter) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i< list.size(); i++) {
            if (i > 0) {
                result.append(delimeter);
            }
            result.append(String.valueOf(list.get(i)));
        }
        return result.toString();
    }

    public static String addDelimiter(String str){
        if(str == null){
            return "";
        }
        StringBuffer resultStr = new StringBuffer();
        for(int i = 0; i < str.toCharArray().length; i++){
            if(i > 0){
                resultStr.append("|");
            }
            resultStr.append(str.toCharArray()[i]);
        }
        Log.d("Demiliter Add : " , resultStr.toString());
        return resultStr.toString();
    }
}
package com.example.oumaima.atb_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ConsulterSoldeActivity extends AppCompatActivity {

    ListView myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulter_solde);

        myList = findViewById(R.id.listAccount);

        final ArrayList<Account> accountArrayList = new ArrayList<>();
        SharedPreferences prefs = getSharedPreferences("login", MODE_PRIVATE);
        String uid = prefs.getString("idUser", "");

        Ion.with(this)
                .load("http://192.168.1.40/ATB/allAccounts.php?id="+uid)
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {

                        if(e != null){
                            Toast.makeText(ConsulterSoldeActivity.this, "Impossible de connecter", Toast.LENGTH_SHORT).show();
                        }else{

                            Gson convert = new Gson();
                            Account[] accounts = convert.fromJson(result.toString(), Account[].class);
                            for(Account account : accounts){
                                accountArrayList.add(account);
                            }

                            AdapterAccount adapterAccount = new AdapterAccount(ConsulterSoldeActivity.this, R.layout.account_item, accountArrayList );
                            myList.setAdapter(adapterAccount);
                        }


                    }
                });


    }



}

package com.example.oumaima.atb_app;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;

public class HistoriqueActivity extends AppCompatActivity {


    ListView myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historique);

        myList = findViewById(R.id.listHisto);

        final ArrayList<Historique> historiques = new ArrayList<>();
        SharedPreferences prefs = getSharedPreferences("login", MODE_PRIVATE);
        String uid = prefs.getString("idUser", "");

        Ion.with(this)
                .load("http://192.168.1.40/ATB/allHistorique.php?id="+uid)
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {

                        if(e != null){
                            Toast.makeText(HistoriqueActivity.this, "Impossible de connecter", Toast.LENGTH_SHORT).show();
                        }else{

                            Gson convert = new Gson();
                            Historique[] historiques1 = convert.fromJson(result.toString(), Historique[].class);
                            for(Historique historique : historiques1){
                                historiques.add(historique);
                            }

                            AdapterHistorique adapterAccount = new AdapterHistorique(HistoriqueActivity.this, R.layout.historique_item, historiques );
                            myList.setAdapter(adapterAccount);
                        }


                    }
                });


    }
}

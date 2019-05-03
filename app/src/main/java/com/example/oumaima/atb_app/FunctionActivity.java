package com.example.oumaima.atb_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class FunctionActivity extends AppCompatActivity {

    CardView consulter_solde,historique,demande_virement,demande_chequier,mise_opposition_chequier,demande_carte,mise_opposition_carte,deconnexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function);


        consulter_solde=(CardView) findViewById(R.id.consulter_solde);
        historique=(CardView) findViewById(R.id.historique);
        demande_virement=(CardView) findViewById(R.id.demande_virement);
        demande_chequier=(CardView) findViewById(R.id.demande_chequier);
        mise_opposition_chequier=(CardView) findViewById(R.id.mise_opposition_chequier);
        demande_carte=(CardView) findViewById(R.id.demande_carte);
        mise_opposition_carte=(CardView) findViewById(R.id.mise_opposition_carte);
        deconnexion=(CardView) findViewById(R.id.deconnexion);

        consulter_solde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FunctionActivity.this,ConsulterSoldeActivity.class);
                startActivity(intent);
            }
        });

        historique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FunctionActivity.this,HistoriqueActivity.class);
                startActivity(intent);
            }
        });
        demande_virement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FunctionActivity.this,DemandeVirementActivity.class);
                startActivity(intent);
            }
        });
        demande_chequier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FunctionActivity.this,DemandeChequierActivity.class);
                startActivity(intent);
            }
        });
        mise_opposition_chequier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FunctionActivity.this,MiseOnOppositionChequierActivity.class);
                startActivity(intent);
            }
        });
        demande_carte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FunctionActivity.this,DemandeCarteActivity.class);
                startActivity(intent);
            }
        });
        mise_opposition_carte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FunctionActivity.this,MiseEnOppositionCarteActivity.class);
                startActivity(intent);
            }
        });

        deconnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FunctionActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });



    }
}

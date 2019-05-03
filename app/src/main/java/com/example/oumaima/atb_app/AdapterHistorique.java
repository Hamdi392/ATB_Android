package com.example.oumaima.atb_app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterHistorique extends ArrayAdapter<Historique>{
    private ArrayList<Historique> accounts;
    private int item;
    private Context ctx;
    public AdapterHistorique(@NonNull Context context, int resource, @NonNull ArrayList<Historique> objects) {
        super(context, resource, objects);
        this.accounts = objects;
        this.item = resource;
        this.ctx = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = LayoutInflater.from(ctx).inflate(item, parent, false);

        TextView date = convertView.findViewById(R.id.datehisto);
        TextView montant = convertView.findViewById(R.id.montanthisto);
        TextView type = convertView.findViewById(R.id.typehisto);
        TextView rib = convertView.findViewById(R.id.ribhisto);

        Historique historique = getItem(position);
        date.setText(historique.getDate_transaction());
        montant.setText(historique.getMontant());
        type.setText(historique.getType_transaction());
        rib.setText(historique.getRIB());

        return convertView;
    }
}

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

public class AdapterAccount extends ArrayAdapter<Account>{

    private ArrayList<Account> accounts;
    private int item;
    private Context ctx;
    public AdapterAccount(@NonNull Context context, int resource, @NonNull ArrayList<Account> objects) {
        super(context, resource, objects);
        this.accounts = objects;
        this.item = resource;
        this.ctx = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = LayoutInflater.from(ctx).inflate(item, parent, false);

        TextView solde = convertView.findViewById(R.id.soldeaccount);
        TextView devise = convertView.findViewById(R.id.deviseaccount);
        TextView type = convertView.findViewById(R.id.typeaccount);
        TextView rib = convertView.findViewById(R.id.ribaccount);

        Account account = getItem(position);
        solde.setText(account.getSolde());
        devise.setText(account.getDevise_account());
        type.setText(account.getType_account());
        rib.setText(account.getRIB());

        return convertView;
    }
}

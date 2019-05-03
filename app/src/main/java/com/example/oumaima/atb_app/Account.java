package com.example.oumaima.atb_app;

public class Account {

    private String RIB;
    private String solde;
    private String devise_account;
    private String type_account;


    public Account() {
    }


    public Account(String rib, String solde, String devise, String type) {
        RIB = rib;
        this.solde = solde;
        devise_account = devise;
        type_account = type;
    }

    public String getRIB() {
        return RIB;
    }

    public void setRIB(String RIB) {
        this.RIB = RIB;
    }

    public String getSolde() {
        return solde;
    }

    public void setSolde(String solde) {
        this.solde = solde;
    }

    public String getDevise_account() {
        return devise_account;
    }

    public void setDevise_account(String devise_account) {
        this.devise_account = devise_account;
    }

    public String getType_account() {
        return type_account;
    }

    public void setType_account(String type_account) {
        this.type_account = type_account;
    }
}

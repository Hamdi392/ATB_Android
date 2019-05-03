package com.example.oumaima.atb_app;

public class Historique {

    private String RIB;
    private String type_transaction;
    private String date_transaction;
    private String montant;

    public Historique() {
    }

    public Historique(String RIB, String type_transaction, String date_transaction, String montant) {
        this.RIB = RIB;
        this.type_transaction = type_transaction;
        this.date_transaction = date_transaction;
        this.montant = montant;
    }

    public String getRIB() {
        return RIB;
    }

    public void setRIB(String RIB) {
        this.RIB = RIB;
    }

    public String getType_transaction() {
        return type_transaction;
    }

    public void setType_transaction(String type_transaction) {
        this.type_transaction = type_transaction;
    }

    public String getDate_transaction() {
        return date_transaction;
    }

    public void setDate_transaction(String date_transaction) {
        this.date_transaction = date_transaction;
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }
}

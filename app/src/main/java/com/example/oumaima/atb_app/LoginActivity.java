package com.example.oumaima.atb_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class LoginActivity extends AppCompatActivity {


    EditText UsernameEt, PasswordEt;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        UsernameEt = (EditText)findViewById(R.id.username_text);
        PasswordEt = (EditText)findViewById(R.id.password_text);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnLogin();
            }
        });
    }

    public void OnLogin() {
        String username = UsernameEt.getText().toString();
        String password = PasswordEt.getText().toString();

        final SharedPreferences.Editor editor = getSharedPreferences("login", MODE_PRIVATE).edit();

        Ion.with(this)
                .load("http://192.168.1.40/ATB/login.php?email="+username+"&password="+password)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        boolean res = result.get("reponse").getAsBoolean();

                        if(res){
                            String uid = result.get("id").toString();
                            editor.putString("idUser", uid);
                            editor.apply();
                            startActivity(new Intent(LoginActivity.this, FunctionActivity.class));
                        }else {
                            Toast.makeText(LoginActivity.this, "Compte invalide", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}

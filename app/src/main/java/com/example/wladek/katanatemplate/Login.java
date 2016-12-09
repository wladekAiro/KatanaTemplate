package com.example.wladek.katanatemplate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wladek.katanatemplate.custom.CustomActivity;

public class Login extends CustomActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        setTouchNClick(R.id.btnLogin);
        setTouchNClick(R.id.btnFb);
        setTouchNClick(R.id.btnTw);
        setTouchNClick(R.id.btnReg);
    }

    public void onClick(View v) {
        super.onClick(v);
        if (v.getId() != R.id.btnReg) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }
}

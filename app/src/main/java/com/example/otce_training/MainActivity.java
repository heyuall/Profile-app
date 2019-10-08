package com.example.otce_training;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import Login.Login;

public class MainActivity extends AppCompatActivity {
    private Button push;
    private EditText user_name;
    private EditText passwrd;
    RequestQueue mQueue;
    private Context mcontext;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mcontext = getApplicationContext();
        push = (Button) findViewById(R.id.button);
        user_name = (EditText) findViewById(R.id.editText);
        passwrd = (EditText) findViewById(R.id.editText);
        tv = (TextView)findViewById(R.id.textView);
        String user = user_name.toString();
        String Pass = passwrd.toString();
        mQueue = Volley.newRequestQueue(mcontext);


        push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = user_name.toString();
                String Pass = passwrd.toString();
                Login.login(user,Pass,tv,mQueue);

            }
        });
    }

    ;
}


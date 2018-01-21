package com.android.car.carreginaladmin.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.car.carreginaladmin.R;

/**
 * Created by keerthini on 15/01/18.
 */

public class LoginActivity extends AppCompatActivity {

private AutoCompleteTextView autoUserName;
private EditText editTextPwd;
private Button btnSignIn;
private TextView txtViewForgotPwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        autoUserName=(AutoCompleteTextView)findViewById(R.id.email);
        editTextPwd=(EditText)findViewById(R.id.password);
        btnSignIn=(Button)findViewById(R.id.email_sign_in_button);
        txtViewForgotPwd=(TextView)findViewById(R.id.forgotPwd);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!autoUserName.getText().toString().isEmpty()&& !editTextPwd.getText().toString().isEmpty())
                {
                    if(autoUserName.getText().toString().equals("admin")&& editTextPwd.getText().toString().equals("admin"))
                    {
                        Toast.makeText(getApplicationContext(),"You are signed in",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Please check your credentials",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });




    }
}

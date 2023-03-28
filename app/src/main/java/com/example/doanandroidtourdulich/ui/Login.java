package com.example.doanandroidtourdulich.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.doanandroidtourdulich.R;
import com.example.doanandroidtourdulich.MainActivity;
public class Login extends AppCompatActivity {
    Button btLogin, btRegister;
    EditText edUserNameC, edPasswordC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btLogin = findViewById(R.id.btLogin);
        btRegister=findViewById(R.id.btRegister);
        edUserNameC=findViewById(R.id.edUserName);
        edPasswordC=findViewById(R.id.edPassword);

        btLogin.setOnClickListener(nhanvaoLogin());
        btRegister.setOnClickListener(nhanvaoRegister());
    }

    @NonNull
    private View.OnClickListener nhanvaoRegister() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Login.this, Register.class);
                startActivity(i);
            }
        };
    }

    @NonNull
    private View.OnClickListener nhanvaoLogin() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUserNameC.getText().toString().trim();
                String password = edPasswordC.getText().toString().trim();
                if(checkUserName(username)&& checkPassword(password))
                {
                    Intent i= new Intent(Login.this, MainActivity.class);
                    startActivity(i);
                }
            }
        };
    }
    boolean checkUserName(String username){
        if(username.isEmpty()){
            edUserNameC.setError("Vui lòng nhập tên đăng nhập");
            return false;
        }
        return true;
    }
    boolean checkPassword(String password){
        if(password.isEmpty()){
            edUserNameC.setError("Vui lòng nhập mật khẩu");
            return false;
        }
        return true;
    }

}
package com.cursoandroid.easychool_v4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface typeface = Typeface.createFromAsset(this.getAssets(), "fonts/Amiko-Regular.ttf");

        TextView textView = findViewById(R.id.txt_title_criar_conta);
        TextView textView2 = findViewById(R.id.txt_possui_conta);
        Button btn = findViewById(R.id.btn_responsavel_aluno);
        Button btn2 = findViewById(R.id.btn_login);

        textView.setTypeface(typeface);
        textView2.setTypeface(typeface);
        btn.setTypeface(typeface);
        btn2.setTypeface(typeface);
    }

    public void Login(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void CadastroResponsavelAluno(View view){
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);
    }
}
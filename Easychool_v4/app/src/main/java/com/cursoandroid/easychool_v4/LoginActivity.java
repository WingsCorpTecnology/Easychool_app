package com.cursoandroid.easychool_v4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    TextView txtEmail, txtSenha;
    CheckBox cbManterConectado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Typeface typeface = Typeface.createFromAsset(this.getAssets(), "fonts/Amiko-Regular.ttf");

        txtEmail = findViewById(R.id.txt_email);
        txtSenha = findViewById(R.id.txtSenha);
        TextView textView6 = findViewById(R.id.txt_desc_login);
        TextView textView7 = findViewById(R.id.txt_title_login);
        cbManterConectado = findViewById(R.id.cb_manter_conectado);
        Button btn = findViewById(R.id.btn_login);

        txtEmail.setTypeface(typeface);
        txtSenha.setTypeface(typeface);
        textView6.setTypeface(typeface);
        textView7.setTypeface(typeface);
        cbManterConectado.setTypeface(typeface);
        btn.setTypeface(typeface);
    }

    public void telaInicial(View view){
        if(verificarText()) {
            if(validarFormatoEmail(txtEmail.getText().toString())) {
                /*Intent intent = new Intent(this, PrincipalActivity.class);
                startActivity(intent);*/
            }
            else mensagemEmailInvalido();
        }
        else mensagemCampoVazio();
    }

    public boolean verificarText(){
        boolean preenchido;

        if(txtSenha.getText().toString().trim().equals("")){
            preenchido = false;
        }
        else if(txtEmail.getText().toString().trim().equals("")){
            preenchido = false;
        }
        else if(cbManterConectado.isChecked() == false){
            preenchido = false;
        }
        else{
            preenchido = true;
        }
        return preenchido;
    }

    public void mensagemCampoVazio(){
        Toast.makeText(this, "Preencha os campos vazios para continuar", Toast.LENGTH_SHORT).show();
    }

    public void mensagemEmailInvalido(){
        Toast.makeText(this, "Digite um email válido", Toast.LENGTH_SHORT).show();
    }

    public boolean validarFormatoEmail(final String email){
        if(Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return true;
        }
        else return false;
    }
}
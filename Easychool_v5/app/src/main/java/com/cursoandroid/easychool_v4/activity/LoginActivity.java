package com.cursoandroid.easychool_v4.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.cursoandroid.easychool_v4.DAO.ResponsavelAlunoDAO;
import com.cursoandroid.easychool_v4.R;
import com.cursoandroid.easychool_v4.model.ResponsavelAluno;

public class LoginActivity extends AppCompatActivity {
    TextView txtEmail, txtSenha;
    CheckBox cbManterConectado;

    private ResponsavelAluno responsavelAluno;
    private ResponsavelAlunoDAO responsavelAlunoDAO;

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

        //Esconder a ActionBar
        getSupportActionBar().hide();

        responsavelAlunoDAO = new ResponsavelAlunoDAO(getApplicationContext());
    }

    public void telaInicial(View view){
        if(verificarText()) {
            if(validarFormatoEmail(txtEmail.getText().toString())) {
                if(validarUser()) {
                    Intent intent = new Intent(this, PrincipalActivity.class);
                    startActivity(intent);

                    Toast.makeText(getApplicationContext(), "Usuario logado", Toast.LENGTH_SHORT).show();

                    finish();
                }
                else mensagemUsuarioIncorreto();
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

    public void mensagemUsuarioIncorreto(){
        Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_SHORT).show();
    }

    public boolean validarFormatoEmail(final String email){
        if(Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return true;
        }
        else return false;
    }

    public boolean validarUser(){//Validação do Usuario
        /*if(responsavelAlunoDAO.login(txtEmail.getText().toString(), txtSenha.getText().toString())){
            return true;
        }
        else {
            return false;
        }*/
        return false;
    }
}

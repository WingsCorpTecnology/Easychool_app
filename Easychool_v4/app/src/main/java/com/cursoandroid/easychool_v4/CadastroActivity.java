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

public class CadastroActivity extends AppCompatActivity {
    TextView txtNome, txtEmail, txtTelefone, txtRg, txtCpf;
    CheckBox cbCondicaoUso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Typeface typeface = Typeface.createFromAsset(this.getAssets(), "fonts/Amiko-Regular.ttf");

        TextView textView = findViewById(R.id.txt_cadastro);
        TextView textView2 = findViewById(R.id.txt_desc_cadastro);
        txtNome = findViewById(R.id.txt_nome);
        txtEmail = findViewById(R.id.txt_email);
        txtTelefone = findViewById(R.id.txt_telefone);
        txtRg = findViewById(R.id.txt_rg);
        txtCpf = findViewById(R.id.txt_cpf);
        cbCondicaoUso = findViewById(R.id.cbCondicaoUso);
        Button btn = findViewById(R.id.btnCadastrar);

        textView.setTypeface(typeface);
        textView2.setTypeface(typeface);
        txtNome.setTypeface(typeface);
        txtEmail.setTypeface(typeface);
        txtTelefone.setTypeface(typeface);
        txtRg.setTypeface(typeface);
        txtCpf.setTypeface(typeface);
        cbCondicaoUso.setTypeface(typeface);
        btn.setTypeface(typeface);
    }

    public void telaIncial(View view){
        if(verificarText()){
            if(validarFormatoEmail(txtEmail.getText().toString())) {
                Intent intent = new Intent(this, CadastroSenhaActivity.class);
                startActivity(intent);
            }
            else mensagemEmailInvalido();
        }
        else mensagemCampoVazio();
    }

    public boolean verificarText(){
        boolean preenchido;

        if(txtRg.getText().toString().trim().equals("")){
            preenchido = false;
        }
        else if(txtCpf.getText().toString().trim().equals("")){
            preenchido = false;
        }
        else if(txtEmail.getText().toString().trim().equals("")){
            preenchido = false;
        }
        else if(txtTelefone.getText().toString().trim().equals("")){
            preenchido = false;
        }
        else if(txtNome.getText().toString().trim().equals("")){
            preenchido = false;
        }
        else if(cbCondicaoUso.isChecked() == false){
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
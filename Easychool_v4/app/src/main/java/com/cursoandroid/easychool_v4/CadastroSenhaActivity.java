package com.cursoandroid.easychool_v4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.cursoandroid.easychool_v4.DAO.ResponsavelAlunoDAO;
import com.cursoandroid.easychool_v4.model.ResponsavelAluno;

public class CadastroSenhaActivity extends AppCompatActivity {
    TextView txtConfirmarSenha, txtSenha;
    CheckBox cbCondicaoUso;

    private String nome, email, rg, cpf;

    private ResponsavelAluno responsavelAluno;
    private ResponsavelAlunoDAO responsavelAlunoDAO;
    private CadastroActivity cadastroActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_senha);

        Typeface typeface = Typeface.createFromAsset(this.getAssets(), "fonts/Amiko-Regular.ttf");

        TextView textView = findViewById(R.id.txt_title_cadastro_escola);
        TextView textView2 = findViewById(R.id.txt_desc_cadastro_escola);
        txtConfirmarSenha = findViewById(R.id.txt_confirmar_senha_escola);
        txtSenha = findViewById(R.id.txt_senha_escola);
        cbCondicaoUso = findViewById(R.id.cbCondicaoUso2);
        Button btn = findViewById(R.id.btn_cadastrar);

        textView.setTypeface(typeface);
        textView2.setTypeface(typeface);
        txtConfirmarSenha.setTypeface(typeface);
        txtSenha.setTypeface(typeface);
        cbCondicaoUso.setTypeface(typeface);
        btn.setTypeface(typeface);

        responsavelAlunoDAO = new ResponsavelAlunoDAO(getApplicationContext());
        cadastroActivity = new CadastroActivity();
        responsavelAluno = new ResponsavelAluno();

        //Esconder a ActionBar
        getSupportActionBar().hide();
    }

    public void login(View view){
        if(verificarText()) {
            if(senhasIguais()) {
                setarUser();

                if(responsavelAlunoDAO.insert(responsavelAluno, getApplicationContext())) {
                    Toast.makeText(getApplicationContext(), "Usuário salvo com sucesso!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(this, PrincipalActivity.class);
                    startActivity(intent);
                }
            }
            else mensagemSenhasDiferentes();
        }
        else mensagemCampoVazio();
    }

    public boolean verificarText(){
        boolean preenchido;

        if(txtConfirmarSenha.getText().toString().trim().equals("")){
            preenchido = false;
        }
        else if(txtSenha.getText().toString().trim().equals("")){
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

    public boolean senhasIguais(){
        if(txtSenha.getText().toString().equals(txtConfirmarSenha.getText().toString())){
            return true;
        }
        else{
            return false;
        }
    }

    public void mensagemCampoVazio(){
        Toast.makeText(this, "Preencha os campos vazios para continuar", Toast.LENGTH_SHORT).show();
    }

    public void mensagemSenhasDiferentes(){
        Toast.makeText(this, "As senhas estão diferentes, deixe-as iguais para continuar", Toast.LENGTH_SHORT).show();
    }

    public void setarUser(){
        //recuperar os dados da tela anterior
        nome = (String) getIntent().getSerializableExtra("nome");
        email = (String) getIntent().getSerializableExtra("email");
        rg = (String) getIntent().getSerializableExtra("rg");
        cpf = (String) getIntent().getSerializableExtra("cpf");

        responsavelAluno.setNome(nome);
        responsavelAluno.setRg(rg);
        responsavelAluno.setCpf(cpf);
        responsavelAluno.setEmail(email);
        responsavelAluno.setSenha(txtSenha.getText().toString());
    }
}
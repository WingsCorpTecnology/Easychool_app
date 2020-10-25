package com.cursoandroid.easychool_v4.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.cursoandroid.easychool_v4.model.ResponsavelAluno;

public class ResponsavelAlunoDAO {
    private DbHelper conexao;
    private SQLiteDatabase escrever;
    private SQLiteDatabase ler;

    public ResponsavelAlunoDAO(Context context){
        conexao = new DbHelper(context);
        escrever = conexao.getWritableDatabase();
        ler = conexao.getReadableDatabase();
    }

    public boolean insert(ResponsavelAluno responsavelAluno){
        ContentValues values = new ContentValues();

        values.put("nome", responsavelAluno.getNome());
        values.put("rg", responsavelAluno.getRg());
        values.put("cpf", responsavelAluno.getCpf());
        values.put("email", responsavelAluno.getEmail());
        values.put("senha", responsavelAluno.getSenha());

        try {
            escrever.insert(DbHelper.TABELA_RESPONSAVEL_ALUNO, null, values);
            Log.i("INFO", "Usuário salvo com sucesso!");
        } catch (Exception e){
            Log.e("INFO", "Erro ao salvar usuário " +e.getMessage());

            return false;
        }

        return true;
    }

    public boolean login(String email, String senha){


        return true;
    }
}
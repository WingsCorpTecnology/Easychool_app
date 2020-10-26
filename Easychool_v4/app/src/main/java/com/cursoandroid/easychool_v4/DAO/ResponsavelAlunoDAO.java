package com.cursoandroid.easychool_v4.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

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

    public boolean insert(ResponsavelAluno responsavelAluno, Context context){
        ContentValues values = new ContentValues();

        values.put("nome", responsavelAluno.getNome());
        values.put("rg", responsavelAluno.getRg());
        values.put("cpf", responsavelAluno.getCpf());
        values.put("email", responsavelAluno.getEmail());
        values.put("senha", responsavelAluno.getSenha());

        try {
            if(verificarCpfCadastrado(values.getAsString("cpf"))) {
                escrever.insert(DbHelper.TABELA_RESPONSAVEL_ALUNO, null, values);
                Log.i("INFO", "Usuário salvo com sucesso!");
            }
            else{
                Toast.makeText(context, "CPF já cadastrado!", Toast.LENGTH_SHORT).show();

                return false;
            }
        } catch (Exception e){
            Log.e("INFO", "Erro ao salvar usuário " +e.getMessage());

            return false;
        }

        return true;
    }

    public boolean login(String email, String senha){
        ContentValues values = new ContentValues();

        values.put("nome", email);
        values.put("senha", senha);

        try{
            String sql = "SELECT email, senha FROM " +DbHelper.TABELA_RESPONSAVEL_ALUNO+ " WHERE email like ? AND senha like ?";

            ler.rawQuery(sql, new String[] { email, senha});
        } catch (Exception e){
            Log.e("INFO", "Erro ao pesquisar usuário" +e.getMessage());

            return false;
        }

        return true;
    }

    public boolean verificarCpfCadastrado(String cpf){
        ContentValues values = new ContentValues();

        values.put("cpf", cpf);

        try{
            String sql = "SELECT cpf FROM " +DbHelper.TABELA_RESPONSAVEL_ALUNO+ " WHERE cpf LIKE ?";

            Cursor c = ler.rawQuery(sql, new String[] { cpf });

            if (c.getCount() == 0){
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e){
            Log.e("INFO", "Erro ao pesquisar usuário" +e.getMessage());

            return false;
        }
    }
}
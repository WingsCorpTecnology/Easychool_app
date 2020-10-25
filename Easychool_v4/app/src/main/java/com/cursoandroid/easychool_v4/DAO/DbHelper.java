package com.cursoandroid.easychool_v4.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public static int VERSION = 1;
    public static String NAME_BD = "BD_EASYCHOOL";
    public static String TABELA_PERIODO = "TB_PERIODO";
    public static String TABELA_NIVEL_EDUCACAO = "TB_NIVELEDUCACAO";
    public static String TABELA_ESCOLA = "TB_ESCOLA";
    public static String TABELA_TURMA = "TB_TURMA";
    public static String TABELA_FUNCIONARIO = "TB_FUNCIONARIO";
    public static String TABELA_TIPO_TELEFONE = "TB_TIPO_TELEFONE";
    public static String TABELA_TELEFONE_ESCOLA = "TB_TELEFONE_ESCOLA";
    public static String TABELA_RESPONSAVEL_ALUNO = "TB_RESPONSAVEL_ALUNO";
    public static String TABELA_TELEFONE_RESPONSAVEL_ALUNO = "TB_TELEFONE_RESPONSAVEL_ALUNO";
    public static String TABELA_STATUS = "TB_STATUS";
    public static String TABELA_FILA_ESPERA = "TB_FILA_ESPERA";

    public DbHelper(@Nullable Context context) { super(context, NAME_BD, null, VERSION); }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS " +TABELA_TIPO_TELEFONE+ " " +
                "(idTipoTelefone INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "tipo TEXT NOT NULL);";

        String sql2 = "CREATE TABLE IF NOT EXISTS " +TABELA_RESPONSAVEL_ALUNO+ " " +
                "(idReponsavelAluno INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome TEXT NOT NULL, " +
                "rg TEXT NOT NULL, " +
                "cpf TEXT NOT NULL, " +
                "email TEXT NOT NULL," +
                "senha TEXT NOT NULL);";

        String sql3 = "CREATE TABLE IF NOT EXISTS " +TABELA_TELEFONE_RESPONSAVEL_ALUNO+ " " +
                "(idTelefoneResponsavelAluno INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "telefone TEXT NOT NULL, " +
                "idTipoTelefone INTEGER NOT NULL, " +
                "idResponsavelAluno INTEGER " +
                "   CONSTRAINT idTipoTelefone REFERENCES " +TABELA_TIPO_TELEFONE+ " (idTipoTelefone)" +
                "   CONSTRAINT idResponsavelAluno REFERENCES " +TABELA_RESPONSAVEL_ALUNO+ " (idResponsavelAluno));";
        try{
            sqLiteDatabase.execSQL(sql);
            sqLiteDatabase.execSQL(sql2);
            sqLiteDatabase.execSQL(sql3);

            Log.i("INFO", "Sucesso ao criar as tabelas");
        } catch(Exception e){
            Log.i("INFO", "Erro ao criar as tabelas" + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

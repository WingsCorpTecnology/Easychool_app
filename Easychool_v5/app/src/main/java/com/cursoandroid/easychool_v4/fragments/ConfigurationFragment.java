package com.cursoandroid.easychool_v4.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.cursoandroid.easychool_v4.R;
import com.cursoandroid.easychool_v4.activity.*;

public class ConfigurationFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_configuracoes, container, false);
        TextView btnPerfil = root.findViewById(R.id.btn_config_perfil);

        btnPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                configurarPerfilAbrir();
            }
        });

        return root;
    }

    public void configurarPerfilAbrir(){
        Intent intent = new Intent(getActivity(), ConfigPerfilActivity.class);
        startActivity(intent);
    }
}
package com.example.filipe.usuariocadastro;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/*Padrões de projeto:
Padrões Estruturais
Adapter - A ação desse padrão converte a interface de uma classe em outra, esperada pelo objeto cliente.
Através dessa conversão, permite que classes com incompatibilidade de interfaces, consigam serem adaptadas
para que outros objetos possam trabalhar juntos.*/
public class UsuarioAdapter extends ArrayAdapter<Usuario> {

    private ArrayList<Usuario> usuarios;

    public UsuarioAdapter(@NonNull Context context, @NonNull ArrayList<Usuario> usuarios) {
        super(context, 0,usuarios);
        this.usuarios = usuarios;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Usuario usuario = usuarios.get(position);

        convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_usuario,null);

        ImageView imageView = (ImageView)convertView.findViewById(R.id.imageViewAvatar);
        TextView textViewNome = (TextView)convertView.findViewById(R.id.textViewNome);
        TextView textViewEmail = (TextView)convertView.findViewById(R.id.textViewEmail);

        textViewNome.setText(usuario.getNome().toString());
        textViewEmail.setText(usuario.getEmail().toString());

        if (usuario.getAvatar() != null)
            imageView.setImageBitmap(usuario.getAvatar());

        return  convertView;
    }
}

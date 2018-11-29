package com.example.filipe.usuariocadastro;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonConsultar;
    private Button buttonIncluir;
    private Button signOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.titulo_menu));

        buttonConsultar = (Button)findViewById(R.id.buttonConsultar);
        buttonIncluir = (Button)findViewById(R.id.buttonIncluir);
        signOut = (Button) findViewById(R.id.sign_out);

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Padrão de projeto de criação
                //Builder
                //Builder permite a separação da construção de um objeto complexo da sua representação,
                //de forma que o mesmo processo de construção possa criar diferentes representações.
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Tem certeza que deseja sair?");
                builder.setPositiveButton("SIM", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        finish();
                    }

                });
                builder.setNegativeButton("NÃO", null);

                builder.create();
                builder.show();

            }
        });


        buttonIncluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CadastroActivity.class);
                startActivity(intent);
            }
        });

        buttonConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ConsultaActivity.class);
                startActivity(intent);
            }
        });
    }
}

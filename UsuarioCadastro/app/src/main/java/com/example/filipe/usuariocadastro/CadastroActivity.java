package com.example.filipe.usuariocadastro;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class CadastroActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextNome;
    private EditText editTextEmail;
    private Button buttonExcluir;
    private Button buttonSalvar;
    private Button buttonCancelar;
    private ImageView imageView;
    private Button addImage;
    private static final int CAMERA_REQUEST = 1;
    private static final int PICK_FROM_GALLERY = 2;
    int opcao = 0;
    private static final int SELECT_PHOTO = 100;


    private final Usuario usuario = new Usuario(this);
    //Padrão de projeto:
    //Padrões de criação
    //Singleton - Usado quando desejado, que uma classe tenha apenas uma instância na aplicação.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        editTextNome = (EditText)findViewById(R.id.editTextNome);
        editTextEmail = (EditText)findViewById(R.id.editTextEmail);
        buttonExcluir = (Button)findViewById(R.id.buttonExcluir);
        buttonCancelar = (Button)findViewById(R.id.buttonCancelar);
        buttonSalvar = (Button)findViewById(R.id.buttonSalvar);
        imageView = (ImageView)findViewById(R.id.imageViewAvatar);

        buttonExcluir.setOnClickListener(this);
        buttonSalvar.setOnClickListener(this);
        buttonCancelar.setOnClickListener(this);

        if (getIntent().getExtras() != null){
            setTitle(getString(R.string.titulo_editando));
            int codigo = getIntent().getExtras().getInt("consulta");
            usuario.carregaUsuarioPeloCodigo(codigo);
            imageView.setImageBitmap(usuario.getAvatar());
            editTextNome.setText(usuario.getNome().toString());
            editTextEmail.setText(usuario.getEmail().toString());
        }else{
            setTitle(getString(R.string.titulo_incluindo));
        }

        buttonExcluir.setEnabled(true);
        if (usuario.getCodigo() == -1)
            buttonExcluir.setEnabled(false);

        final String[] option = new String[] { "Take from Camera","Select from Gallery" };

        /*Padrões de projeto:
        Padrões Estruturais
        Adapter - A ação desse padrão converte a interface de uma classe em outra, esperada pelo objeto cliente.
        Através dessa conversão, permite que classes com incompatibilidade de interfaces, consigam serem adaptadas
        para que outros objetos possam trabalhar juntos.*/
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item, option);

        /*Padrão de projeto de criação
        Builder
        Builder permite a separação da construção de um objeto complexo da sua representação,
        de forma que o mesmo processo de construção possa criar diferentes representações.*/
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select Option");
        builder.setAdapter(adapter, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                Log.e("Selected Item", String.valueOf(which));
                if (which == 0) {
                    callCamera();
                }
                if (which == 1) {
                    callGallery();
                }

            }
        });

        final AlertDialog dialog = builder.create();
        addImage = (Button) findViewById(R.id.btnAdd);

        addImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK)
            return;

        switch (requestCode) {
            case CAMERA_REQUEST:

                Bundle extras = data.getExtras();

                if (extras != null) {
                    Bitmap yourImage = extras.getParcelable("data");
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    yourImage.compress(Bitmap.CompressFormat.PNG, 100, stream);
                    byte imageInByte[] = stream.toByteArray();
                    imageView.setImageBitmap(yourImage);
                }
                break;
            case SELECT_PHOTO:
                Uri selectedImage = data.getData();
                InputStream imageStream = null;
                try {
                    imageStream = getContentResolver().openInputStream(selectedImage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                Bitmap yourSelectedImage = BitmapFactory.decodeStream(imageStream);
                if (opcao == 0) {
                    imageView.setImageURI(selectedImage);
                } else {
                    imageView.setImageURI(selectedImage);
                }
        }
    }

    public void callCamera(){
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra("crop", "true");
        cameraIntent.putExtra("aspectX", 0);
        cameraIntent.putExtra("aspectY", 0);
        cameraIntent.putExtra("outputX", 200);
        cameraIntent.putExtra("outputY", 150);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);

    }

    public void callGallery() {
        try {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_PICK);//
            startActivityForResult(Intent.createChooser(intent, "Select File"), SELECT_PHOTO);
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonCancelar : {
                finish();
                break;
            }
            case R.id.buttonExcluir : {
                /*Padrão de projeto de criação
                Builder
                Builder permite a separação da construção de um objeto complexo da sua representação,
                de forma que o mesmo processo de construção possa criar diferentes representações.*/
                new AlertDialog.Builder(this)
                        .setTitle("Deletando usuário")
                        .setMessage("Tem certeza que deseja deletar esse usuário?")
                        .setPositiveButton("sim",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        usuario.excluir();
                                        Toast.makeText(getApplicationContext(), "Usuário Excluído", Toast.LENGTH_LONG).show();
                                        finish();
                                    }
                                })
                        .setNegativeButton("não", null)
                        .show();


                //usuario.excluir();
                //Toast.makeText(getApplicationContext(), "Usuário Excluído", Toast.LENGTH_LONG).show();
                //finish();
                break;
            }
            case R.id.buttonSalvar :{
                boolean valido = true;

                Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                ByteArrayOutputStream saida = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, saida);
                byte[] img = saida.toByteArray();

                usuario.setNome(editTextNome.getText().toString().trim());
                usuario.setEmail(editTextEmail.getText().toString().trim().toLowerCase());
                usuario.setImagem(img);

                if (usuario.getNome().equals("")){
                    editTextNome.setError(getString(R.string.obrigatorio));
                    valido = false;
                }

                if (usuario.getEmail().equals("")){
                    editTextEmail.setError(getString(R.string.obrigatorio));
                    valido = false;
                }
                //condicao editando
                if (getIntent().getExtras() != null){
                    usuario.salvar();
                    Toast.makeText(getApplicationContext(), "Usuário Alterado", Toast.LENGTH_LONG).show();
                    finish();
                }

                if (valido){
                    usuario.salvar();
                    Toast.makeText(getApplicationContext(), "Usuário Cadastrado", Toast.LENGTH_LONG).show();
                    finish();
                }
                break;
            }
        }
    }

}
package com.example.cartelera2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.RegionIterator;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Registro extends AppCompatActivity {
    private Spinner spGenero;
    EditText txtNicknameRegistro;
    EditText txtPasswordRegistro;
    EditText txtNombreRegistro;
    EditText txtApellidoRegistro;
    EditText txtDpiRegistro;
    EditText txtCorreoRegistro;
    Button btnGuardarR;
    Button btnGFoto;
    ImageView imgFoto;
    String fotoCargar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        this.spGenero = findViewById(R.id.spGenero);
        this.txtNicknameRegistro = findViewById(R.id.txtNicknameRegistro);
        this.txtPasswordRegistro = findViewById(R.id.txtPassword);
        this.txtNombreRegistro = findViewById(R.id.txtNombreRegistro);
        this.txtApellidoRegistro = findViewById(R.id.txtApellidoRegistro);
        this.txtDpiRegistro = findViewById(R.id.txtDPIRegistro);
        this.txtCorreoRegistro = findViewById(R.id.txtCorreoRegistro);
        this.btnGuardarR = findViewById(R.id.btnGuardarR);
        this.btnGFoto = findViewById(R.id.btnGFoto);
        this.imgFoto = findViewById(R.id.imgFoto);
        ArrayAdapter<CharSequence> lista = ArrayAdapter.createFromResource(this, R.array.genero, android.R.layout.simple_spinner_item);
        spGenero.setAdapter(lista);

        btnGuardarR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Usuario userRequest = new Usuario();
                    userRequest.setNickname(txtNicknameRegistro.getText().toString());
                    userRequest.setPassword(txtPasswordRegistro.getText().toString());
                    userRequest.setNombre(txtNombreRegistro.getText().toString());
                    userRequest.setApellido(txtApellidoRegistro.getText().toString());
                    userRequest.setDpi(txtDpiRegistro.getText().toString());
                    userRequest.setCorreo(txtCorreoRegistro.getText().toString());
                    userRequest.setGenero(spGenero.getSelectedItem().toString());
                    userRequest.setFoto(txtNicknameRegistro.getText().toString() + ".jpg");//la foto se llama igual al usuario
                    userRequest.setIdEstado(1);
                    String resultado = new RegistroUsuario().execute(userRequest).get();
                    if (resultado.equals("exito")) {
                        Intent navegacion = new Intent(Registro.this, login.class);
                        startActivity(navegacion);
                    } else {
                        Toast.makeText(Registro.this, "Error al crear el usuario", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnGFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{

                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }
    }

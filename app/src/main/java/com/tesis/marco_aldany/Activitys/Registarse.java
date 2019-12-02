package com.tesis.marco_aldany.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tesis.marco_aldany.Home_M_A;
import com.tesis.marco_aldany.R;

public class Registarse extends AppCompatActivity {
    TextView usuario,password,validarpassword;
    Button registar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registarse);

        usuario = findViewById(R.id.reg_usuario_id);
        password = findViewById(R.id.reg_password_id);
        validarpassword = findViewById(R.id.reg_validarpassword_id);
        registar = findViewById(R.id.registrarse_id);

        registar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String nombre = usuario.getText().toString();
               String pass = password.getText().toString();
               String validarpass = validarpassword.getText().toString();
               if (!nombre.isEmpty() && !pass.isEmpty() && validarpass.equals(pass) && !validarpass.isEmpty()){
                   Intent intent=new Intent(Registarse.this, Home_M_A.class);
                   startActivity(intent);
               }else if (nombre.isEmpty() ){
                usuario.setError("Usuario incorrecto");
               }else if ( pass.isEmpty() ) {
                   password.setError("Ingrese contraseña");
               }else if (!pass.equals(validarpass) || validarpass.isEmpty() ) {
                   validarpassword.setError("No coiciden las contraseñas");
               }
            }
        });

    }
}

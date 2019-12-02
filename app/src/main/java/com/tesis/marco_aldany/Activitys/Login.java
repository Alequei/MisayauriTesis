package com.tesis.marco_aldany.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tesis.marco_aldany.Home_M_A;
import com.tesis.marco_aldany.R;

public class Login extends AppCompatActivity {
    EditText usuario,password;
    TextView registrarse;
    Button ingresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario = findViewById(R.id.reg_usuario_id);
        password = findViewById(R.id.passoword_id);
        ingresar= findViewById(R.id.ingresar_id);
        registrarse = findViewById(R.id.registrarse_id);
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = usuario.getText().toString();
                String clave = password.getText().toString();
                if (!user.isEmpty() && !clave.isEmpty()){
                    Intent intent=new Intent(Login.this, Home_M_A.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"Ingresando..",Toast.LENGTH_LONG);
                }else if (user.isEmpty()){
                    usuario.setError("Usuario Incorrecto");
                }else if (clave.isEmpty()){
                    password.setError("Ingresar contraseña correcta");
                }

            }
        });

        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,Registarse.class);
                startActivity(intent);
            }
        });


    }
}

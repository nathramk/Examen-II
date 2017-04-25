package pe.edu.upeu.examen_ii;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

import pe.edu.upeu.examen_ii.bean.UsuariosReg;

public class Registro extends AppCompatActivity {

    EditText edtNombre;
    EditText edtApellido;
    EditText edtUser;
    EditText edtPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edtNombre = (EditText) findViewById(R.id.edtNombre);
        edtApellido = (EditText) findViewById(R.id.edtApellido);
        edtUser = (EditText) findViewById(R.id.edtUser);
        edtPass = (EditText) findViewById(R.id.edtPass);
        Button btnGuard= (Button) findViewById(R.id.btnGuard);

        Bundle parameters = getIntent().getExtras();
        final int usuarioId = (int) parameters.getInt("usuarioId");

        btnGuard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usuarioId==0){
                    Random r = new Random();
                    int usId = r.nextInt(1000)+1;
                    Usuarios.listUsers.add(new UsuariosReg(usId,edtNombre.getText().toString(),edtApellido.getText().toString(),edtUser.getText().toString(),edtPass.getText().toString()));
                    goLog();
                }else {

                }
                goLog();
            }
        });

    }

    public void goLog(){
        Intent e = new Intent(this, MainActivity.class);
        startActivity(e);
    }

}

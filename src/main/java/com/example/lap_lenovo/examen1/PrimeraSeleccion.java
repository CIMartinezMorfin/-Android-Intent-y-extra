package com.example.lap_lenovo.examen1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrimeraSeleccion extends AppCompatActivity {
    Button btnVolver,btn1,btn2,btn3;
    int op1=-1,op2=-1,op3=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primera_seleccion);
        op1=getIntent().getExtras().getInt("op1");
        op2=getIntent().getExtras().getInt("op2");
        op3=getIntent().getExtras().getInt("op3");
        btn1=(Button)findViewById(R.id.button1);
        btn2=(Button)findViewById(R.id.button2);
        btn3=(Button)findViewById(R.id.button3);
        btnVolver=(Button)findViewById(R.id.button4);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op1=1;
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op1=2;
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op1=3;
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PrimeraSeleccion.this, ActivityPrincipal.class);
                intent.putExtra("op1",op1);intent.putExtra("op2",op2);intent.putExtra("op3",op3);
                startActivity(intent);
                finish();
            }
        });

    }
}

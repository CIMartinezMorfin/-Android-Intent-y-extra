package com.example.lap_lenovo.examen1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class SegundaSeleccion extends AppCompatActivity {

    RadioButton rad1,rad2,rad3;
    Button btnVolver;int op1=-1,op2=-1,op3=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_seleccion);

        op1=getIntent().getExtras().getInt("op1");
        op2=getIntent().getExtras().getInt("op2");
        op3=getIntent().getExtras().getInt("op3");
        rad1=(RadioButton)findViewById(R.id.rad1);
        rad2=(RadioButton)findViewById(R.id.rad2);
        rad3=(RadioButton)findViewById(R.id.rad3);
        btnVolver=(Button)findViewById(R.id.button5);

        rad1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op2=1;
            }
        });

        rad2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op2=2;
            }
        });
        rad3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op2=3;
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SegundaSeleccion.this, ActivityPrincipal.class);
                intent.putExtra("op1",op1);intent.putExtra("op2",op2);intent.putExtra("op3",op3);
                startActivity(intent);
                finish();
            }
        });


    }
}

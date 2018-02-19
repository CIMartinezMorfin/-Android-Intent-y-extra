package com.example.lap_lenovo.examen1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class TerceraSeleccion extends AppCompatActivity {
    Button btnVolver;
    SeekBar seekBar;
    int op1=-1,op2=-1,op3=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera_seleccion);
        op1=getIntent().getExtras().getInt("op1");
        op2=getIntent().getExtras().getInt("op2");
        op3=getIntent().getExtras().getInt("op3");

        seekBar=(SeekBar)findViewById(R.id.barra);
        btnVolver=(Button)findViewById(R.id.button6);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TerceraSeleccion.this, ActivityPrincipal.class);
                intent.putExtra("op1",op1);intent.putExtra("op2",op2);intent.putExtra("op3",op3);
                startActivity(intent);
                finish();
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                op3=i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}

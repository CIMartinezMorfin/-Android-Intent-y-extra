package com.example.lap_lenovo.examen1;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class ActivityPrincipal extends AppCompatActivity {

    Button btnVerificar;
    ListView listView;

    int op1=-1,op2=-1,op3=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btnVerificar=(Button)findViewById(R.id.button);
        listView=(ListView)findViewById(R.id.listView);

try {
    op1 = getIntent().getExtras().getInt("op1", -1);
    op2 = getIntent().getExtras().getInt("op2", -1);
    op3 = getIntent().getExtras().getInt("op3", -1);
}catch (Exception e){}
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=null;

                switch (i){
                    case 0:
                        intent=new Intent(ActivityPrincipal.this,PrimeraSeleccion.class);
                        break;
                    case 1:
                        intent=new Intent(ActivityPrincipal.this,SegundaSeleccion.class);
                        break;
                    case 2:
                        intent=new Intent(ActivityPrincipal.this,TerceraSeleccion.class);
                        break;
                }
                intent.putExtra("op1",op1);intent.putExtra("op2",op2);intent.putExtra("op3",op3);

                startActivity(intent);
                finish();

            }
        });

        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificar();
            }
        });
    }

    private void verificar(){

        String mensaje="";
        mensaje+= op1>0 ? "Eleccion 1: "+op1+" - ":"No se selecciono nada";
        mensaje+= op2>0 ? "Eleccion 2: "+op2+" - ":"No se selecciono nada";
        mensaje+= op3>0 ? "Eleccion 3: "+op3+" - ":"No se selecciono nada";

        NotificationCompat.Builder notif=new NotificationCompat.Builder(getApplicationContext());
        notif.setTicker("Elecciones");
        notif.setContentTitle("Elecciones");
        notif.setContentText(mensaje);
        notif.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        notif.setSmallIcon(R.mipmap.ic_launcher);

        Intent intent=new Intent(ActivityPrincipal.this,ActivityPrincipal.class);
        intent.putExtra("op1",op1);intent.putExtra("op2",op2);intent.putExtra("op3",op3);
        PendingIntent pendingIntent=PendingIntent.getActivity(getApplicationContext(),1,intent,PendingIntent.FLAG_ONE_SHOT);
        NotificationManager manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notif.setContentIntent(pendingIntent);
        manager.notify(10,notif.build());

    }

}

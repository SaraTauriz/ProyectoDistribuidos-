package facci.distribuidos.aplicacionmqtt;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ekn.gruzer.gaugelibrary.ArcGauge;
import com.ekn.gruzer.gaugelibrary.HalfGauge;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import facci.distribuidos.aplicacionmqtt.adapter.DistanciaAdapter;
import facci.distribuidos.aplicacionmqtt.model.Distancia;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class detalles extends AppCompatActivity {
    TextView textEnvase,textPorcentaje;

    HalfGauge halfGauge;

    com.ekn.gruzer.gaugelibrary.Range Rango_1,Rango_2,Rango_3;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        String envaseTama = getIntent().getStringExtra("envase");

        textEnvase= findViewById(R.id.textEnvase);
        textPorcentaje= findViewById(R.id.textPorcentaje);
        textEnvase.setText(envaseTama+" CM");
        halfGauge=findViewById(R.id.halfGauge);

        Rango_1=new com.ekn.gruzer.gaugelibrary.Range();
        Rango_2=new com.ekn.gruzer.gaugelibrary.Range();
        Rango_3=new com.ekn.gruzer.gaugelibrary.Range();

        Rango_1.setFrom(0);Rango_1.setTo(30);Rango_1.setColor(Color.RED);
        Rango_2.setFrom(30);Rango_2.setTo(70);Rango_2.setColor(Color.YELLOW);
        Rango_3.setFrom(70);Rango_3.setTo(100);Rango_3.setColor(Color.GREEN);

        halfGauge.setMinValue(0);
        halfGauge.setMaxValue(100);
        halfGauge.setValue(0);


        halfGauge.addRange(Rango_1);
        halfGauge.addRange(Rango_2);
        halfGauge.addRange(Rango_3);

        int envaseInt=Integer.parseInt(envaseTama);
        mostrarDetalles(envaseInt);

        new Timer().scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run(){
                mostrarDetalles(envaseInt);
            }
        },0,2000);


    }


    private void mostrarDetalles(int envaseInt ){
        DistanciaAdapter distanciaAdapter = new DistanciaAdapter();
        Call<ArrayList<Distancia>> call = distanciaAdapter.getDistancia();

        call.enqueue(new Callback<ArrayList<Distancia>>() {
            @Override
            public void onResponse(Call<ArrayList<Distancia>> call, Response<ArrayList<Distancia>> response) {
                ArrayList<Distancia> distancia = response.body();
                int size=distancia.size()-1;
                int distanciaultima = Integer.parseInt(distancia.get(size).getDistancia());
                int porcentajeCal= (distanciaultima*100)/(envaseInt-3);
                textPorcentaje.setText(((porcentajeCal)-100)*-1 +" %");
                halfGauge.setValue(((porcentajeCal)-100)*-1);
            }

            @Override
            public void onFailure(Call<ArrayList<Distancia>> call, Throwable t) {

            }
        });



    }

}
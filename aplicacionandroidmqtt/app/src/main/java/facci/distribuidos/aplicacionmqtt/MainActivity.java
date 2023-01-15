package facci.distribuidos.aplicacionmqtt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText editEnvase;
    Button buttonEnvase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEnvase = findViewById(R.id.editEnvase);
        buttonEnvase = findViewById(R.id.buttonEnvase);

        buttonEnvase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, detalles.class);
                i.putExtra("envase", editEnvase.getText().toString());
                startActivity(i);

            }
        });
    }
}
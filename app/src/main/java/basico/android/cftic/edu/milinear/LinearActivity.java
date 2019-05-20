package basico.android.cftic.edu.milinear;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.Layout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LinearActivity extends AppCompatActivity {

    private int num_veces = 0;
    private long tiempoInicial;


    private Button boton_empezar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);
/*
        this.boton_empezar = findViewById(R.id.boton_empezar);
        this.boton_empezar.setOnClickListener(this);*/

    }

    // ************ APPBAR *************

    // DIBUJO EL MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    //RECIBIR EL EVENTO DEL MENU QUE SE HA PULSADO
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.infinito:
                // Ya estoy en la versión Original
                //lanzar la version Infinito
                Log.d("MIAPP", "tocó Ver. infinito");

                Intent intent = new Intent(this, MainActivitySplitFernando.class);
                startActivity(intent);

                Toast mensaje_toast1 = Toast.makeText(this, "Versión original", Toast.LENGTH_SHORT);
                mensaje_toast1.show();

                break;
            case R.id.original:
                Log.d("MIAPP", "tocó Ver. original");
                // Ya estoy en la versión Original

                Toast mensaje_toast2 = Toast.makeText(this, "Versión infinito", Toast.LENGTH_SHORT);
                mensaje_toast2.show();

                break;

            default:
                Log.d("MIAPP", "tocó id desconocido");
        }

        return super.onOptionsItemSelected(item);
    }




    public void cambiaColor(View view) {


        ColorDrawable viewColor = (ColorDrawable) view.getBackground();
        int colorId = viewColor.getColor();





        Log.d("MIAPP", "Color = " + colorId);

        if (colorId != Color.BLACK) {
            view.setBackgroundColor(Color.BLACK);
            num_veces++;

            /*if (num_veces == 1){

                tiempoInicial = System.currentTimeMillis();

            }
            Vamos a empezar pulsando un boton

            */
            //Mostrar num_veces en un textview
            TextView cajaContador = findViewById(R.id.contador);
            cajaContador.setText(String.valueOf(num_veces));
        }

        Log.d("MIAPP", "NVeces = " + num_veces);

        if (num_veces == 6) {
            salir();
        }


    }

    private void salir() {


        Long tiempoFinal = System.currentTimeMillis();
        Long tiempoTotal = tiempoFinal - this.tiempoInicial;

        Log.d("MIAPP", "TARDASTE = " + tiempoTotal / 1000 + " Segundos");

        String texto_informativo = " Has tardado: " + String.valueOf(tiempoTotal / 1000) + " Segundos";

        Toast mensaje_toast = Toast.makeText(this, texto_informativo, Toast.LENGTH_LONG);
        mensaje_toast.show();


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            this.finishAffinity(); // cierra del to_do
        } else {
            this.finish();// cierro la actividad
        }
    }


    public void dividirPantalla(View view) {

        float anchoVista = view.getWidth();
        float altoVista = view.getHeight();

        int viewID = view.getId();

        if (anchoVista >= altoVista) {

            LinearLayout viewLayout = (LinearLayout) findViewById(viewID);
            viewLayout.setLayoutParams(new LinearLayout.LayoutParams((int) anchoVista / 2,
                    (int) altoVista, 1f));

            LinearLayout padre = new LinearLayout(this);


        }else{

            LinearLayout viewLayout = (LinearLayout) findViewById(viewID);
            viewLayout.setLayoutParams(new LinearLayout.LayoutParams((int) altoVista / 2,
                    (int) anchoVista, 1f));

        }



    }



    public void empezarPartida(View view) {


        /*
        this.boton_empezar.setVisibility(View.VISIBLE);
        this.boton_empezar.setVisibility(View.INVISIBLE);
        this.boton_empezar.setVisibility(View.GONE);
        */


        tiempoInicial = System.currentTimeMillis();

        view.setVisibility(View.INVISIBLE);




    }
}

package basico.android.cftic.edu.milinear;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Random;

public class MainActivitySplitFernando extends AppCompatActivity {


    private static final int COLORES[] = {R.color.aguamarina, R.color.cian, R.color.dukeBlue, R.color.UCLABlue, R.color.verdeEsmeralda, R.color.black, R.color.white};
    // private int indexColor = 0;

    private static Random r = new Random();

    private int contadorToques = 0;
    private int nToques = 0;

    private static final int MAX_HIJOS = 5;


    // ************ onCreate *************

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_split_fernando);

        Intent intent_creador = getIntent();
        this.nToques = intent_creador.getIntExtra("NTOKES", 3);

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
                // Ya estoy en la versión Infinito
                Log.d("MIAPP", "tocó Ver. infinito");

                Toast mensaje_toast1 = Toast.makeText(this, "Versión infinito", Toast.LENGTH_SHORT);
                mensaje_toast1.show();

                break;
            case R.id.original:
                Log.d("MIAPP", "tocó Ver. original");
                //lanzar la version Original

                Intent intent = new Intent(this, LinearActivity.class);
                startActivity(intent);

                Toast mensaje_toast2 = Toast.makeText(this, "Versión original", Toast.LENGTH_SHORT);
                mensaje_toast2.show();

                break;

            default:
                Log.d("MIAPP", "tocó id desconocido");
        }

        return super.onOptionsItemSelected(item);
    }


    private int colorAleatorio() {

        int randomColor = -1;


        // +++++ Colores aleatorios en general ++++++

        /*Random rand = new Random();
        int r = rand.nextInt(255);
        int g = rand.nextInt(255);
        int b = rand.nextInt(255);

        randomColor = Color.rgb(r,g,b);*/

        // +++++ Colores aleatorios dentro de un array ya definido ++++++

        Random rand = new Random();
        int pos = rand.nextInt(COLORES.length + 1);
        randomColor = getResources().getColor(COLORES[pos]);

        return randomColor;

    }
    /*
    +++++++++++Crear hijo++++++++++++
    */


    private LinearLayout crearHijo(int orientacion) {


        LinearLayout hijoDevuelto = new LinearLayout(this);
        hijoDevuelto.setId(newId());


        /*
        Si la orientacion del padre en VERTICAL la del hijo en HORIZONTAL y viceversa
         */
        if (orientacion == LinearLayout.VERTICAL) {

            hijoDevuelto.setOrientation(LinearLayout.HORIZONTAL);

            LinearLayout.LayoutParams parametros = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1F);
            hijoDevuelto.setLayoutParams(parametros);
        } else {

            hijoDevuelto.setOrientation(LinearLayout.VERTICAL);

            LinearLayout.LayoutParams parametros = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1F);
            hijoDevuelto.setLayoutParams(parametros);
        }

        hijoDevuelto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dividir(v);
            }
        });
        hijoDevuelto.setBackgroundColor(colorAleatorio());
        hijoDevuelto.setVisibility(View.VISIBLE);

        return hijoDevuelto;


    }

    public void dividir(View view) {
        contadorToques++;

        if (contadorToques < nToques) {

            LinearLayout padre = (LinearLayout) view;

            /*LinearLayout hijo1 = crearHijo(padre.getOrientation());
            LinearLayout hijo2 = crearHijo(padre.getOrientation());

            padre.addView(hijo1);
            padre.addView(hijo2);*/

            LinearLayout hijoNuevo = crearHijo(padre.getOrientation());

            int numAleatorioHijos = this.r.nextInt(MAX_HIJOS) + 2;

            for (int contador = 2; contador < numAleatorioHijos; contador++) {
                hijoNuevo = crearHijo(padre.getOrientation());
                padre.addView(hijoNuevo);
            }

        } else {
            salir();
        }


    }


/*
//        LinearLayout padre = (LinearLayout)findViewById( view.getId());
            LinearLayout hijo1 = new LinearLayout(this);
            hijo1.setId(newId());
            LinearLayout hijo2 = new LinearLayout(this);
            hijo2.setId(newId());
            if (padre.getOrientation() == LinearLayout.VERTICAL) {
                Log.d("SplitView_dividir", "Vertical");
//        android:layout_width="match_parent"
//        android:layout_height="0dp"
//        android:layout_weight="1"
                LinearLayout.LayoutParams parametros = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1F);

//        android:orientation="horizontal"
                hijo1.setOrientation(LinearLayout.HORIZONTAL);
                hijo1.setLayoutParams(parametros);

                hijo2.setOrientation(LinearLayout.HORIZONTAL);
                hijo2.setLayoutParams(parametros);
            } else {
                Log.d("SplitView_dividir", "Horizontal");
//            android:layout_width="0dp"
//            android:layout_height="match_parent"
//            android:layout_weight="1"
                LinearLayout.LayoutParams parametros = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1F);

//        android:orientation="vertical"
                hijo1.setOrientation(LinearLayout.VERTICAL);
                hijo1.setLayoutParams(parametros);

                hijo2.setOrientation(LinearLayout.VERTICAL);
                hijo2.setLayoutParams(parametros);
            }
            hijo1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    dividir(v);
                }
            });
            hijo2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    dividir(v);
                }
            });



            // hijo1.setBackgroundColor(((ColorDrawable) padre.getBackground()).getColor());
            hijo1.setBackgroundColor(colorAleatorio());

            // hijo2.setBackgroundColor(getResources().getColor(COLORES[indexColor]));
            hijo2.setBackgroundColor(colorAleatorio());

            hijo1.setVisibility(View.VISIBLE);
            hijo2.setVisibility(View.VISIBLE);


          */

/*  indexColor++;
            if (indexColor == COLORES.length) {
                indexColor = 0;
            }*//*




    /**
     * Es el ID calculado
     * Va generando números aleatorios. Comprueba que el valor generado
     * no coincide con un ID existente y si no existe devuelvo el nuevo
     * valor.
     *
     * @return
     */

    private int newId() {
        int resultado = -1;
        do {
            resultado = r.nextInt(Integer.MAX_VALUE);
        } while (findViewById(resultado) != null);
        return resultado;
    }


    private void salir() {

        Toast mensaje_toast = Toast.makeText(this, "Se acabó..." + contadorToques, Toast.LENGTH_LONG);
        mensaje_toast.show();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            this.finishAffinity(); // cierra del to_do
        } else {
            this.finish();// cierro la actividad
        }
    }
}
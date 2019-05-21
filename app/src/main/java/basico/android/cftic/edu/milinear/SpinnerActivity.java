package basico.android.cftic.edu.milinear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class SpinnerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    // private static final String [] NOMBRES = {"JAVI", "VALE", "VERO"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);


        Spinner spinner = (Spinner) findViewById(R.id.mispinner); // Spinner es un desplegable


    // El adapter es un proveedor de datos

    //Crear un ArrayAdapter usando un recurso con array de strings (dentro de string_juegos.xml)y un layout spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.array_juegos, android.R.layout.simple_spinner_item); // simple_spinner_item es el estilo

    // Especificar el layout a usar cuando la lista aparece
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    //Aplicar el adaptador al spinner
        spinner.setAdapter(adapter);

        spinner.setSelected(false);
        spinner.setSelection(0,false);

        spinner.setOnItemSelectedListener(this); // se debe implementar AdapterView.OnItemSelectedListener en la clase


   /*   El método createFromResource() te permite crear un ArrayAdapter a partir de la matriz de strings.
        El tercer argumento para este método es un recurso de diseño que define la manera en que se muestra
        la opción seleccionada en el control del control de número.
        El diseño de simple_spinner_item se proporciona mediante la plataforma y es el diseño predeterminado
        que debes usar a menos que desees definir tu propio diseño para la apariencia del control de número.

        Luego, debes llamar a setDropDownViewResource(int) a fin de especificar el diseño que debe usar el adaptador
        a fin de mostrar la lista de elecciones del
        control de número (simple_spinner_dropdown_item es otro diseño estándar definido por la plataforma).

        Llama a setAdapter() para aplicar el adaptador a tu Spinner.*/


/*        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, NOMBRES);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);*/

    }



    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        Log.d("MIAPP", "TOCADO " + pos);

        switch (pos){
            case 0:
                Intent intent0 = new Intent(this, NumberPickerActivity.class);
                startActivity(intent0);
                Log.d("MIAPP", "LANZADO NUMBERPICKER");
                break;
            case 1:
                Intent intent1 = new Intent(this, LinearActivity.class);
                startActivity(intent1);
                Log.d("MIAPP", "LANZADO LinearActivity");
                break;
        }



    }


    public void onNothingSelected(AdapterView<?> parent) {

    }
}
package basico.android.cftic.edu.milinear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

public class NumberPickerActivity extends AppCompatActivity {

    NumberPicker numberpicker;
    TextView textview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_picker);

        numberpicker = (NumberPicker) findViewById(R.id.numberPickerVeces);

        textview = (TextView) findViewById(R.id.textViewSeleccion);

        numberpicker.setMinValue(1);
        numberpicker.setMaxValue(75);
    }

    public void cambiaPantalla(View view){

        int valor = this.numberpicker.getValue();

        lanzarPantalla(valor);

    }




    private void lanzarPantalla(int veces){

        EditText nombreUsuario = findViewById(R.id.nombreUsuarioId);
        String nombre = nombreUsuario.getText().toString();




        Intent intent = new Intent(this, MainActivitySplitFernando.class);
        intent.putExtra("NTOKES", veces);
        intent.putExtra("NOMBREJUGADOR", nombre);

        startActivity(intent);

    }
}

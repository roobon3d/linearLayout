package basico.android.cftic.edu.milinear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;

public class NumberPickerActivity extends AppCompatActivity {

    NumberPicker numberpicker;
    TextView textview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_picker);

        numberpicker = (NumberPicker)findViewById(R.id.numberPickerVeces);

        textview = (TextView)findViewById(R.id.textViewSeleccion);

        numberpicker.setMinValue(1);

        numberpicker.setMaxValue(75);




        numberpicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {


                textview.setText("Selected Value is : " + newVal);

                lanzarPantalla(newVal);

            }


        });


    }

    private void lanzarPantalla(int veces){

        Intent intent = new Intent(this, MainActivitySplitFernando.class);
        intent.putExtra("NTOKES", veces);
        startActivity(intent);

    }
}

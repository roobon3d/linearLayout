package basico.android.cftic.edu.milinear;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class LinearActivity extends AppCompatActivity {

    int num_veces;
    int color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);
    }

    public void cambiaColor(View view){

     /*   View btn = view;
        btn.setBackgroundColor(Color.BLACK);*/

       view.getBackground();

        color = view.getSolidColor();
        Log.d("MIAPP","Color = " + color);

        if (color != (Color.BLACK)) {
            view.setBackgroundColor(Color.BLACK);
            num_veces++;
        }


        if (num_veces == 6){
            salir();
        }




    }
    private void salir (){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            this.finishAffinity(); // cierra del to_do
        } else {
            this.finish();// cierro la actividad
        }
    }

}

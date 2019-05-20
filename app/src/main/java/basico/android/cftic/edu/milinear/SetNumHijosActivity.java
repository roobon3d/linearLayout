package basico.android.cftic.edu.milinear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SetNumHijosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_num_hijos);


        Intent intent = new Intent(this, MainActivitySplitFernando.class);

        intent.putExtra("NTOKES", 30);
        startActivity(intent);
    }
}

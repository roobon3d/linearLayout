package basico.android.cftic.edu.milinear;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PauseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pause);
    }

    public void regresarPausa(View view){
    this.finish();
    }
}

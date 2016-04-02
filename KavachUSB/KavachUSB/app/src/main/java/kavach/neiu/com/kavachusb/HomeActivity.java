package kavach.neiu.com.kavachusb;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
;

public class HomeActivity extends AppCompatActivity {
    Button simulationButton, vayuButton, garudaButton, aswiniButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        simulationButton = (Button) findViewById(R.id.buttonSimulation);
        vayuButton = (Button) findViewById(R.id.buttonVayu);
        aswiniButton = (Button) findViewById(R.id.buttonAswini);
        garudaButton = (Button) findViewById(R.id.buttonGaruda);

    }



    public void onClickSimulation(View view) {
        Toast.makeText(HomeActivity.this, "Simulation: is my Toast message!!! =)",
                Toast.LENGTH_LONG).show();
        //Intent intent = new Intent(HomeActivity.this, MainActivity.class);
        Intent intent = new Intent(HomeActivity.this, SimulationActivity.class);
        startActivity(intent);
        finish();

    }

    public void onClickGaruda(View view) {
        Toast.makeText(HomeActivity.this, "onCLickGuards is my Toast message!!! =)",
                Toast.LENGTH_LONG).show();

    }


    public void onClickAswini(View view) {

        Toast.makeText(HomeActivity.this, "Aswini is my Toast message!!! =)",
                Toast.LENGTH_LONG).show();
    }

    public void onClickVayu(View view) {
        Toast.makeText(HomeActivity.this, "Vayu is my Toast message!!! =)",
                Toast.LENGTH_LONG).show();

    }

    public void onClickHUD(View view) {
        Toast.makeText(HomeActivity.this, "Starting Cardboard HUD!!! =)",
                Toast.LENGTH_LONG).show();
        //Intent intent = new Intent(HomeActivity.this, MainActivity.class);
        Intent intent = new Intent(HomeActivity.this, CardActivity.class);
        startActivity(intent);
        finish();
    }


}

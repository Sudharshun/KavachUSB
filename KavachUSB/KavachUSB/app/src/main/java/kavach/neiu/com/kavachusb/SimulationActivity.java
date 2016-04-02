package kavach.neiu.com.kavachusb;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.app.ProgressDialog;
import android.content.Context;

import com.appspot.kavachhq.garudaapi.Garudaapi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.gson.GsonFactory;

public class SimulationActivity extends AppCompatActivity implements LocationListener {
    protected LocationManager locationManager;
    protected LocationListener locationListener;
    protected Context context;

    String lat;
    String provider;
    protected String latitude, longitude;
    protected boolean gps_enabled, network_enabled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulation);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


        if ((ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) && (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
    }


    @Override
    public void onLocationChanged(Location location) {
        EditText valLatitude = (EditText)findViewById(R.id.txtLatitude);
        EditText valLongitude = (EditText)findViewById(R.id.txtLongitude);

        valLatitude.setText(""+location.getLatitude());
        valLongitude.setText(""+location.getLongitude());
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.d("Status Changed","status");
    }

    public void onClickBack(View view) {
        Toast.makeText(SimulationActivity.this, "Simulation:Going Back!!! =)",
                Toast.LENGTH_LONG).show();
        //Intent intent = new Intent(HomeActivity.this, MainActivity.class);
        Intent intent = new Intent(SimulationActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();

    }

    public void onClickSimulate(View view) {
        EditText valName = (EditText)findViewById(R.id.txtName);
        EditText valHealth = (EditText)findViewById(R.id.txtHealth);
        EditText valLatitude = (EditText)findViewById(R.id.txtLatitude);
        EditText valLongitude = (EditText)findViewById(R.id.txtLongitude);

        String nameValue = valName.getText().toString().trim();
        String healthValue = valHealth.getText().toString().trim();
        String latitudeValue = valLatitude.getText().toString().trim();
        String longitudeValue = valLongitude.getText().toString().trim();

        String responseTxt="/"+nameValue+"/sai/"+healthValue+"/"+latitudeValue+"/"+longitudeValue;

        Toast.makeText(SimulationActivity.this, "Simulation: url-"+responseTxt,
                Toast.LENGTH_LONG).show();
        //Intent intent = new Intent(HomeActivity.this, MainActivity.class);

//Go ahead and perform the transaction


        Pair<Context, String>[] pairs=new Pair[4];
        pairs[0]=new Pair<Context, String>(this,nameValue );
        pairs[1]=new Pair<Context, String>(this,healthValue );
        pairs[2]=new Pair<Context, String>(this,latitudeValue );
        pairs[3]=new Pair<Context, String>(this,longitudeValue );

        String[] params = {nameValue,healthValue,latitudeValue,longitudeValue};
       // new KavachAsyncTask(SimulationActivity.this).execute(params);
        new KavachAsyncTask().execute(pairs);


    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.d("Latitude", "disable");
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.d("Latitude","enable");
    }




}

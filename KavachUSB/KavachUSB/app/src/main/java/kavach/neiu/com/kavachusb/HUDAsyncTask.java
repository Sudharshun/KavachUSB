package kavach.neiu.com.kavachusb;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;
import android.widget.Toast;

import com.appspot.kavachhq.hudapi.model.Container;
import com.appspot.kavachhq.hudapi.Hudapi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by sudha on 3/27/2016.
 */
public class HUDAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {

    private static Hudapi myApiHUDService = null;
    private Context context;
    private CardboardOverlayView mOverlayView;


    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if(myApiHUDService == null) {  // Only do this once

            Hudapi.Builder builder = new Hudapi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://kavachhq.appspot.com/_ah/api/");

            myApiHUDService = builder.build();
        }


        context = params[0].first;

        try {
            //Container checkin=myApiService.HudapiOperations().addcheckin(name,"sai",health,latitude,longitude).execute();
                Container messages=myApiHUDService.hudapi().getmessages().execute();
            String success="Success";
            success=messages.getText();
            return success;

        } catch (IOException e) {
            Log.e("error in HUD", "doInBackground: "+e.getMessage(),e );
            Log.d("sai in HUD", "doInBackground: "+e.getMessage());
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(context, result, Toast.LENGTH_LONG).show();

    }


}

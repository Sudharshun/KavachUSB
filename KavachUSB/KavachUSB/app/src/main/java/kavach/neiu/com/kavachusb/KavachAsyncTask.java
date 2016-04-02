package kavach.neiu.com.kavachusb;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;
import android.widget.Toast;

import com.appspot.kavachhq.garudaapi.Garudaapi;
import com.appspot.kavachhq.garudaapi.model.Container;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by sudha on 3/27/2016.
 */
public class KavachAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {

    private static Garudaapi myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if(myApiService == null) {  // Only do this once
          /*  Garudaapi.Builder builder = new Garudaapi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("https://kavachhq.appspot.com/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });*/
            // end options for devappserver

            Garudaapi.Builder builder = new Garudaapi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://kavachhq.appspot.com/_ah/api/");

            myApiService = builder.build();
        }


        context = params[0].first;
        String name = params[0].second;
        String health=params[1].second;
        String latitude = params[2].second;
        String longitude=params[3].second;
        try {
            Container checkin=myApiService.garudaapi().addcheckin(name,"sai",health,latitude,longitude).execute();

            String success="Success";
            success=checkin.getText();
            return success;

        } catch (IOException e) {
            Log.e("error", "doInBackground: "+e.getMessage(),e );
            Log.d("sai", "doInBackground: "+e.getMessage());
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
    }


}

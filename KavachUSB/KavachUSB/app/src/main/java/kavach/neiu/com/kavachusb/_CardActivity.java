package kavach.neiu.com.kavachusb;

import android.os.Bundle;
import android.view.Menu;

import com.google.vrtoolkit.cardboard.CardboardActivity;
import com.google.vrtoolkit.cardboard.CardboardView;
import com.google.vrtoolkit.cardboard.EyeTransform;
import com.google.vrtoolkit.cardboard.HeadTransform;
import com.google.vrtoolkit.cardboard.Viewport;

import javax.microedition.khronos.egl.EGLConfig;

import kavach.neiu.com.kavachusb.R;

public class _CardActivity extends CardboardActivity implements CardboardView.StereoRenderer {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_cardboard);
	    
	    CardboardView cardboardView = (CardboardView) findViewById(R.id.cardboard_view);
	    // Associate a CardboardView.StereoRenderer with cardboardView.
		cardboardView.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
		cardboardView.setRenderer(this);
	    // Associate the cardboardView with this activity. 
	    setCardboardView(cardboardView);
	   
	   

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		return true;
	}

	@Override
	public void onDrawEye(EyeTransform arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinishFrame(Viewport arg0) {
		// TODO Auto-generated method stub
		
	}
	
		@Override
	public void onNewFrame(HeadTransform arg0) {
		}

	@Override
	public void onRendererShutdown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSurfaceChanged(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSurfaceCreated(EGLConfig arg0) {
		// TODO Auto-generated method stub
		
	}

}

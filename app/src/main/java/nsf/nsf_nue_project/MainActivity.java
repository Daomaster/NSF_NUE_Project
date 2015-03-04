package nsf.nsf_nue_project;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button intro_btn = (Button)findViewById(R.id.intro_btn);
        Button scale_btn = (Button)findViewById(R.id.scalin_law_btn);
        Button device_btn = (Button)findViewById(R.id.device_btn);
        Button application_btn = (Button)findViewById(R.id.application_btn);
       // ImageView facebook_img = (ImageView) findViewById(R.id.facebook_btn);
       // ImageView google_img = (ImageView) findViewById(R.id.gplus_btn);
       // ImageView website_img = (ImageView) findViewById(R.id.website_btn);

        intro_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Intro_activ.class);
                startActivity(intent);
            }
        });
        scale_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Scale_activ.class);
                startActivity(intent);
            }
        });
        device_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Device_activ.class);
                startActivity(intent);
            }
        });
        application_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,App_activ.class);
                startActivity(intent);
            }
        });
       /*
        facebook_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/426253597411506"));
                    startActivity(intent);
                } catch(Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/appetizerandroid")));
                }
            }
        });
        google_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                    startActivity(intent);
            }
        });
        website_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sjlab.com"));
                startActivity(intent);
            }
        });
        */
    }

}

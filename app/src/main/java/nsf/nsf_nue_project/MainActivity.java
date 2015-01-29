package nsf.nsf_nue_project;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
int i=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button intro_btn = (Button)findViewById(R.id.button1);
        Button scale_btn = (Button)findViewById(R.id.button2);
        Button device_btn = (Button)findViewById(R.id.button3);
        Button application_btn = (Button)findViewById(R.id.button4);


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
    }

}

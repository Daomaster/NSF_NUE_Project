package nsf.nsf_nue_project;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class Device_activ extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_activ);
        ImageButton imageButton1 = (ImageButton) findViewById(R.id.imageButton);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button btnone = (Button)findViewById(R.id.button);
        Button btntwo = (Button)findViewById(R.id.button5);
        Button btnthree = (Button)findViewById(R.id.button8);


        btnone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Device_activ.this,Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page",11);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btntwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Device_activ.this,Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page",12);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Device_activ.this,Quiz_activ.class);
                startActivity(intent);
            }
        });

    }
}

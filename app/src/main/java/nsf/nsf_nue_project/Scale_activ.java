package nsf.nsf_nue_project;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class Scale_activ extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_activ);
        ImageButton imageButton1 = (ImageButton) findViewById(R.id.imageButton);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button btnone = (Button) findViewById(R.id.button9);
        Button btntwo = (Button) findViewById(R.id.button5);
        Button btnthree = (Button) findViewById(R.id.button);
        Button btnfour = (Button) findViewById(R.id.button10);
        Button btnfive = (Button) findViewById(R.id.button6);
        Button btnsix = (Button) findViewById(R.id.button7);
        Button btnseven = (Button) findViewById(R.id.button8);


        btnone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Scale_activ.this, Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page", 5);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btntwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Scale_activ.this, Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page", 6);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Scale_activ.this, Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page", 7);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Scale_activ.this, Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page", 8);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnfive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Scale_activ.this, Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page", 9);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnsix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Scale_activ.this, Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page", 10);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnseven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Scale_activ.this,Quiz_activ.class);
                startActivity(intent);
            }
        });


    }
}

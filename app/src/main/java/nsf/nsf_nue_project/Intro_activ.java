package nsf.nsf_nue_project;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class Intro_activ extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_activ);
        ImageButton imageButton1 = (ImageButton) findViewById(R.id.imageButton);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button btnone = (Button)findViewById(R.id.button);
        Button btntwo = (Button)findViewById(R.id.button5);
        Button btnthree = (Button)findViewById(R.id.button6);
        Button btnfour = (Button)findViewById(R.id.button7);
        Button quiz_btn = (Button)findViewById(R.id.button8);

        btnone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intro_activ.this,Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page",1);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btntwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intro_activ.this,Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page",2);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intro_activ.this,Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page",3);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intro_activ.this,Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page",4);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        quiz_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intro_activ.this,Quiz_activ.class);
                startActivity(intent);
            }
        });
    }
}



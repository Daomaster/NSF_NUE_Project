package nsf.nsf_nue_project;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class    Intro_activ extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_activ);

        Button btnNano = (Button)findViewById(R.id.nanotech_btn);
        Button btnMarcoMicro = (Button)findViewById(R.id.macro_micro_btn);
        Button btnNanoScale = (Button)findViewById(R.id.nanoscale_btn);
        Button btnHistory = (Button)findViewById(R.id.history_btn);
        Button quiz_btn = (Button)findViewById(R.id.quiz1_btn);

        btnNano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intro_activ.this,Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page",1);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnMarcoMicro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intro_activ.this,Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page",2);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnNanoScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intro_activ.this,Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page",3);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnHistory.setOnClickListener(new View.OnClickListener() {
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
                Intent intent = new Intent(Intro_activ.this,Quiz1_q1_activ.class);
                startActivity(intent);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_act_bar, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_btn:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}



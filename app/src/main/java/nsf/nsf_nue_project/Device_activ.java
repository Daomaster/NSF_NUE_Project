package nsf.nsf_nue_project;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import nsf.nsf_nue_project.quiz3.Quiz3_q1_activ;


public class Device_activ extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_activ);

        Button btnSem = (Button)findViewById(R.id.sem_btn);
        Button btnAfm = (Button)findViewById(R.id.afm_btn);
        Button btnQuiz3 = (Button)findViewById(R.id.quiz3_btn);

        btnSem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Device_activ.this,Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page",11);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnAfm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Device_activ.this,Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page",12);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnQuiz3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Device_activ.this,Quiz3_q1_activ.class);
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

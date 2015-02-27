package nsf.nsf_nue_project;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class App_activ extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_activ);

        Button btnAsk = (Button)findViewById(R.id.ask_btn);
        Button btnEnrg = (Button)findViewById(R.id.enrg_gen_btn);
        Button btnSelCln = (Button)findViewById(R.id.self_cln_btn);
        Button btnDrugDel = (Button)findViewById(R.id.drug_del_btn);
        Button btnQuiz = (Button)findViewById(R.id.quiz4_btn);

        btnAsk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(App_activ.this,Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page",13);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnEnrg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(App_activ.this,Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page",14);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnSelCln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(App_activ.this,Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page",15);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnDrugDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(App_activ.this,Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page",16);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(App_activ.this,Quiz_activ.class);
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

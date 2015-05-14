package nsf.nsf_nue_project;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import nsf.nsf_nue_project.quiz2.Quiz2_q1_activ;


public class Scale_activ extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_activ);

        Button btnFund = (Button) findViewById(R.id.fundamental_btn);
        Button btnScalingGeo = (Button) findViewById(R.id.scalin_geo_btn);
        Button btnOptical = (Button) findViewById(R.id.optcal_btn);
        Button btnChemical = (Button) findViewById(R.id.chemical_btn);
        Button btnSizeM = (Button) findViewById(R.id.size_matter_btn);
        Button btnScalingRBD = (Button) findViewById(R.id.scaling_rbd_btn);
        Button btnQuiz2= (Button) findViewById(R.id.quiz2_btn);


        btnFund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Scale_activ.this, Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page", 5);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnScalingGeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Scale_activ.this, Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page", 6);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnOptical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Scale_activ.this, Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page", 7);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnChemical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Scale_activ.this, Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page", 8);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnSizeM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Scale_activ.this, Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page", 9);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnScalingRBD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Scale_activ.this, Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page", 10);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnQuiz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Scale_activ.this, Quiz2_q1_activ.class);
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

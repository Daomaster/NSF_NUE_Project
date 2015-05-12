package nsf.nsf_nue_project;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;


public class Quiz2_q2_activ extends ActionBarActivity {

    RadioButton opA;
    RadioButton opB;
    RadioButton opC;
    RadioButton opD;
    ImageView nextBtn;
    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2_q2_activ);
        opA = (RadioButton)findViewById(R.id.quiz2Q2OpA);
        opB = (RadioButton)findViewById(R.id.quiz2Q2OpB);
        opC = (RadioButton)findViewById(R.id.quiz2Q2OpC);
        opD = (RadioButton)findViewById(R.id.quiz2Q2OpD);
        nextBtn = (ImageView)findViewById(R.id.next_btn);
        backBtn = (ImageView)findViewById(R.id.back_btn);


        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quiz2_q2_activ.this, Quiz2_q3_activ.class);

                if(opD.isChecked()) {
                    intent.putExtra("score", 1);
                }
                else {
                    intent.putExtra("score", 0);
                }
                startActivity(intent);
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quiz2_q2_activ.this, Quiz2_q1_activ.class);
                startActivity(intent);
            }
        });
    }
}

package nsf.nsf_nue_project;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;


public class Quiz3_q1_activ extends ActionBarActivity {

    TextView questionTxt;
    RadioButton opA;
    RadioButton opB;
    RadioButton opC;
    RadioButton opD;
    RadioButton opE;
    ImageView nextBtn;
    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3_activ);
        questionTxt = (TextView)findViewById(R.id.question_text);
        opA = (RadioButton)findViewById(R.id.option_a);
        opB = (RadioButton)findViewById(R.id.option_b);
        opC = (RadioButton)findViewById(R.id.option_c);
        opD = (RadioButton)findViewById(R.id.option_d);
        opE = (RadioButton)findViewById(R.id.option_e);
        nextBtn = (ImageView)findViewById(R.id.next_btn);
        backBtn = (ImageView)findViewById(R.id.back_btn);

        String questionArray1[] = getResources().getStringArray(R.array.question1_q3);

        questionTxt.setText(questionArray1[0]);
        opA.setText(questionArray1[1]);
        opB.setText(questionArray1[2]);
        opC.setText(questionArray1[3]);
        opD.setText(questionArray1[4]);
        opE.setText(questionArray1[5]);


        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quiz3_q1_activ.this, Quiz3_q2_activ.class);

                if(opA.isChecked()) {
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
                finish();
            }
        });
    }
}
package nsf.nsf_nue_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;


public class Quiz3_q2_activ extends ActionBarActivity {

    TextView questionTxt;
    RadioButton opA;
    RadioButton opB;
    RadioButton opC;
    RadioButton opD;
    RadioButton opE;
    ImageView nextBtn;
    ImageView backBtn;
    int score;

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

        String questionArray[] = getResources().getStringArray(R.array.question2_q3);

        questionTxt.setText(questionArray[0]);
        opA.setText(questionArray[1]);
        opB.setText(questionArray[2]);
        opC.setText(questionArray[3]);
        opD.setText(questionArray[4]);
        opE.setText(questionArray[5]);

        Intent intent = getIntent();
        score = intent.getIntExtra("score", 0);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent temp = new Intent(Quiz3_q2_activ.this, Score.class);
                if(opE.isChecked()) {
                    temp.putExtra("score", 1 + score);
                }
                else {
                    temp.putExtra("score", 0 + score);
                }
                startActivity(temp);
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quiz3_q2_activ.this, Quiz3_q1_activ.class);
                startActivity(intent);
            }
        });
    }
}
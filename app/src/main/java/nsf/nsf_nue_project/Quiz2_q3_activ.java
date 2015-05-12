package nsf.nsf_nue_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;


public class Quiz2_q3_activ extends ActionBarActivity {

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

        String questionArray[] = getResources().getStringArray(R.array.question3_q2);

        questionTxt.setText(questionArray[0]);
        opA.setText(questionArray[1]);
        opB.setText(questionArray[2]);
        opC.setVisibility(RadioButton.GONE);
        opD.setVisibility(RadioButton.GONE);
        opE.setVisibility(RadioButton.GONE);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quiz2_q3_activ.this, Quiz2_q2_activ.class);

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
                Intent intent = new Intent(Quiz2_q3_activ.this, Quiz2_q2_activ.class);
                startActivity(intent);
            }
        });
    }
}
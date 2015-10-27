package nsf.nsf_nue_project.quiz1;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import nsf.nsf_nue_project.R;

public class Quiz1_q3_activ extends ActionBarActivity {

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
        setContentView(R.layout.activity_quiz_activ);

        questionTxt = (TextView)findViewById(R.id.questionText);
        opA = (RadioButton)findViewById(R.id.option_a);
        opB = (RadioButton)findViewById(R.id.option_b);
        opC = (RadioButton)findViewById(R.id.option_c);
        opD = (RadioButton)findViewById(R.id.option_d);
        opE = (RadioButton)findViewById(R.id.option_e);
        nextBtn = (ImageView)findViewById(R.id.next_btn);
        backBtn = (ImageView)findViewById(R.id.back_btn);

        String questionArray1[] = getResources().getStringArray(R.array.question3_q1);

        questionTxt.setText(questionArray1[0]);
        opA.setText(questionArray1[1]);
        opB.setText(questionArray1[2]);
        opC.setText(questionArray1[3]);
        opD.setText(questionArray1[4]);
        opE.setVisibility(RadioButton.GONE);

        Configuration config = getResources().getConfiguration();
        if (config.smallestScreenWidthDp <= 600) {
            Display display = getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            int screenHeight = size.y;
            int btnTxtSize = (int) (screenHeight * 0.03);
            int questionMargin = (int) (screenHeight * 0.15);
            int answerMargin = (int) (questionMargin/3);

            questionTxt.setTextSize(btnTxtSize);
            setMargins(questionTxt, questionMargin, questionMargin, 0, questionMargin);

            opA.setTextSize(btnTxtSize);
            setMargins(opA, answerMargin, 0, 0, 0);

            opB.setTextSize(btnTxtSize);
            setMargins(opB, answerMargin, 0, 0, 0);

            opC.setTextSize(btnTxtSize);
            setMargins(opC, answerMargin, 0, 0, 0);

            opD.setTextSize(btnTxtSize);
            setMargins(opD, answerMargin, 0, 0, 0);
        }

        Intent intent = getIntent();
        score = intent.getIntExtra("score", 0);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quiz1_q3_activ.this, Quiz1_q4_activ.class);

                if(opB.isChecked()) {
                    score++;
                    intent.putExtra("score", score);
                    Log.i("SCORE3",score+"");
                }
                else {
                    intent.putExtra("score", score);
                }
                startActivity(intent);
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quiz1_q3_activ.this, Quiz1_q2_activ.class);
                startActivity(intent);
            }
        });
    }

    public void setMargins (View view, int left, int top, int right, int bottom) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            p.setMargins(left, top, right, bottom);
            view.requestLayout();
        }
    }
}
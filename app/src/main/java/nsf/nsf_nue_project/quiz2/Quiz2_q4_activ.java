package nsf.nsf_nue_project.quiz2;

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

public class Quiz2_q4_activ extends ActionBarActivity {

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

        String questionArray[] = getResources().getStringArray(R.array.question4_q2);

        questionTxt.setText(questionArray[0]);
        opA.setText(questionArray[1]);
        opB.setText(questionArray[2]);
        opC.setText(questionArray[3]);
        opD.setText(questionArray[4]);
        opE.setVisibility(RadioButton.GONE);

        Intent intent = getIntent();
        score = intent.getIntExtra("score", 0);


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
            setMargins(questionTxt, questionMargin, questionMargin, 0, questionMargin / 2);

            opA.setTextSize(btnTxtSize);
            setMargins(opA, answerMargin, 0, 0, 0);

            opB.setTextSize(btnTxtSize);
            setMargins(opB, answerMargin, 0, 0, 0);

            opC.setTextSize(btnTxtSize);
            setMargins(opC, answerMargin, 0, 0, 0);

            opD.setTextSize(btnTxtSize);
            setMargins(opD, answerMargin, 0, 0, 0);
        }

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent temp = new Intent(Quiz2_q4_activ.this, Quiz2_q5_activ.class);

                if(opD.isChecked()) {
                    score++;
                    temp.putExtra("score", score);
                    Log.i("SCORE4", score + "");
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
                Intent intent = new Intent(Quiz2_q4_activ.this, Quiz2_q3_activ.class);
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
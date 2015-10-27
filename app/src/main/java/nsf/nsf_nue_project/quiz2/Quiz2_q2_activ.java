package nsf.nsf_nue_project.quiz2;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import nsf.nsf_nue_project.R;


public class Quiz2_q2_activ extends ActionBarActivity {

    RadioButton opA;
    RadioButton opB;
    RadioButton opC;
    RadioButton opD;
    TextView question2Q2Text;
    ImageView nextBtn;
    ImageView backBtn;
    int score;
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
        question2Q2Text = (TextView) findViewById(R.id.question2Q2Text);

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
            int answerMargin = (int) (questionMargin*1.3);

            question2Q2Text.setTextSize(btnTxtSize);
            setMargins(question2Q2Text, questionMargin, questionMargin, 0, questionMargin/3);

            opA.setButtonDrawable(R.drawable.quiz2question2opaphone);
            opA.setTextSize(btnTxtSize);
            setMargins(opA, answerMargin, 0, 0, 0);

            opB.setButtonDrawable(R.drawable.quiz2question2opbphone);
            opB.setTextSize(btnTxtSize);
            setMargins(opB, answerMargin/3, 0, 0, 0);

            opC.setButtonDrawable(R.drawable.quiz2question2opcphone);
            opC.setTextSize(btnTxtSize);
            setMargins(opC, answerMargin/3, 0, 0, 0);

            opD.setButtonDrawable(R.drawable.quiz2question2opdphone);
            opD.setTextSize(btnTxtSize);
            setMargins(opD, answerMargin/3, 0, 0, 0);
        }

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent temp = new Intent(Quiz2_q2_activ.this, Quiz2_q3_activ.class);

                if(opD.isChecked()) {
                    score++;
                    temp.putExtra("score", score);
                    Log.i("SCORE2", score + "");
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
                Intent intent = new Intent(Quiz2_q2_activ.this, Quiz2_q1_activ.class);
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

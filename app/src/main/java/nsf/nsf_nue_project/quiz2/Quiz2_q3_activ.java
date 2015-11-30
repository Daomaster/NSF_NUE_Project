package nsf.nsf_nue_project.quiz2;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Typeface;
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


public class Quiz2_q3_activ extends ActionBarActivity {

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

        String questionArray[] = getResources().getStringArray(R.array.question3_q2);

        questionTxt.setText(questionArray[0]);
        opA.setText(questionArray[1]);
        opB.setText(questionArray[2]);
        opC.setVisibility(RadioButton.GONE);
        opD.setVisibility(RadioButton.GONE);
        opE.setVisibility(RadioButton.GONE);

        setFonts();

        Intent intent = getIntent();
        score = intent.getIntExtra("score", 0);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int screenHeight = size.y;
        int questionMargin = (int) (screenHeight * 0.15);
        int answerMargin = (int) (questionMargin/3);

        setMargins(questionTxt, questionMargin, answerMargin, 0, answerMargin);
        setMargins(opA, answerMargin, 0, 0, 0);
        setMargins(opB, answerMargin, 0, 0, 0);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent temp = new Intent(Quiz2_q3_activ.this, Quiz2_q4_activ.class);

                if(opA.isChecked()) {
                    score++;
                    temp.putExtra("score", score);
                    Log.i("SCORE3", score + "");
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
                Intent intent = new Intent(Quiz2_q3_activ.this, Quiz2_q2_activ.class);
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

    private void setFonts() {
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "ArchitectsDaughter.ttf");
        questionTxt.setTypeface(custom_font);
        opA.setTypeface(custom_font);
        opB.setTypeface(custom_font);
    }
}

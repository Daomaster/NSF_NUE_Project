package nsf.nsf_nue_project.quiz1;

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


public class Quiz1_q2_activ extends ActionBarActivity {

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
        Configuration config = getResources().getConfiguration();
        questionTxt = (TextView)findViewById(R.id.questionText);
        opA = (RadioButton)findViewById(R.id.option_a);
        opB = (RadioButton)findViewById(R.id.option_b);
        opC = (RadioButton)findViewById(R.id.option_c);
        opD = (RadioButton)findViewById(R.id.option_d);
        opE = (RadioButton)findViewById(R.id.option_e);
        nextBtn = (ImageView)findViewById(R.id.next_btn);
        backBtn = (ImageView)findViewById(R.id.back_btn);

        String questionArray1[] = getResources().getStringArray(R.array.question2_q1);

        questionTxt.setText(questionArray1[0]);
        opA.setText(questionArray1[1]);
        opB.setText(questionArray1[2]);
        opC.setText(questionArray1[3]);
        opD.setText(questionArray1[4]);
        opE.setVisibility(RadioButton.GONE);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int screenHeight = size.y;
        int questionMargin = (int) (screenHeight * 0.15);
        int answerMargin = (int) (questionMargin/3);

        setMargins(questionTxt, questionMargin, questionMargin, 0, questionMargin);

        setMargins(opA, answerMargin, 0, 0, 0);
        setMargins(opB, answerMargin, 0, 0, 0);
        setMargins(opC, answerMargin, 0, 0, 0);
        setMargins(opD, answerMargin, 0, 0, 0);
        opE.setVisibility(RadioButton.GONE);

        setFonts();

        Intent intent = getIntent();
        score = intent.getIntExtra("score", 0);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quiz1_q2_activ.this, Quiz1_q3_activ.class);

                if(opB.isChecked()) {
                    score++;
                    intent.putExtra("score", score);
                    Log.i("SCORE2", score+"");
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
                Intent intent = new Intent(Quiz1_q2_activ.this, Quiz1_q1_activ.class);
                startActivity(intent);
            }
        });
    }

    private void setFonts() {
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "ArchitectsDaughter.ttf");
        questionTxt.setTypeface(custom_font);

        Typeface custom_font1 = Typeface.createFromAsset(getAssets(), "ArchitectsDaughter.ttf");
        opA.setTypeface(custom_font1);
        Typeface custom_font2 = Typeface.createFromAsset(getAssets(), "ArchitectsDaughter.ttf");
        opB.setTypeface(custom_font2);
        Typeface custom_font3 = Typeface.createFromAsset(getAssets(), "ArchitectsDaughter.ttf");
        opC.setTypeface(custom_font3);
        Typeface custom_font4 = Typeface.createFromAsset(getAssets(), "ArchitectsDaughter.ttf");
        opD.setTypeface(custom_font4);
    }

    public void setMargins (View view, int left, int top, int right, int bottom) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            p.setMargins(left, top, right, bottom);
            view.requestLayout();
        }
    }
}
package nsf.nsf_nue_project.quiz3;

import android.content.Intent;
import android.graphics.Point;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import nsf.nsf_nue_project.R;

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
        setContentView(R.layout.activity_quiz_activ);
        questionTxt = (TextView)findViewById(R.id.questionText);
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

        setFonts();

        setTextDimensions();

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

    private void setTextDimensions() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int screenHeight = size.y;
        int questionMargin = (int) (screenHeight * 0.15);
        int answerMargin = (int) (questionMargin/3);

        setMargins(questionTxt, questionMargin, questionMargin, 0, questionMargin / 2);
        setMargins(opA, answerMargin, 0, 0, 0);
        setMargins(opB, answerMargin, 0, 0, 0);
        setMargins(opC, answerMargin, 0, 0, 0);
        setMargins(opD, answerMargin, 0, 0, 0);
        setMargins(opE, answerMargin, 0, 0, 0);
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
        opC.setTypeface(custom_font);
        opD.setTypeface(custom_font);
        opE.setTypeface(custom_font);
    }

}
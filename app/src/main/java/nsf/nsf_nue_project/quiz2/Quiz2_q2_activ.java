package nsf.nsf_nue_project.quiz2;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import nsf.nsf_nue_project.R;


public class Quiz2_q2_activ extends ActionBarActivity {

    ImageView opA;
    ImageView opB;
    ImageView opC;
    ImageView opD;
    TextView question2Q2Text;
    ImageView nextBtn;
    ImageView backBtn;
    boolean rightAnswer = false;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2_q2_activ);
        opA = (ImageView)findViewById(R.id.quiz2Q2OpA);
        opB = (ImageView)findViewById(R.id.quiz2Q2OpB);
        opC = (ImageView)findViewById(R.id.quiz2Q2OpC);
        opD = (ImageView)findViewById(R.id.quiz2Q2OpD);
        nextBtn = (ImageView)findViewById(R.id.next_btn);
        backBtn = (ImageView)findViewById(R.id.back_btn);
        question2Q2Text = (TextView) findViewById(R.id.question2Q2Text);

        toggleHideyBar();

        Intent intent = getIntent();
        score = intent.getIntExtra("score", 0);

        setFonts();

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int screenHeight = size.y;
        int questionMargin = (int) (screenHeight * 0.15);
        int answerMargin = (int) (questionMargin*1.3);

        Configuration config = getResources().getConfiguration();
        if (config.smallestScreenWidthDp <= 600) {
            setMargins(question2Q2Text, questionMargin, questionMargin, 0, questionMargin / 3);

            opA.setImageDrawable((getResources().getDrawable(R.drawable.quiz2question2opaphone)));
            setMargins(opA, answerMargin, 0, 0, 0);
            opA.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    opA.setBackgroundColor(Color.parseColor("#000099"));

                    opB.setBackgroundColor(Color.TRANSPARENT);
                    opC.setBackgroundColor(Color.TRANSPARENT);
                    opD.setBackgroundColor(Color.TRANSPARENT);

                    rightAnswer = false;
                }

            });

            opB.setImageDrawable((getResources().getDrawable(R.drawable.quiz2question2opbphone)));
            setMargins(opB, answerMargin / 3, 0, 0, 0);
            opB.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    opB.setBackgroundColor(Color.parseColor("#000099"));

                    opA.setBackgroundColor(Color.TRANSPARENT);
                    opC.setBackgroundColor(Color.TRANSPARENT);
                    opD.setBackgroundColor(Color.TRANSPARENT);

                    rightAnswer = false;
                }

            });

            opC.setImageDrawable((getResources().getDrawable(R.drawable.quiz2question2opcphone)));
            setMargins(opC, answerMargin / 3, 0, 0, 0);
            opC.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    opC.setBackgroundColor(Color.parseColor("#000099"));

                    opA.setBackgroundColor(Color.TRANSPARENT);
                    opB.setBackgroundColor(Color.TRANSPARENT);
                    opD.setBackgroundColor(Color.TRANSPARENT);

                    rightAnswer = false;
                }

            });

            opD.setImageDrawable((getResources().getDrawable(R.drawable.quiz2question2opdphone)));
            setMargins(opD, answerMargin / 3, 0, 0, 0);
            opD.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    opD.setBackgroundColor(Color.parseColor("#000099"));

                    opA.setBackgroundColor(Color.TRANSPARENT);
                    opB.setBackgroundColor(Color.TRANSPARENT);
                    opC.setBackgroundColor(Color.TRANSPARENT);

                    rightAnswer = true;
                }

            });

        }

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent temp = new Intent(Quiz2_q2_activ.this, Quiz2_q3_activ.class);

                if(rightAnswer) {
                    Log.i("answer", "true");
                    score++;
                    temp.putExtra("score", score);
                    Log.i("SCORE2", score + "");
                }
                else {
                    Log.i("answer", "false");
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

    public void toggleHideyBar() {

        // BEGIN_INCLUDE (get_current_ui_flags)
        // The UI options currently enabled are represented by a bitfield.
        // getSystemUiVisibility() gives us that bitfield.
        int uiOptions = this.getWindow().getDecorView().getSystemUiVisibility();
        int newUiOptions = uiOptions;
        // END_INCLUDE (get_current_ui_flags)
        // BEGIN_INCLUDE (toggle_ui_flags)
        boolean isImmersiveModeEnabled =
                ((uiOptions | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY) == uiOptions);

        // Navigation bar hiding:  Backwards compatible to ICS.
        if (Build.VERSION.SDK_INT >= 14) {
            newUiOptions ^= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        }

        // Status bar hiding: Backwards compatible to Jellybean
        if (Build.VERSION.SDK_INT >= 16) {
            newUiOptions ^= View.SYSTEM_UI_FLAG_FULLSCREEN;
        }

        if (Build.VERSION.SDK_INT >= 18) {
            newUiOptions ^= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        }

        this.getWindow().getDecorView().setSystemUiVisibility(newUiOptions);
        //END_INCLUDE (set_ui_flags)
    }

    private void setFonts() {
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "ArchitectsDaughter.ttf");
        question2Q2Text.setTypeface(custom_font);
    }

    public void setMargins (View view, int left, int top, int right, int bottom) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            p.setMargins(left, top, right, bottom);
            view.requestLayout();
        }
    }
}

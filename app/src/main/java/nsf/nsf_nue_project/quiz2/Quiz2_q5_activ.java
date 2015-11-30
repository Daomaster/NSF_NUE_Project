package nsf.nsf_nue_project.quiz2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import nsf.nsf_nue_project.R;
import nsf.nsf_nue_project.Score;

public class Quiz2_q5_activ extends ActionBarActivity {

    int score;
    ImageView nextBtn;
    ImageView backBtn;
    TextView questionText;
    TextView colATitle;
    TextView colBTitle;
    TextView colAOptions;
    TextView colBOptions;
    EditText opA;
    EditText opB;
    EditText opC;
    double valueOpA = 0;
    double valueOpB = 0;
    double valueOpC = 0;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2_q5_activ);
        opA = (EditText) findViewById(R.id.editText);
        opB = (EditText) findViewById(R.id.editText2);
        opC = (EditText) findViewById(R.id.editText3);
        nextBtn = (ImageView)findViewById(R.id.next_btn);
        backBtn = (ImageView)findViewById(R.id.back_btn);
        questionText = (TextView) findViewById(R.id.questionText);
        colATitle = (TextView) findViewById(R.id.colATitle);
        colBTitle = (TextView) findViewById(R.id.colBTitle);
        colAOptions = (TextView) findViewById(R.id.colAOptions);
        colBOptions = (TextView) findViewById(R.id.colBOptions);
        builder = new AlertDialog.Builder(this);

        //getting the the accumulated score
        Intent intent = getIntent();
        score = intent.getIntExtra("score", 0);

        setFonts();

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int screenHeight = size.y;
        int txtMargin = (int) (screenHeight * 0.15);
        int editTxtMargin = (int) (screenHeight * 0.04);

        setMargins(questionText, 0, 0, 0, 0);
        setMargins(colATitle, txtMargin*2, 0, 0, 0);
        setMargins(colBTitle, 0, 0, txtMargin*2, 0);
        setMargins(colAOptions, txtMargin, 0, 0, 0);
        setMargins(colBOptions, 0, 0, 0, 0);
        setMargins(opA, 0, 0, 0, editTxtMargin);
        setMargins(opB, 0, 0, 0, editTxtMargin);
        setMargins(opC, 0, 0, 0, 0);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent temp = new Intent(Quiz2_q5_activ.this, Score.class);

                try {
                    //getting the values on the editTexts
                    valueOpA = Double.parseDouble(opA.getText().toString());
                    valueOpB = Double.parseDouble(opB.getText().toString());
                    valueOpC = Double.parseDouble(opC.getText().toString());

                }catch (NumberFormatException e){
                        // this is not a number. tell the user something here or do something
                        Log.e("yourAppTag", Log.getStackTraceString(e));
                }

                //verificating the question and sending the string that will be printed on the Score Activity
                if(verficateValue(valueOpA, opA) == false || verficateValue(valueOpB, opB) == false ||
                        verficateValue(valueOpC, opC) == false){

                    builder.setMessage("Please, insert numbers between 1 and 3.")
                            .setTitle("Invalid Number")
                            .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            });

                    builder.show();
                } else if(valueOpA == 2 && valueOpB == 1 && valueOpC == 3){
                    score++;
                    temp.putExtra("score", score + "/5");
                    Log.i("SCORE5", score + "");
                    startActivity(temp);

                } else {
                    temp.putExtra("score", score + "/5");
                    startActivity(temp);
                }

            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quiz2_q5_activ.this, Quiz2_q4_activ.class);
                startActivity(intent);
            }
        });
    }

    boolean verficateValue(double value, EditText op){
        if(value < 1 || value >3){
            op.setText("");
            return false;
        }
        return true;
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
        questionText.setTypeface(custom_font);
        colATitle.setTypeface(custom_font);
        colBTitle.setTypeface(custom_font);
        colAOptions.setTypeface(custom_font);
        colBOptions.setTypeface(custom_font);
    }

}

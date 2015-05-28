package nsf.nsf_nue_project.quiz2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import nsf.nsf_nue_project.R;
import nsf.nsf_nue_project.Score;

public class Quiz2_q5_activ extends ActionBarActivity {

    int score;
    ImageView nextBtn;
    ImageView backBtn;
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
        //getting the fields from the xml file
        opA = (EditText) findViewById(R.id.editText);
        opB = (EditText) findViewById(R.id.editText2);
        opC = (EditText) findViewById(R.id.editText3);
        nextBtn = (ImageView)findViewById(R.id.next_btn);
        backBtn = (ImageView)findViewById(R.id.back_btn);
        builder = new AlertDialog.Builder(this);


        //getting the the score accumulated
        Intent intent = getIntent();
        score = intent.getIntExtra("score", 0);

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
}

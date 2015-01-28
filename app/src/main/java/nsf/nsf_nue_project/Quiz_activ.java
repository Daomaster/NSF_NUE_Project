package nsf.nsf_nue_project;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class Quiz_activ extends ActionBarActivity {
    boolean q1 = false;
    boolean q2 = false;
    boolean q3 = false;
    boolean q4 = false;
    boolean q5 = false;
    int score = 3;
    int result = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz01);
        Button submit = (Button) findViewById(R.id.button13);
        Button returnbtn = (Button) findViewById(R.id.button14);
        final RadioGroup question1 = (RadioGroup) findViewById(R.id.radioGroup);
        final RadioGroup question2 = (RadioGroup) findViewById(R.id.radioGroup2);
        final RadioGroup question3 = (RadioGroup) findViewById(R.id.radioGroup6);
        final RadioGroup question4 = (RadioGroup) findViewById(R.id.radioGroup3);
        final RadioGroup question5 = (RadioGroup) findViewById(R.id.radioGroup4);
        final RadioButton right1 = (RadioButton) findViewById(R.id.radioButton);
        final RadioButton right2 = (RadioButton) findViewById(R.id.radioButton6);
        final RadioButton right3 = (RadioButton) findViewById(R.id.radioButton9);
        final RadioButton right4 = (RadioButton) findViewById(R.id.radioButton15);
        final RadioButton right5 = (RadioButton) findViewById(R.id.radioButton18);

        question1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (right1.getId() == checkedId) {
                    q1 = true;
                    score++;
                }
            }
        });

        question2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (right2.getId() == checkedId) {
                    q2 = true;
                    score++;
                }
            }
        });

        question3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (right3.getId() == checkedId) {
                    q3 = true;
                    score++;
                }
            }
        });

        question4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (right4.getId() == checkedId) {
                    q4 = true;
                    score++;
                }
            }
        });

        question5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (right5.getId() == checkedId) {
                    q5 = true;
                    score++;
                }
            }
        });

        result = score;

        //Creat the dialog
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Your Score is "+result+"/5")
                .setTitle("Quiz Score")
                .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("Retry", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        question1.clearCheck();
                        question2.clearCheck();
                        question3.clearCheck();
                        question4.clearCheck();
                        question5.clearCheck();

                    }
                });
        final AlertDialog dialog = builder.create();

        returnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               dialog.show();
            }
        });







    }


    }





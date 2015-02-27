package nsf.nsf_nue_project;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class Quiz_activ extends ActionBarActivity {
    boolean q1 = false;
    boolean q2 = false;
    boolean q3 = false;
    boolean q4 = false;
    boolean q5 = false;

    private int dynScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz01);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_quiz_activ, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        //Creat the dialog
        final RadioGroup question1 = (RadioGroup) findViewById(R.id.radioGroup);
        final RadioGroup question2 = (RadioGroup) findViewById(R.id.radioGroup2);
        final RadioGroup question3 = (RadioGroup) findViewById(R.id.radioGroup3);
        final RadioGroup question4 = (RadioGroup) findViewById(R.id.radioGroup4);
        final RadioGroup question5 = (RadioGroup) findViewById(R.id.radioGroup5);
        final RadioGroup question6 = (RadioGroup) findViewById(R.id.radioGroup6);
        final RadioButton right1 = (RadioButton) findViewById(R.id.radioButton);
        final RadioButton right2 = (RadioButton) findViewById(R.id.radioButton6);
        final RadioButton right3 = (RadioButton) findViewById(R.id.radioButton15);
        final RadioButton right4 = (RadioButton) findViewById(R.id.radioButton19);
        final RadioButton right5 = (RadioButton) findViewById(R.id.radioButton10);
        final RadioButton right6 = (RadioButton) findViewById(R.id.radioButton22);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        question1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (right1.getId() == checkedId) {
                    q1 = true;
                    Log.i("1dynScr",dynScore+"");
                }
            }
        });

        question2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (right2.getId() == checkedId) {
                    q2 = true;
                    Log.i("2dynScr", dynScore + "");
                }
            }
        });

        question3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (right3.getId() == checkedId) {
                    q3 = true;
                    Log.i("3dynScr", dynScore + "");
                }
            }
        });

        question4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (right4.getId() == checkedId) {
                    q4 = true;
                    Log.i("4dynScr",dynScore+"");
                }
            }
        });

        question5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (right5.getId() == checkedId) {
                    q5 = true;
                    Log.i("5dynScr",dynScore+"");
                }
            }
        });

        question6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (right6.getId() == checkedId) {
                    q5 = true;
                    Log.i("5dynScr",dynScore+"");
                }
            }
        });
        Log.i("DYNAMIC SCORE",3+"");
        builder.setMessage("Your Score is "+3+"/6")
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
                        question6.clearCheck();
                    }
                });

        final AlertDialog dialog = builder.create();
        switch (item.getItemId()) {
            case R.id.action_menu:
                finish();
                return true;
            case R.id.action_submit:
                dialog.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}





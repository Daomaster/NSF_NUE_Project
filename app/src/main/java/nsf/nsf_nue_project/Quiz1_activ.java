package nsf.nsf_nue_project;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class Quiz1_activ extends ActionBarActivity {

    TextView questionTxt;
    RadioButton opA;
    RadioButton opB;
    RadioButton opC;
    RadioButton opD;

    int question = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz01);
        Log.i("TEST", "TESTING");
        questionTxt = (TextView)findViewById(R.id.question_text);
        opA = (RadioButton)findViewById(R.id.option_a);
        opB = (RadioButton)findViewById(R.id.option_b);
        opC = (RadioButton)findViewById(R.id.option_c);
        opD = (RadioButton)findViewById(R.id.option_d);

        String questionArray1[] = getResources().getStringArray(R.array.question1);

        displayQuestions(questionArray1);
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
        questionTxt = (TextView)findViewById(R.id.question_text);
        opA = (RadioButton)findViewById(R.id.option_a);
        opB = (RadioButton)findViewById(R.id.option_b);
        opC = (RadioButton)findViewById(R.id.option_c);
        opD = (RadioButton)findViewById(R.id.option_d);

        switch (item.getItemId()) {
            case R.id.action_menu:
                if(question<=0) {
                    finish();
                } else {
                    question--;
                    changeQuestion();
                }
                return true;
            case R.id.action_submit:
                changeQuestion();

                if(question!=3)
                    question++;

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void changeQuestion() {

        if(question==1) {
            String questionArray2[] = getResources().getStringArray(R.array.question2);

            displayQuestions(questionArray2);
        } else if (question==2) {
            String questionArray3[] = getResources().getStringArray(R.array.question3);

            displayQuestions(questionArray3);
        } else if(question==3){
            String questionArray4[] = getResources().getStringArray(R.array.question4);

            questionTxt.setText(questionArray4[0]);
            opA.setText(questionArray4[1]);
            opB.setText(questionArray4[2]);
            opC.setVisibility(RadioButton.GONE);
            opD.setVisibility(RadioButton.GONE);
        } else {
            String questionArray1[] = getResources().getStringArray(R.array.question1);

            displayQuestions(questionArray1);
        }
    }

    private void displayQuestions(String[] questionArray) {
        questionTxt.setText(questionArray[0]);
        opA.setText(questionArray[1]);
        opB.setText(questionArray[2]);
        opC.setText(questionArray[3]);
        opD.setText(questionArray[4]);
    }
}

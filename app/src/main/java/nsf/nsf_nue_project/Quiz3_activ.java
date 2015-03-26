package nsf.nsf_nue_project;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.TextView;


public class Quiz3_activ extends ActionBarActivity {

    TextView questionTxt;
    RadioButton opA;
    RadioButton opB;
    RadioButton opC;
    RadioButton opD;
    RadioButton opE;

    int question = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3_activ);
        questionTxt = (TextView)findViewById(R.id.question_text);
        opA = (RadioButton)findViewById(R.id.option_a);
        opB = (RadioButton)findViewById(R.id.option_b);
        opC = (RadioButton)findViewById(R.id.option_c);
        opD = (RadioButton)findViewById(R.id.option_d);
        opE = (RadioButton)findViewById(R.id.option_e);

        String questionArray1[] = getResources().getStringArray(R.array.question1_q3);

        questionTxt.setText(questionArray1[0]);
        opA.setText(questionArray1[1]);
        opB.setText(questionArray1[2]);
        opC.setText(questionArray1[3]);
        opD.setText(questionArray1[4]);
        opE.setText(questionArray1[5]);
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
                question--;
                if(question<=0) {
                    finish();
                } else {
                    changeQuestion();
                }
                return true;
            case R.id.action_submit:
                if(question!=2) {
                    question++;

                changeQuestion();
                }

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void changeQuestion() {

        if(question==2) {
            String questionArray2[] = getResources().getStringArray(R.array.question2_q3);

            questionTxt.setText(questionArray2[0]);
            opA.setText(questionArray2[1]);
            opB.setText(questionArray2[2]);
            opC.setText(questionArray2[3]);
            opD.setText(questionArray2[4]);
            opE.setText(questionArray2[5]);
        } else {
            String questionArray1[] = getResources().getStringArray(R.array.question1_q3);

            questionTxt.setText(questionArray1[0]);
            opA.setText(questionArray1[1]);
            opB.setText(questionArray1[2]);
            opC.setText(questionArray1[3]);
            opD.setText(questionArray1[4]);
            opE.setText(questionArray1[5]);
        }
    }
}

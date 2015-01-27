package nsf.nsf_nue_project;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class Quiz_activ extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz01);
        RadioGroup question1 = (RadioGroup)findViewById(R.id.radioGroup);
        RadioGroup question2 = (RadioGroup)findViewById(R.id.radioGroup2);
        RadioGroup question3 = (RadioGroup)findViewById(R.id.radioGroup6);
        RadioGroup question4 = (RadioGroup)findViewById(R.id.radioGroup3);
        RadioGroup question5 = (RadioGroup)findViewById(R.id.radioGroup4);
        RadioGroup question6 = (RadioGroup)findViewById(R.id.radioGroup5);
        final RadioButton right1 = (RadioButton)findViewById(R.id.radioButton);
        final RadioButton right2 = (RadioButton)findViewById(R.id.radioButton6);
        final RadioButton right3 = (RadioButton)findViewById(R.id.radioButton9);
        final RadioButton right4 = (RadioButton)findViewById(R.id.radioButton15);
        final RadioButton right5 = (RadioButton)findViewById(R.id.radioButton18);
        final RadioButton right6 = (RadioButton)findViewById(R.id.radioButton23);


        question1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(right1.getId() ==checkedId){
                    System.out.println("female");
                    Toast.makeText(Quiz_activ.this, "Correct!", Toast.LENGTH_LONG).show();
                }else {
                    System.out.println("male");
                    Toast.makeText(Quiz_activ.this, "The Correct Answer is "+ right1.getText() , Toast.LENGTH_LONG).show();
                }
            }
        });

        question2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(right2.getId() ==checkedId){
                    System.out.println("female");
                    Toast.makeText(Quiz_activ.this, "Correct!", Toast.LENGTH_SHORT).show();
                }else {
                    System.out.println("male");
                    Toast.makeText(Quiz_activ.this, "The Correct Answer is "+ right2.getText() , Toast.LENGTH_SHORT).show();
                }
            }
        });

        question3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(right3.getId() ==checkedId){
                    System.out.println("female");
                    Toast.makeText(Quiz_activ.this, "Correct!", Toast.LENGTH_SHORT).show();
                }else {
                    System.out.println("male");
                    Toast.makeText(Quiz_activ.this, "The Correct Answer is "+ right3.getText() , Toast.LENGTH_SHORT).show();
                }
            }
        });

        question4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(right4.getId() ==checkedId){
                    System.out.println("female");
                    Toast.makeText(Quiz_activ.this, "Correct!", Toast.LENGTH_SHORT).show();
                }else {
                    System.out.println("male");
                    Toast.makeText(Quiz_activ.this, "The Correct Answer is "+ right4.getText() , Toast.LENGTH_SHORT).show();
                }
            }
        });

        question5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(right5.getId() ==checkedId){
                    System.out.println("female");
                    Toast.makeText(Quiz_activ.this, "Correct!", Toast.LENGTH_SHORT).show();
                }else {
                    System.out.println("male");
                    Toast.makeText(Quiz_activ.this, "The Correct Answer is "+ right5.getText() , Toast.LENGTH_SHORT).show();
                }
            }
        });

        question6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(right6.getId() ==checkedId){
                    System.out.println("female");
                    Toast.makeText(Quiz_activ.this, "Correct!", Toast.LENGTH_SHORT).show();
                }else {
                    System.out.println("male");
                    Toast.makeText(Quiz_activ.this, "The Correct Answer is "+ right6.getText() , Toast.LENGTH_SHORT).show();
                }
            }
        });



    }



}

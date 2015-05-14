package nsf.nsf_nue_project;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

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
                if(valueOpA == 2 && valueOpB == 1 && valueOpC == 3){
                    score++;
                    temp.putExtra("score", score + "/5");
                    Log.i("SCORE5", score+"");
                } else {
                    temp.putExtra("score", score + "/5");
                }

                startActivity(temp);
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
}

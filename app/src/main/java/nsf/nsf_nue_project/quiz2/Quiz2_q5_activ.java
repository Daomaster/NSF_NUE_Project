package nsf.nsf_nue_project.quiz2;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;

import nsf.nsf_nue_project.R;
import nsf.nsf_nue_project.Score;

public class Quiz2_q5_activ extends ActionBarActivity {

    int score;
    ImageView nextBtn;
    ImageView backBtn;
    TextView questionText;
    TextView colATitle;
    TextView colBTitle;
    TextView colAOption1;
    TextView colAOption2;
    TextView colAOption3;
    TextView colBOption1;
    TextView colBOption2;
    TextView colBOption3;
    Spinner opA;
    Spinner opB;
    Spinner opC;
    double valueOpA = 0;
    double valueOpB = 0;
    double valueOpC = 0;
    AlertDialog.Builder builder;
    HashMap<Integer, Boolean> questions = new HashMap<Integer, Boolean>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2_q5_activ);
        nextBtn = (ImageView)findViewById(R.id.next_btn);
        backBtn = (ImageView)findViewById(R.id.back_btn);
        questionText = (TextView) findViewById(R.id.questionText);
        colATitle = (TextView) findViewById(R.id.colATitle);
        colBTitle = (TextView) findViewById(R.id.colBTitle);
        colAOption1 = (TextView) findViewById(R.id.colAOption1);
        colAOption2 = (TextView) findViewById(R.id.colAOption2);
        colAOption3 = (TextView) findViewById(R.id.colAOption3);
        colBOption1 = (TextView) findViewById(R.id.colBOption1);
        colBOption2 = (TextView) findViewById(R.id.colBOption2);
        colBOption3 = (TextView) findViewById(R.id.colBOption3);
        opA = (Spinner)findViewById(R.id.drop1);
        opB = (Spinner)findViewById(R.id.drop2);
        opC = (Spinner)findViewById(R.id.drop3);
        builder = new AlertDialog.Builder(this);

        toggleHideyBar();

        //getting the the accumulated score
        Intent intent = getIntent();
        score = intent.getIntExtra("score", 0);

        setFonts();

        String[] items = new String[]{"1", "2", "3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        opA.setAdapter(adapter);
        opB.setAdapter(adapter);
        opC.setAdapter(adapter);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int screenHeight = size.y;
        int txtMargin = (int) (screenHeight * 0.15);

        setMargins(colATitle, txtMargin*2, 0, 0, 0);
        setMargins(colBTitle, 0, 0, txtMargin*2, 0);

        final HashMap<Integer, Boolean> questions = (HashMap<Integer, Boolean>) intent.getSerializableExtra("questions");
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent temp = new Intent(Quiz2_q5_activ.this, Score.class);

                try {
                    //getting the values on the editTexts
                    valueOpA = Double.parseDouble(opA.getSelectedItem().toString());
                    valueOpB = Double.parseDouble(opB.getSelectedItem().toString());
                    valueOpC = Double.parseDouble(opC.getSelectedItem().toString());

                } catch (NumberFormatException e) {
                    // this is not a number. tell the user something here or do something
                    Log.e("yourAppTag", Log.getStackTraceString(e));
                }


                if (valueOpA == 2 && valueOpB == 1 && valueOpC == 3) {
                    score++;
                    questions.put(5, true);

                    temp.putExtra("questions", questions);
                    temp.putExtra("score", score + "/5");
                    Log.i("SCORE5", score + "");
                    startActivity(temp);

                } else {
                    temp.putExtra("score", score + "/5");
                    questions.put(5, false);

                    temp.putExtra("questions", questions);
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
        colAOption1.setTypeface(custom_font);
        colAOption2.setTypeface(custom_font);
        colAOption3.setTypeface(custom_font);
        colBOption1.setTypeface(custom_font);
        colBOption2.setTypeface(custom_font);
        colBOption3.setTypeface(custom_font);
    }

}

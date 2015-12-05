package nsf.nsf_nue_project;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;


public class Score extends ActionBarActivity {
    TableRow titlesRow;
    TableRow valuesRow;
    TextView scoreValue;
    RelativeLayout scoreLayout;
    Drawable background;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        toggleHideyBar();

        Drawable d = getResources().getDrawable(R.drawable.layout_top);
        getSupportActionBar().setBackgroundDrawable(d);

        Intent intent = getIntent();
        String scoreStr = intent.getStringExtra("score");
        scoreValue = (TextView) findViewById(R.id.score_value);
        scoreValue = (TextView) findViewById(R.id.score_value);
        scoreValue.setText(scoreStr);

        scoreLayout = (RelativeLayout) findViewById(R.id.score_layout);

        String[] fraction = scoreStr.split("/");
        int scoreInt = Integer.parseInt(fraction[0]) / Integer.parseInt(fraction[1]);

        setBackground(scoreInt);

        scoreLayout.setBackground(background);

        final HashMap<Integer, Boolean> questions = (HashMap<Integer, Boolean>) intent.getSerializableExtra("questions");
        valuesRow = (TableRow) findViewById(R.id.value_row);
        titlesRow = (TableRow) findViewById(R.id.title_row);

        for (int i = 0; i < questions.size(); i++) {
            final TextView tittle = new TextView(this);
            tittle.setText(String.valueOf(i+1));
            tittle.setPadding(5, 5, 5, 5);
            tittle.setTextColor(Color.parseColor("#304261"));
            tittle.setGravity(Gravity.CENTER);
            tittle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            tittle.setTypeface(Typeface.DEFAULT_BOLD);

            titlesRow.addView(tittle);
            final ImageView answer = new ImageView(this);

            if (questions.get(i+1) == true) {
                answer.setBackground(getResources().getDrawable(R.drawable.check_img));
            } else {
                answer.setBackground(getResources().getDrawable(R.drawable.x_img));
            }
            valuesRow.addView(answer);
        }

        questions.clear();
    }

    private void setBackground(int scoreInt) {
        if (scoreInt <= 0.25) {
            background = getResources().getDrawable(R.drawable.score_tryagain);
        } else if (scoreInt <= 0.5) {
            background = getResources().getDrawable(R.drawable.score_good);
        } else if (scoreInt <= 0.75) {
            background = getResources().getDrawable(R.drawable.score_verygood);
        } else {
            background = getResources().getDrawable(R.drawable.score_excellent);
        }
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

    public void setMargins(View view, int left, int top, int right, int bottom) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            p.setMargins(left, top, right, bottom);
            view.requestLayout();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_act_bar, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_btn:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

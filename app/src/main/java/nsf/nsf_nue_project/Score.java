package nsf.nsf_nue_project;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Score extends ActionBarActivity {
    TextView scoreTV;
    TextView scoreTittle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Drawable d = getResources().getDrawable(R.drawable.layout_top);
        getSupportActionBar().setBackgroundDrawable(d);

        Intent intent = getIntent();
        String score = intent.getStringExtra("score");

        scoreTV = (TextView) findViewById(R.id.score_textview);
        scoreTV.setText(score);

        scoreTittle = (TextView) findViewById(R.id.scoreTittle);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int screenHeight = size.y;
        int txtSize = (int) (screenHeight * 0.11);
        int txtMargin = (int) (screenHeight * 0.08);

        scoreTV.setTextSize(txtSize);
        setMargins(scoreTV, 0, txtMargin, 0, 0);

        scoreTittle.setTextSize(txtSize);
        setMargins(scoreTittle, 0, 0, 0, txtMargin);
    }

    public void setMargins (View view, int left, int top, int right, int bottom) {
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
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

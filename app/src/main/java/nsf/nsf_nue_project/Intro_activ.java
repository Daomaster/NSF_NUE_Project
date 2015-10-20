package nsf.nsf_nue_project;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import nsf.nsf_nue_project.quiz1.Quiz1_q1_activ;


public class Intro_activ extends ActionBarActivity {

    private Button btnNano;
    private Button btnMarcoMicro;
    private Button btnNanoScale;
    private Button btnHistory;
    private Button quizBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration config = getResources().getConfiguration();

        if (config.smallestScreenWidthDp >= 600) {
            setContentView(R.layout.activity_intro_activ);

            btnNano = (Button)findViewById(R.id.nanotech_btn);
            btnMarcoMicro = (Button)findViewById(R.id.macro_micro_btn);
            btnNanoScale = (Button)findViewById(R.id.nanoscale_btn);
            btnHistory = (Button)findViewById(R.id.history_btn);
            quizBtn = (Button)findViewById(R.id.quiz1_btn);

        } else {
            setContentView(R.layout.activity_intro_activ_small);

            LinearLayout.LayoutParams lpView = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            Display display = getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            int screenWidth = size.x;
            int screenHeight = size.y;

            setButtons(screenHeight, screenWidth);
        }

        setButtonActions();
    }

    private void setButtonActions() {
        btnNano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intro_activ.this,Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page",1);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnMarcoMicro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intro_activ.this,Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page",2);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnNanoScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intro_activ.this,Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page",3);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intro_activ.this,Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page",4);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        quizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intro_activ.this,Quiz1_q1_activ.class);
                startActivity(intent);
            }
        });
    }

    private void setButtons(int screenHeight, int screenWidth) {
        int btnMargin = (int) (screenHeight * 0.075);
        int btnHeight = (int) (screenHeight * 0.16);
        int btnWidth = (int) (screenWidth * 0.42);
        int btnTxtSize = (int) (screenHeight * 0.019);

        btnNano = (Button) findViewById(R.id.nanotech_btn_phone);
        setMargins(btnNano, btnMargin, btnMargin, 0, 0);
        setWidthAndHeight(btnNano, btnWidth, btnHeight);
        btnNano.setTextSize(btnTxtSize);

        btnMarcoMicro = (Button) findViewById(R.id.macro_micro_btn_phone);
        setMargins(btnMarcoMicro, 0, btnMargin, btnMargin, 0);
        setWidthAndHeight(btnMarcoMicro, btnWidth, btnHeight);
        btnMarcoMicro.setTextSize(btnTxtSize);

        btnNanoScale = (Button) findViewById(R.id.nanoscale_btn_phone);
        setMargins(btnNanoScale, btnMargin, btnMargin, 0, 0);
        setWidthAndHeight(btnNanoScale, btnWidth, btnHeight);
        btnNanoScale.setTextSize(btnTxtSize);

        btnHistory = (Button) findViewById(R.id.history_btn_phone);
        setMargins(btnHistory, 0, btnMargin, btnMargin, 0);
        setWidthAndHeight(btnHistory, btnWidth, btnHeight);
        btnHistory.setTextSize(btnTxtSize);

        quizBtn = (Button) findViewById(R.id.quiz1_btn_phone);
        setMargins(quizBtn, 0, 0, 0, btnMargin);
        setWidthAndHeight(quizBtn, btnWidth, btnHeight);
        quizBtn.setTextSize(btnTxtSize);
    }

    public void setMargins (View view, int left, int top, int right, int bottom) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            p.setMargins(left, top, right, bottom);
            view.requestLayout();
        }
    }

    private void setWidthAndHeight(View view, int width, int height) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.width = width;
        params.height = height;
        view.setLayoutParams(params);
        view.requestLayout();
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



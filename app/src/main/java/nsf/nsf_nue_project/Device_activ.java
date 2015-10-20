package nsf.nsf_nue_project;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import nsf.nsf_nue_project.quiz1.Quiz1_q1_activ;
import nsf.nsf_nue_project.quiz3.Quiz3_q1_activ;


public class Device_activ extends ActionBarActivity {
    private Button btnSem;
    private Button btnAfm;
    private Button btnQuiz3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration config = getResources().getConfiguration();

        if (config.smallestScreenWidthDp >= 600) {
            setContentView(R.layout.activity_device_activ);

            btnSem = (Button)findViewById(R.id.sem_btn);
            btnAfm = (Button)findViewById(R.id.afm_btn);
            btnQuiz3 = (Button)findViewById(R.id.quiz3_btn);

        } else {
            setContentView(R.layout.activity_device_activ_small);

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

    private void setButtons(int screenHeight, int screenWidth) {
        int btnMargin = (int) (screenHeight * 0.075);
        int btnHeight = (int) (screenHeight * 0.16);
        int btnWidth = (int) (screenWidth * 0.42);
        int btnTxtSize = (int) (screenHeight * 0.019);

        btnSem = (Button)findViewById(R.id.sem_btn_phone);
        setMargins(btnSem, btnMargin, btnMargin, 0, 0);
        setWidthAndHeight(btnSem, btnWidth, btnHeight);
        btnSem.setTextSize(btnTxtSize);

        btnAfm = (Button)findViewById(R.id.afm_btn_phone);
        setMargins(btnAfm, 0, btnMargin, btnMargin, 0);
        setWidthAndHeight(btnAfm, btnWidth, btnHeight);
        btnAfm.setTextSize(btnTxtSize);

        btnQuiz3 = (Button)findViewById(R.id.quiz3_btn_phone);
        setMargins(btnQuiz3, 0, 0, 0, btnMargin);
        setWidthAndHeight(btnQuiz3, btnWidth, btnHeight);
        btnQuiz3.setTextSize(btnTxtSize);
    }

    private void setButtonActions() {
        btnSem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Device_activ.this,Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page",11);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnAfm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Device_activ.this,Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page",12);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnQuiz3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Device_activ.this,Quiz3_q1_activ.class);
                startActivity(intent);
            }
        });
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

package nsf.nsf_nue_project;

import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build;
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

        setContentView(R.layout.activity_intro_activ);

        toggleHideyBar();

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int screenWidth = size.x;
        int screenHeight = size.y;

        setButtons(screenHeight, screenWidth);

        setButtonActions();

        Drawable d = getResources().getDrawable(R.drawable.layout_top_ch1);
        getSupportActionBar().setBackgroundDrawable(d);
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
        int btnMargin = (int) (screenHeight * 0.04);
        int btnHeight = (int) (screenHeight * 0.2);
        int btnWidth = (int) (screenWidth * 0.42);
        int btnTxtSize = (int) (screenHeight * 0.019);

        btnNano = (Button) findViewById(R.id.nanotech_btn);
        setMargins(btnNano, btnMargin, btnMargin, 0, 0);
        setWidthAndHeight(btnNano, btnWidth, btnHeight);
        btnNano.setTextSize(btnTxtSize);

        btnMarcoMicro = (Button) findViewById(R.id.macro_micro_btn);
        setMargins(btnMarcoMicro, 0, btnMargin, btnMargin, 0);
        setWidthAndHeight(btnMarcoMicro, btnWidth, btnHeight);
        btnMarcoMicro.setTextSize(btnTxtSize);

        btnNanoScale = (Button) findViewById(R.id.nanoscale_btn);
        setMargins(btnNanoScale, btnMargin, btnMargin, 0, 0);
        setWidthAndHeight(btnNanoScale, btnWidth, btnHeight);
        btnNanoScale.setTextSize(btnTxtSize);

        btnHistory = (Button) findViewById(R.id.history_btn);
        setMargins(btnHistory, 0, btnMargin, btnMargin, 0);
        setWidthAndHeight(btnHistory, btnWidth, btnHeight);
        btnHistory.setTextSize(btnTxtSize);

        quizBtn = (Button) findViewById(R.id.quiz1_btn);
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



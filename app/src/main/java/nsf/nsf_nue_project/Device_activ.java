package nsf.nsf_nue_project;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build;
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

import nsf.nsf_nue_project.quiz3.Quiz3_q1_activ;


public class Device_activ extends ActionBarActivity {
    private Button btnSem;
    private Button btnAfm;
    private Button btnQuiz3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_activ);

        toggleHideyBar();

        LinearLayout.LayoutParams lpView = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int screenWidth = size.x;
        int screenHeight = size.y;

        setButtons(screenHeight, screenWidth);

        setButtonActions();

        Drawable d = getResources().getDrawable(R.drawable.layout_top_ch3);
        getSupportActionBar().setBackgroundDrawable(d);
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

    private void setButtons(int screenHeight, int screenWidth) {
        int btnMargin = (int) (screenHeight * 0.075);
        int btnHeight = (int) (screenHeight * 0.2);
        int btnWidth = (int) (screenWidth * 0.42);
        int btnTxtSize = (int) (screenHeight * 0.019);

        btnSem = (Button)findViewById(R.id.sem_btn);
        setMargins(btnSem, btnMargin, btnMargin, 0, 0);
        setWidthAndHeight(btnSem, btnWidth, btnHeight);
        btnSem.setTextSize(btnTxtSize);

        btnAfm = (Button)findViewById(R.id.afm_btn);
        setMargins(btnAfm, 0, btnMargin, btnMargin, 0);
        setWidthAndHeight(btnAfm, btnWidth, btnHeight);
        btnAfm.setTextSize(btnTxtSize);

        btnQuiz3 = (Button)findViewById(R.id.quiz3_btn);
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
                bundle.putInt("page",13);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnAfm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Device_activ.this,Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page",14);
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

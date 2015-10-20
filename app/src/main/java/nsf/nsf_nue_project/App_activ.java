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


public class App_activ extends ActionBarActivity {

    private Button btnAsk;
    private Button btnEnrg;
    private Button btnSelCln;
    private Button btnDrugDel;
    private Button quizBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_activ);
        Configuration config = getResources().getConfiguration();

        if (config.smallestScreenWidthDp >= 600) {
            setContentView(R.layout.activity_app_activ);

            btnAsk = (Button)findViewById(R.id.ask_btn);
            btnEnrg = (Button)findViewById(R.id.enrg_gen_btn);
            btnSelCln = (Button)findViewById(R.id.self_cln_btn);
            btnDrugDel = (Button)findViewById(R.id.drug_del_btn);
            quizBtn = (Button)findViewById(R.id.quiz4_btn);

        } else {
            setContentView(R.layout.activity_app_activ_small);

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

        btnAsk = (Button)findViewById(R.id.ask_btn_phone);
        setMargins(btnAsk, btnMargin, btnMargin, 0, 0);
        setWidthAndHeight(btnAsk, btnWidth, btnHeight);
        btnAsk.setTextSize(btnTxtSize);

        btnEnrg = (Button)findViewById(R.id.enrg_gen_btn_phone);
        setMargins(btnEnrg, 0, btnMargin, btnMargin, 0);
        setWidthAndHeight(btnEnrg, btnWidth, btnHeight);
        btnEnrg.setTextSize(btnTxtSize);

        btnSelCln = (Button)findViewById(R.id.self_cln_btn_phone);
        setMargins(btnSelCln, btnMargin, btnMargin, 0, 0);
        setWidthAndHeight(btnSelCln, btnWidth, btnHeight);
        btnSelCln.setTextSize(btnTxtSize);

        btnDrugDel = (Button)findViewById(R.id.drug_del_btn_phone);
        setMargins(btnDrugDel, 0, btnMargin, btnMargin, 0);
        setWidthAndHeight(btnDrugDel, btnWidth, btnHeight);
        btnDrugDel.setTextSize(btnTxtSize);

        quizBtn = (Button)findViewById(R.id.quiz4_btn_phone);
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

    private void setButtonActions() {
        btnAsk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(App_activ.this,Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page",13);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnEnrg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(App_activ.this,Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page",14);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnSelCln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(App_activ.this,Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page",15);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnDrugDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(App_activ.this,Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page",16);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        quizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(App_activ.this,Quiz1_q1_activ.class);
                startActivity(intent);
            }
        });
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

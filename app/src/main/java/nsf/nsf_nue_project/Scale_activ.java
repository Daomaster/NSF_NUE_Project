package nsf.nsf_nue_project;

import android.content.Intent;
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
import android.widget.Button;

import nsf.nsf_nue_project.quiz2.Quiz2_q1_activ;


public class Scale_activ extends ActionBarActivity {
    private Button btnFund;
    private Button btnScalingGeo;
    private Button btnOptical;
    private Button btnChemical;
    private Button btnSizeM;
    private Button btnScalingRBD;
    private Button btnQuiz2;
    private Button btnAlka;
    private Button btnNanoC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_activ);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int screenWidth = size.x;
        int screenHeight = size.y;

        setButtons(screenHeight, screenWidth);
        setButtonActions();

        Drawable d = getResources().getDrawable(R.drawable.layout_top_ch2);
        getSupportActionBar().setBackgroundDrawable(d);
    }

    private void setButtonActions() {
        btnFund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Scale_activ.this, Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page", 5);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnScalingGeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Scale_activ.this, Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page", 6);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnOptical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Scale_activ.this, Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page", 7);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnChemical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Scale_activ.this, Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page", 8);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnSizeM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Scale_activ.this, Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page", 9);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnScalingRBD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Scale_activ.this, Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page", 10);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnAlka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Scale_activ.this, Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page", 11);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnNanoC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Scale_activ.this, Gallery_activ.class);
                Bundle bundle = new Bundle();
                bundle.putInt("page", 12);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnQuiz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Scale_activ.this, Quiz2_q1_activ.class);
                startActivity(intent);
            }
        });
    }

    private void setButtons(int screenHeight, int screenWidth) {
        int btnMargin = (int) (screenHeight * 0.031);
        int marginBtwnBtns = (int) (screenHeight * 0.01);
        int btnHeight = (int) (screenHeight * 0.15);
        int btnWidth = (int) (screenWidth * 0.42);
        int btnTxtSize = (int) (screenHeight * 0.019);


        btnFund = (Button) findViewById(R.id.fundamental_btn);
        setMargins(btnFund, btnMargin, 0, 0, marginBtwnBtns);
        setWidthAndHeight(btnFund, btnWidth, btnHeight);
        btnFund .setTextSize(btnTxtSize);

        btnScalingGeo = (Button) findViewById(R.id.scalin_geo_btn);
        setMargins(btnScalingGeo, 0, 0, btnMargin, marginBtwnBtns);
        setWidthAndHeight(btnScalingGeo, btnWidth, btnHeight);
        btnScalingGeo .setTextSize(btnTxtSize);

        btnOptical = (Button) findViewById(R.id.optcal_btn);
        setMargins(btnOptical, btnMargin, 0, 0, marginBtwnBtns);
        setWidthAndHeight(btnOptical, btnWidth, btnHeight);
        btnOptical.setTextSize(btnTxtSize);

        btnChemical = (Button) findViewById(R.id.chemical_btn);
        setMargins(btnChemical, 0, 0, btnMargin, marginBtwnBtns);
        setWidthAndHeight(btnChemical, btnWidth, btnHeight);
        btnChemical.setTextSize(btnTxtSize);

        btnSizeM = (Button) findViewById(R.id.size_matter_btn);
        setMargins(btnSizeM, btnMargin, 0, 0, marginBtwnBtns);
        setWidthAndHeight(btnSizeM, btnWidth, btnHeight);
        btnSizeM.setTextSize(btnTxtSize);

        btnScalingRBD = (Button) findViewById(R.id.scaling_rbd_btn);
        setMargins(btnScalingRBD, 0, 0, btnMargin, marginBtwnBtns);
        setWidthAndHeight(btnScalingRBD, btnWidth, btnHeight);
        btnScalingRBD.setTextSize(btnTxtSize);

        btnAlka = (Button) findViewById(R.id.alka_btn);
        setMargins(btnAlka, btnMargin, 0, 0, 0);
        setWidthAndHeight(btnAlka, btnWidth, btnHeight);
        btnAlka.setTextSize(btnTxtSize);

        btnNanoC = (Button) findViewById(R.id.nano_c_btn);
        setMargins(btnNanoC, 0, 0, btnMargin, 0);
        setWidthAndHeight(btnNanoC, btnWidth, btnHeight);
        btnNanoC.setTextSize(btnTxtSize);

        btnQuiz2 = (Button) findViewById(R.id.quiz2_btn);
        setMargins(btnQuiz2, 0, 0, 0, 0);
        setWidthAndHeight(btnQuiz2, btnWidth, btnHeight);
        btnQuiz2.setTextSize(btnTxtSize);

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

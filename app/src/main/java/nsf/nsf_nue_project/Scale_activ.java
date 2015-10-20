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

import nsf.nsf_nue_project.quiz2.Quiz2_q1_activ;


public class Scale_activ extends ActionBarActivity {
    Button btnFund;
    Button btnScalingGeo;
    Button btnOptical;
    Button btnChemical;
    Button btnSizeM;
    Button btnScalingRBD;
    Button btnQuiz2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration config = getResources().getConfiguration();

        if (config.smallestScreenWidthDp >= 600) {
            setContentView(R.layout.activity_scale_activ);

            btnFund = (Button) findViewById(R.id.fundamental_btn);
            btnScalingGeo = (Button) findViewById(R.id.scalin_geo_btn);
            btnOptical = (Button) findViewById(R.id.optcal_btn);
            btnChemical = (Button) findViewById(R.id.chemical_btn);
            btnSizeM = (Button) findViewById(R.id.size_matter_btn);
            btnScalingRBD = (Button) findViewById(R.id.scaling_rbd_btn);
            btnQuiz2= (Button) findViewById(R.id.quiz2_btn);

        } else {
            setContentView(R.layout.activity_scale_activ_small);

            LinearLayout.LayoutParams lpView = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            Display display = getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            int screenWidth = size.x;
            int screenHeight = size.y;

            setButtons(screenHeight, screenWidth);
        }


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
        btnQuiz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Scale_activ.this, Quiz2_q1_activ.class);
                startActivity(intent);
            }
        });


    }
    private void setButtons(int screenHeight, int screenWidth) {
        int btnMargin = (int) (screenHeight * 0.035);
        int btnHeight = (int) (screenHeight * 0.16);
        int btnWidth = (int) (screenWidth * 0.35);
        int btnTxtSize = (int) (screenHeight * 0.019);


        btnFund = (Button) findViewById(R.id.fundamental_btn_phone);
        setMargins(btnFund, btnMargin, btnMargin, 0, 0);
        setWidthAndHeight(btnFund , btnWidth, btnHeight);
        btnFund .setTextSize(btnTxtSize);

        btnScalingGeo = (Button) findViewById(R.id.scalin_geo_btn_phone);
        setMargins(btnScalingGeo, 0, btnMargin, btnMargin, 0);
        setWidthAndHeight(btnScalingGeo, btnWidth, btnHeight);
        btnScalingGeo .setTextSize(btnTxtSize);

        btnOptical = (Button) findViewById(R.id.optcal_btn_phone);
        setMargins(btnOptical, btnMargin, btnMargin, 0, 0);
        setWidthAndHeight(btnOptical, btnWidth, btnHeight);
        btnOptical.setTextSize(btnTxtSize);

        btnChemical = (Button) findViewById(R.id.chemical_btn_phone);
        setMargins(btnChemical, 0, btnMargin, btnMargin, 0);
        setWidthAndHeight(btnChemical, btnWidth, btnHeight);
        btnChemical.setTextSize(btnTxtSize);

        btnSizeM = (Button) findViewById(R.id.size_matter_btn_phone);
        setMargins(btnSizeM, btnMargin, btnMargin, 0, 0);
        setWidthAndHeight(btnSizeM, btnWidth, btnHeight);
        btnSizeM.setTextSize(btnTxtSize);

        btnScalingRBD = (Button) findViewById(R.id.scaling_rbd_btn_phone);
        setMargins(btnScalingRBD, 0, btnMargin, btnMargin, 0);
        setWidthAndHeight(btnScalingRBD, btnWidth, btnHeight);
        btnScalingRBD.setTextSize(btnTxtSize);

        btnQuiz2= (Button) findViewById(R.id.quiz2_btn_phone);
        setMargins(btnQuiz2, 0, 0, 0, btnMargin);
        setWidthAndHeight(btnQuiz2, btnWidth, btnHeight);
        btnQuiz2.setTextSize(btnTxtSize);

    }

    public static void setMargins (View view, int left, int top, int right, int bottom) {
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

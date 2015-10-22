package nsf.nsf_nue_project;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends ActionBarActivity {
    private Button appBtn;
    private Button deviceBtn;
    private Button scallingBtn;
    private Button introBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration config = getResources().getConfiguration();

//        if (config.smallestScreenWidthDp >= 600) {
//            setContentView(R.layout.activity_main);
//
//            appBtn = (Button) findViewById(R.id.application_btn);
//            deviceBtn = (Button) findViewById(R.id.device_btn);
//            scallingBtn = (Button) findViewById(R.id.scalin_law_btn);
//            introBtn = (Button) findViewById(R.id.intro_btn);
//
//        } else {
            setContentView(R.layout.activity_main_small);

            LinearLayout.LayoutParams lpView = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            Display display = getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            int screenWidth = size.x;
            int screenHeight = size.y;

            setFrontImage(screenWidth, screenHeight);
            setButtons(screenHeight);
//        }

        setButtonAction(introBtn, Intro_activ.class);
        setButtonAction(scallingBtn, Scale_activ.class);
        setButtonAction(deviceBtn, Device_activ.class);
        setButtonAction(appBtn, App_activ.class);
    }

    private void setButtonAction(Button btn, final Class<?> target) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, target);
                startActivity(intent);
            }
        });
    }

    private void setButtons(int screenHeight) {
        int btnMargin = (int) (screenHeight * 0.04);
        int btnHeight = (int) (screenHeight * 0.15);
        int btnWidth = (int) (screenHeight * 0.53);

        appBtn = (Button) findViewById(R.id.application_btn_phone);
        setMargins(appBtn, 0, btnMargin, btnMargin, btnMargin);
        setWidthAndHeight(appBtn, btnWidth, btnHeight);

        deviceBtn = (Button) findViewById(R.id.device_btn_phone);
        setMargins(deviceBtn, 0, btnMargin, 0, 0);
        setWidthAndHeight(deviceBtn, btnWidth, btnHeight);

        scallingBtn = (Button) findViewById(R.id.scallin_law_btn_phone);
        setMargins(scallingBtn, 0, btnMargin, 0, 0);
        setWidthAndHeight(scallingBtn, btnWidth, btnHeight);

        introBtn = (Button) findViewById(R.id.intro_btn_phone);
        setWidthAndHeight(introBtn, btnWidth, btnHeight);
        setMargins(introBtn, 0, btnMargin, 0, 0);
    }

    private void setFrontImage(int screenWidth, int screenHeight) {
        int fronImageWidth = (int) (screenWidth * 0.7);
        int fronImageHeight = (int) (screenHeight * 0.7);
        int frontImageMarginL = (int) (screenHeight * 0.05);
        int frontImageMarginB = (int) (screenHeight * 0.05);

        ImageView frontImage = (ImageView) findViewById(R.id.frontImage);
        frontImage.setMaxHeight(fronImageHeight);
        frontImage.setMaxWidth(fronImageWidth);
        setMargins(frontImage, frontImageMarginL, 0, 0, frontImageMarginB);
    }

    private void setWidthAndHeight(View view, int width, int height) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.width = width;
        params.height = height;
        view.setLayoutParams(params);
        view.requestLayout();
    }

    public static void setMargins (View view, int left, int top, int right, int bottom) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            p.setMargins(left, top, right, bottom);
            view.requestLayout();
        }
    }

}

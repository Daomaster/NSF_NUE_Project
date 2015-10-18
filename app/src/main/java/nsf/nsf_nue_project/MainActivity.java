package nsf.nsf_nue_project;

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
import android.widget.RelativeLayout;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration config = getResources().getConfiguration();

        if (config.smallestScreenWidthDp >= 600) {
            setContentView(R.layout.activity_main);
        } else {
            setContentView(R.layout.activity_main_small);

            LinearLayout.LayoutParams lpView = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            Display display = getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            int screenWidth = size.x;
            int screenHeight = size.y;

            //FrontImage
            int fronImageWidth = (int) (screenWidth * 0.7);
            int fronImageHeight = (int) (screenHeight * 0.7);
            int frontImageMarginL = (int) (screenHeight * 0.05);
            int frontImageMarginB = (int) (screenHeight * 0.05);

            ImageView frontImage = (ImageView) findViewById(R.id.frontImage);
            frontImage.setMaxHeight(fronImageHeight);
            frontImage.setMaxWidth(fronImageWidth);
            setMargins(frontImage, frontImageMarginL, 0, 0, frontImageMarginB);

            //Buttons
            int btnMargin = (int) (screenHeight * 0.04);
            int btnHeight = (int) (screenHeight * 0.15);
            int btnWidth = (int) (screenHeight * 0.53);

            Button appBtn = (Button) findViewById(R.id.application_btn_phone);
            setMargins(appBtn, 0, btnMargin, btnMargin, btnMargin);
            setWidthAndHeight(appBtn, btnWidth, btnHeight);

            Button deviceBtn = (Button) findViewById(R.id.device_btn_phone);
            setMargins(deviceBtn, 0, btnMargin, 0, 0);
            setWidthAndHeight(appBtn, btnWidth, btnHeight);

            Button scallingBtn = (Button) findViewById(R.id.scallin_law_btn_phone);
            setMargins(scallingBtn, 0, btnMargin, 0, 0);
            setWidthAndHeight(appBtn, btnWidth, btnHeight);

            Button introBtn = (Button) findViewById(R.id.intro_btn_phone);
            setWidthAndHeight(appBtn, btnWidth, btnHeight);
            setMargins(introBtn, 0, btnMargin, 0, 0);
        }

//        intro_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,Intro_activ.class);
//                startActivity(intent);
//            }
//        });
//        scale_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,Scale_activ.class);
//                startActivity(intent);
//            }
//        });
//        device_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,Device_activ.class);
//                startActivity(intent);
//            }
//        });
//        application_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,App_activ.class);
//                startActivity(intent);
//            }
//        });
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

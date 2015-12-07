package nsf.nsf_nue_project;

import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity {
    private Button appBtn;
    private Button deviceBtn;
    private Button scallingBtn;
    private Button introBtn;
    private ImageView nsfLink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleHideyBar();

        nsfLink = (ImageView) findViewById(R.id.nsfLink);
        setLinkOnImageView(nsfLink, "http://www.nsf.gov/");

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int screenWidth = size.x;
        int screenHeight = size.y;

        setFrontImage(screenWidth, screenHeight);
        setButtons(screenHeight);

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
        int btnMargin = (int) (screenHeight * 0.01);
        int btnHeight = (int) (screenHeight * 0.19);
        int btnWidth = (int) (screenHeight * 0.43);

        appBtn = (Button) findViewById(R.id.application_btn);
        setMargins(appBtn, 0, 0, btnMargin*2, btnMargin);
        setWidthAndHeight(appBtn, btnWidth, btnHeight);

        deviceBtn = (Button) findViewById(R.id.device_btn);
        setMargins(deviceBtn, 0, 0, btnMargin*3, 0);
        setWidthAndHeight(deviceBtn, btnWidth, btnHeight);

        scallingBtn = (Button) findViewById(R.id.scallin_law_btn);
        setMargins(scallingBtn, 0, 0, btnMargin*4, 0);
        setWidthAndHeight(scallingBtn, btnWidth, btnHeight);

        introBtn = (Button) findViewById(R.id.intro_btn);
        setWidthAndHeight(introBtn, btnWidth, btnHeight);
        setMargins(introBtn, 0, 0, btnMargin*5, 0);
    }

    private void setFrontImage(int screenWidth, int screenHeight) {
        int fronImageWidth = (int) (screenWidth * 0.8);
        int fronImageHeight = (int) (screenHeight * 0.7);
        int frontImageMarginL = (int) (screenHeight * 0.12);
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
    private void setLinkOnImageView(ImageView img, final String link) {

        img.setVisibility(ImageView.VISIBLE);
        img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(link));
                startActivity(intent);
            }
        });
    }


}

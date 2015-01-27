package nsf.nsf_nue_project;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;


public class Gallery_activ extends ActionBarActivity {

    int start;
    private int[] imageId = new int[] {R.drawable.page01, R.drawable.page02,R.drawable.page03,R.drawable.page04,
            R.drawable.page05,R.drawable.page06,R.drawable.page07,R.drawable.page08,R.drawable.page09,R.drawable.page010,R.drawable.page011,R.drawable.page012,R.drawable.page013,R.drawable.page014,
            R.drawable.page015,R.drawable.page016};
    private int index = 0;
    private ImageSwitcher imageSwitcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sec_activ);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        start = bundle.getInt("page");
        index = start - 1;
        ImageButton imageButton1 = (ImageButton) findViewById(R.id.imageButton);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Setting up Image Switcher
        imageSwitcher = (ImageSwitcher)findViewById(R.id.imageSwitcher);
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(Gallery_activ.this);
                imageView.setScaleType(ImageView.ScaleType.FIT_END);
                return imageView;
            }
        });
        imageSwitcher.setImageResource(imageId[index]);

        //Setting up the Buttons
        Button up = (Button)findViewById(R.id.button11);
        Button down = (Button)findViewById(R.id.button12);
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index > 0){
                    index--;
                    start--;
                }else{
                    index = imageId.length - 1;
                }
                imageSwitcher.setImageResource(imageId[index]);
            }
        });

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index < imageId.length - 1){
                    index++;
                    start++;
                }else{
                    index = 0;
                }
                imageSwitcher.setImageResource(imageId[index]);
            }
        });
    }
}

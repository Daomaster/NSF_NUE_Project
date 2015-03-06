package nsf.nsf_nue_project;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;
import android.view.MotionEvent;


public class Gallery_activ extends ActionBarActivity {

    int start;
    private int chapter =1;
    private int[] imageId = new int[] {R.drawable.page01, R.drawable.page02,R.drawable.page03,R.drawable.page04,
            R.drawable.page05,R.drawable.page06,R.drawable.page07,R.drawable.page08,R.drawable.page09,R.drawable.page010,R.drawable.page011,R.drawable.page012,R.drawable.page013,R.drawable.page014,
            R.drawable.page015,R.drawable.page016};
    private int index = 0;
    private ImageSwitcher imageSwitcher;
    float initialX;

    int CheckChap(int index){
        if (0 < index && index <= 3)return 1;
        if (4 < index && index <= 9)return 2;
        if (9 < index && index <= 11)return 3;
        if (11 < index && index <= 15)return 4;
        else return 5;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
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
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                return imageView;
            }
        });
        imageSwitcher.setImageResource(imageId[index]);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //Build Analog
        final AlertDialog.Builder Chapterbuilder = new AlertDialog.Builder(this);
        chapter = CheckChap(index);
                Chapterbuilder.setMessage("You finished Chapter" + chapter + "!" + "\n\nWould like to go to Quiz" + chapter + "？");
                            Chapterbuilder.setTitle("Congratulations")
                            .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                .setNegativeButton("Quiz", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(Gallery_activ.this, Quiz_activ.class);
                        startActivity(intent);

                    }
                });
        final AlertDialog.Builder Endbuilder = new AlertDialog.Builder(this);
        Endbuilder.setMessage("You finished the program")
                .setTitle("Congratulations")
                .setPositiveButton("Home", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent1 = new Intent(Gallery_activ.this, MainActivity.class);
                        startActivity(intent1);
                    }
                })
                .setNegativeButton("Menu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent1 = new Intent(Gallery_activ.this, App_activ.class);
                        startActivity(intent1);
                    }
                });
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                initialX = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                float finalX = event.getX();
                if (initialX > finalX)
                {
                    if(index == 3 || index == 9 || index== 11)
                    {
                        chapter = CheckChap(index);
                        final AlertDialog dialog = Chapterbuilder.create();
                        dialog.show();
                    }
                    if (index == 15)
                    {
                        final AlertDialog dialog = Endbuilder.create();
                        dialog.show();
                    }
                    else
                    {
                    index++;
                    imageSwitcher.setImageResource(imageId[index]);
                    }
                }
                else
                {
                    if(index > 0)
                    {
                        index--;
                        imageSwitcher.setImageResource(imageId[index]);
                    }

                }
                break;
        }
        return false;
    }



}

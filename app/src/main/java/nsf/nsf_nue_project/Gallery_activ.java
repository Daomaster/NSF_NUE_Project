package nsf.nsf_nue_project;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.media.session.MediaController;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;
import android.widget.ViewSwitcher;
import android.view.MotionEvent;

import nsf.nsf_nue_project.quiz1.Quiz1_q1_activ;
import nsf.nsf_nue_project.quiz2.Quiz2_q1_activ;
import nsf.nsf_nue_project.quiz3.Quiz3_q1_activ;


public class Gallery_activ extends ActionBarActivity {

    int start;
    private int chapter = 1;
    private int[] imageId = new int[]{R.drawable.page01, R.drawable.page02, R.drawable.page03, R.drawable.page04,
            R.drawable.page05, R.drawable.page06, R.drawable.page07, R.drawable.page08, R.drawable.page09, R.drawable.page010, R.drawable.page011, R.drawable.page012, R.drawable.page013, R.drawable.page014,
            R.drawable.page015, R.drawable.page016};
    private int index = 0;
    private String[] titles = {"1.1 What is Nanotechnology?", "1.2 Macrosize & Microsize", "1.3 Why Nanoscale?", "1.4 History",
            "2.1 Fundamental", "2.2 Scaling in Geometry", "2.3 Optical Properties Example", "2.4 Chemical Bonding Example",
            "2.5 Size Matter Example", "2.6 Scaling in Rigid-Body Dynamics", "3.1 SEM ", "3.2 AFM ", "4.1 Ask Nature ", "4.2 Energy Storage and Storage",
            "4.3 Self-cleaning Fabric", "4.4 Drug Delivery"};
    private ImageSwitcher imageSwitcher;
    float initialX;
    VideoView videoView;

    int CheckChap(int index) {
        if (0 < index && index <= 3) return 1;
        if (4 < index && index <= 9) return 2;
        if (9 < index && index <= 11) return 3;
        if (11 < index && index <= 15) return 4;
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

        // Setting up Image Switcher
        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
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

        setTitle(titles[index]);
        setVideo(index);

        ImageView link_egypt = (ImageView)findViewById(R.id.link_egypt);
        link_egypt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://en.wikipedia.org/wiki/History_of_glass"));
                startActivity(intent);
            }
        });

        ImageView firstTem = (ImageView)findViewById(R.id.link_first_tem);
        firstTem.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://en.wikipedia.org/wiki/Transmission_electron_microscopy#Initial_development"));
                startActivity(intent);
            }
        });

        ImageView linkRichard = (ImageView)findViewById(R.id.link_richard);
        linkRichard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://en.wikipedia.org/wiki/Richard_Feynman"));
                startActivity(intent);
            }
        });

        ImageView linkEric = (ImageView)findViewById(R.id.link_eric);
        linkEric.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://metamodern.com/about-the-author/"));
                startActivity(intent);
            }
        });

        ImageView linkBuckyball = (ImageView)findViewById(R.id.link_buckyball);
        linkBuckyball.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://en.wikipedia.org/wiki/Fullerene"));
                startActivity(intent);
            }
        });

        ImageView linkGraphene = (ImageView)findViewById(R.id.link_graphene);
        linkGraphene.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://en.wikipedia.org/wiki/Graphene"));
                startActivity(intent);
            }
        });

        ImageView linkSolarCell = (ImageView)findViewById(R.id.link_solar_cell);
        linkSolarCell.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://science.howstuffworks.com/environmental/energy/solar-cell.htm"));
                startActivity(intent);
            }
        });

        ImageView linkHairDye = (ImageView)findViewById(R.id.link_hair_dye);
        linkHairDye.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://ancientstandard.com/2007/09/16/the-ancient-greeks-romans-used-nanotechnology-%E2%80%A6to-dye-their-hair-ca-500-bc-%E2%80%93-100-ad/"));
                startActivity(intent);
            }
        });

        ImageView linkFirstSem = (ImageView)findViewById(R.id.link_first_sem);
        linkFirstSem.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://en.wikipedia.org/wiki/Scanning_electron_microscope#History"));
                startActivity(intent);
            }
        });

        ImageView linkTermNano = (ImageView)findViewById(R.id.link_term_nano);
        linkTermNano.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://dictionary.reference.com/browse/nanotechnology"));
                startActivity(intent);
            }
        });

        ImageView linkFirstStm = (ImageView)findViewById(R.id.link_first_stm);
        linkFirstStm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://en.wikipedia.org/wiki/File:First_STM.jpg"));
                startActivity(intent);
            }
        });

        ImageView linkFirstAfm = (ImageView)findViewById(R.id.link_first_afm);
        linkFirstAfm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://hansmalab.physics.ucsb.edu/afmback.html"));
                startActivity(intent);
            }
        });

        ImageView linkWearEletro = (ImageView)findViewById(R.id.link_wear_eletro);
        linkWearEletro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://en.wikipedia.org/wiki/Wearable_technology"));
                startActivity(intent);
            }
        });

        ImageView linkCnt = (ImageView)findViewById(R.id.link_cnt);
        linkCnt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://en.wikipedia.org/wiki/Carbon_nanotube"));
                startActivity(intent);
            }
        });

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

                        if (chapter == 1) {
                            Intent intent = new Intent(Gallery_activ.this, Quiz1_q1_activ.class);
                            startActivity(intent);
                        } else if (chapter == 2) {
                            Intent intent = new Intent(Gallery_activ.this, Quiz2_q1_activ.class);
                            startActivity(intent);
                        } else if (chapter == 3) {
                            Intent intent = new Intent(Gallery_activ.this, Quiz3_q1_activ.class);
                            startActivity(intent);
                        } else {
                            Intent intent = new Intent(Gallery_activ.this, Quiz3_q1_activ.class);
                            startActivity(intent);
                        }

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
                if (initialX > finalX) {
                    if (index == 3 || index == 9 || index == 11) {
                        chapter = CheckChap(index);
                        final AlertDialog dialog = Chapterbuilder.create();
                        dialog.show();
                    }
                    if (index == 15) {
                        final AlertDialog dialog = Endbuilder.create();
                        dialog.show();
                    } else {
                        index++;
                        imageSwitcher.setImageResource(imageId[index]);
                        setTitle(titles[index]);
                    }
                } else if (index > 0) {
                    index--;
                    imageSwitcher.setImageResource(imageId[index]);
                    setTitle(titles[index]);
                }

                setVideo(index);
                break;
        }
        return false;
    }

    private void setVideo(int page) {
        videoView = (VideoView) findViewById(R.id.videoView);

        if(page == 0) {
            videoView.setVisibility(VideoView.VISIBLE);
            Uri video = Uri.parse("android.resource://" + getPackageName() + "/"
                    + R.raw.video);
            videoView.setVideoURI(video);
            videoView.start();
        } else {
            videoView.setVisibility(VideoView.GONE);
        }
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
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

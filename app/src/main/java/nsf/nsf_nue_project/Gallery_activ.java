package nsf.nsf_nue_project;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.VideoView;
import android.widget.ViewSwitcher;
import android.view.MotionEvent;

import java.lang.ref.WeakReference;

import nsf.nsf_nue_project.quiz1.Quiz1_q1_activ;
import nsf.nsf_nue_project.quiz2.Quiz2_q1_activ;
import nsf.nsf_nue_project.quiz3.Quiz3_q1_activ;


public class Gallery_activ extends ActionBarActivity {

    private int start;
    private int chapter = 1;
    private int[] imageId = new int[]{R.drawable.page01, R.drawable.videobackground,
            R.drawable.videobackground, R.drawable.page04, R.drawable.page05, R.drawable.page06,
            R.drawable.page07, R.drawable.page08, R.drawable.videobackground, R.drawable.page010,
            R.drawable.videobackground, R.drawable.videobackground, R.drawable.page013, R.drawable.page014, R.drawable.page015,
            R.drawable.page016, R.drawable.page017, R.drawable.page018};
    private int index = 0;
    private String[] titles = {"1.1 What is Nanotechnology?", "1.2 Macrosize & Microsize",
            "1.3 Why Nanoscale?", "1.4 History", "2.1 Fundamental", "2.2 Scaling in Geometry",
            "2.3 Optical Properties Example", "2.4 Chemical Bonding Example",
            "2.5 Size Matter Example", "2.6 Scaling in Rigid-Body Dynamics",
            "2.7  The Alka Seltzer Experiments", "2.8  Nano-Crystals","3.1 SEM ", "3.2 AFM ",
            "4.1 Ask Nature ", "4.2 Energy Storage and Storage", "4.3 Self-cleaning Fabric",
            "4.4 Drug Delivery"};
    private static final int SWIPE_MIN_DISTANCE = 120;
    private float initialX;
    private ImageView galleryImage;
    private ImageView link_egypt;
    private ImageView firstTem;
    private ImageView linkRichard;
    private ImageView linkEric;
    private ImageView linkBuckyball;
    private ImageView linkGraphene;
    private ImageView linkSolarCell;
    private ImageView linkHairDye;
    private ImageView linkFirstSem;
    private ImageView linkTermNano;
    private ImageView linkFirstStm;
    private ImageView linkFirstAfm;
    private ImageView linkWearEletro;
    private ImageView linkCnt;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        start = bundle.getInt("page");
        index = start - 1;

        galleryImage = (ImageView) findViewById(R.id.galleryImage);
        galleryImage.setImageBitmap(
                decodeSampledBitmapFromResource(getResources(), imageId[index], 480, 360));

        setTitle(titles[index]);
        setVideo(titles[index]);
        setLinks(titles[index]);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        final AlertDialog.Builder Chapterbuilder = buildAlertDialog();

        chapter = CheckChap(index);

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
                if (initialX > finalX && (initialX-finalX) > SWIPE_MIN_DISTANCE) { //swiping right to left
                    if (index == 3 || index == 11 || index == 13) {
                        chapter = CheckChap(index);
                        final AlertDialog dialog = Chapterbuilder.create();
                        dialog.show();
                    }
                    if (index == 17) {
                        final AlertDialog dialog = Endbuilder.create();
                        dialog.show();
                    } else {
                        index++;
                        galleryImage.setImageBitmap(
                                decodeSampledBitmapFromResource(getResources(), imageId[index], 480, 360));
                        setTitle(titles[index]);
                        setLinks(titles[index]);
                    }
                } else if (initialX < finalX && (finalX-initialX) > SWIPE_MIN_DISTANCE && index > 0) { //swiping left to right
                    index--;
                    galleryImage.setImageBitmap(
                            decodeSampledBitmapFromResource(getResources(), imageId[index], 480, 360));
                    setTitle(titles[index]);
                    setLinks(titles[index]);
                }

                setVideo(titles[index]);
                break;
        }
        return false;
    }

    int CheckChap(int index) {
        if (0 < index && index <= 3) return 1;
        if (4 < index && index <= 11) return 2;
        if (12 < index && index <= 13) return 3;
        if (14 < index && index <= 17) return 4;
        else return 5;
    }

    private void setLinks(String chapter) {
        link_egypt = (ImageView) findViewById(R.id.link_egypt);
        firstTem = (ImageView) findViewById(R.id.link_first_tem);
        linkRichard = (ImageView) findViewById(R.id.link_richard);
        linkEric = (ImageView) findViewById(R.id.link_eric);
        linkBuckyball = (ImageView) findViewById(R.id.link_buckyball);
        linkGraphene = (ImageView) findViewById(R.id.link_graphene);
        linkSolarCell = (ImageView) findViewById(R.id.link_solar_cell);
        linkHairDye = (ImageView) findViewById(R.id.link_hair_dye);
        linkFirstSem = (ImageView) findViewById(R.id.link_first_sem);
        linkTermNano = (ImageView) findViewById(R.id.link_term_nano);
        linkFirstStm = (ImageView) findViewById(R.id.link_first_stm);
        linkFirstAfm = (ImageView) findViewById(R.id.link_first_afm);
        linkWearEletro = (ImageView) findViewById(R.id.link_wear_eletro);
        linkCnt = (ImageView) findViewById(R.id.link_cnt);

        if(chapter.equalsIgnoreCase("1.4 History")) {

            setLinkOnImageView(link_egypt, "https://en.wikipedia.org/wiki/History_of_glass");
            setLinkOnImageView(firstTem,"https://en.wikipedia.org/wiki/Transmission_electron_microscopy#Initial_development");
            setLinkOnImageView(linkRichard,"https://en.wikipedia.org/wiki/Richard_Feynman");
            setLinkOnImageView(linkEric,"http://metamodern.com/about-the-author/");
            setLinkOnImageView(linkBuckyball,"https://en.wikipedia.org/wiki/Fullerene");
            setLinkOnImageView(linkGraphene,"https://en.wikipedia.org/wiki/Graphene");
            setLinkOnImageView(linkSolarCell,"http://science.howstuffworks.com/environmental/energy/solar-cell.htm");
            setLinkOnImageView(linkHairDye,"http://ancientstandard.com/2007/09/16/the-ancient-greeks-romans-used-nanotechnology-%E2%80%A6to-dye-their-hair-ca-500-bc-%E2%80%93-100-ad/");
            setLinkOnImageView(linkFirstSem,"https://en.wikipedia.org/wiki/Scanning_electron_microscope#History");
            setLinkOnImageView(linkTermNano,"http://dictionary.reference.com/browse/nanotechnology");
            setLinkOnImageView(linkFirstStm,"https://en.wikipedia.org/wiki/File:First_STM.jpg");
            setLinkOnImageView(linkFirstAfm,"http://hansmalab.physics.ucsb.edu/afmback.html");
            setLinkOnImageView(linkWearEletro,"https://en.wikipedia.org/wiki/Wearable_technology");
            setLinkOnImageView(linkCnt,"https://en.wikipedia.org/wiki/Carbon_nanotube");

        } else {
            link_egypt.setVisibility(ImageView.GONE);
            firstTem.setVisibility(ImageView.GONE);
            linkRichard.setVisibility(ImageView.GONE);
            linkEric.setVisibility(ImageView.GONE);
            linkBuckyball.setVisibility(ImageView.GONE);
            linkGraphene.setVisibility(ImageView.GONE);
            linkSolarCell.setVisibility(ImageView.GONE);
            linkHairDye.setVisibility(ImageView.GONE);
            linkFirstSem.setVisibility(ImageView.GONE);
            linkTermNano.setVisibility(ImageView.GONE);
            linkFirstStm.setVisibility(ImageView.GONE);
            linkFirstAfm.setVisibility(ImageView.GONE);
            linkWearEletro.setVisibility(ImageView.GONE);
            linkCnt.setVisibility(ImageView.GONE);
        }
    }
    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
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

    private void setVideo(String chapter) {
        videoView = (VideoView) findViewById(R.id.videoView);

        if(chapter.equalsIgnoreCase("1.2 Macrosize & Microsize")) {

            videoView.setVisibility(VideoView.VISIBLE);
            Uri video = Uri.parse("android.resource://" + getPackageName() + "/"
                    + R.raw.page02_video_640x360);
            videoView.setVideoURI(video);
            videoView.start();

        } else if(chapter.equalsIgnoreCase("1.3 Why Nanoscale?")) {

            videoView.setVisibility(VideoView.VISIBLE);
            Uri video = Uri.parse("android.resource://" + getPackageName() + "/"
                    + R.raw.page08_640x360);
            videoView.setVideoURI(video);
            videoView.start();

        } else if(chapter.equalsIgnoreCase("2.5 Size Matter Example")) {

            videoView.setVisibility(VideoView.VISIBLE);
            Uri video = Uri.parse("android.resource://" + getPackageName() + "/"
                    + R.raw.page09_video_640x360);
            videoView.setVideoURI(video);
            videoView.start();

        } else if(chapter.equalsIgnoreCase("2.7  The Alka Seltzer Experiments")) {

            videoView.setVisibility(VideoView.VISIBLE);
            Uri video = Uri.parse("android.resource://" + getPackageName() + "/"
                    + R.raw.page11_video_640x360);
            videoView.setVideoURI(video);
            videoView.start();

        } else if(chapter.equalsIgnoreCase("2.8  Nano-Crystals")) {

            videoView.setVisibility(VideoView.VISIBLE);
            Uri video = Uri.parse("android.resource://" + getPackageName() + "/"
                    + R.raw.page12_video_640x360);
            videoView.setVideoURI(video);
            videoView.start();

        } else {
            videoView.setVisibility(VideoView.GONE);
        }
    }

    @NonNull
    private AlertDialog.Builder buildAlertDialog() {
        final AlertDialog.Builder Chapterbuilder = new AlertDialog.Builder(this);
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
        return Chapterbuilder;
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

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_act_bar, menu);

        return super.onCreateOptionsMenu(menu);
    }

    class BitmapWorkerTask extends AsyncTask<Integer, Void, Bitmap> {
        private final WeakReference<ImageView> imageViewReference;
        private int data = 0;

        public BitmapWorkerTask(ImageView imageView) {
            // Use a WeakReference to ensure the ImageView can be garbage collected
            imageViewReference = new WeakReference<ImageView>(imageView);
        }

        // Decode image in background.
        @Override
        protected Bitmap doInBackground(Integer... params) {
            data = params[0];
            return decodeSampledBitmapFromResource(getResources(), data, 100, 100);
        }

        // Once complete, see if ImageView is still around and set bitmap.
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (imageViewReference != null && bitmap != null) {
                final ImageView imageView = imageViewReference.get();
                if (imageView != null) {
                    imageView.setImageBitmap(bitmap);
                }
            }
        }
    }
}

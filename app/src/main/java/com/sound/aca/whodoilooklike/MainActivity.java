package com.sound.aca.whodoilooklike;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Circle;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.common.FirebaseVisionPoint;
import com.google.firebase.ml.vision.face.FirebaseVisionFace;
import com.google.firebase.ml.vision.face.FirebaseVisionFaceContour;
import com.google.firebase.ml.vision.face.FirebaseVisionFaceDetector;
import com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions;
import com.google.firebase.ml.vision.face.FirebaseVisionFaceLandmark;
import com.sound.aca.whodoilooklike.DataBase.CelebrityRepository;
import com.sound.aca.whodoilooklike.Models.Celebrity;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Predicate;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final int PICK_IMAGE = 1;
    ImageView imageView, CelebImageView;
    private static final String TAG = "mojTag";
    Bitmap bitmap, resizedBitmap;
    Paint paint, paintBlue, paintGreen;
    Uri selectedImage;
    LottieAnimationView progressBar;
    CelebrityRepository databaseRepository;
    String gender;
    double noseRatio, ratio36, ratio46;
    TextView celebNameView,noseRatioTxt,eyeEarTxt,mouthChinTxt,analyzingTxt,didntFindFaceTxt;
    LinearLayout chalkText;
    ImageView pin1,pin2;
    String name;

    private InterstitialAd mInterstitialAd;

    ImageView backBtn;
    LottieAnimationView shareBtn;
    ImageView littleDudeLookLike;
    final List<String> titleList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.image);
        CelebImageView = findViewById(R.id.Celeb);
        celebNameView = findViewById(R.id.celebNameView);
        noseRatioTxt = findViewById(R.id.noseRatioTxt);
        eyeEarTxt = findViewById(R.id.eyeEarTxt);
        mouthChinTxt = findViewById(R.id.mouthChinTxt);
        chalkText = findViewById(R.id.chalkText);
        analyzingTxt = findViewById(R.id.analyzingTxt);
        didntFindFaceTxt = findViewById(R.id.didntFindFaceTxt);

        pin1 = findViewById(R.id.pin1);
        pin2 = findViewById(R.id.pin2);

        backBtn = findViewById(R.id.backBtn);
        shareBtn = findViewById(R.id.shareBtn);

        littleDudeLookLike = findViewById(R.id.littleDudeLookLike);

        databaseRepository = new CelebrityRepository(this);

        MobileAds.initialize(this);


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.int_id));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });


        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ShareActivity.class);
                intent.putExtra("celebrityName",name);

                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                resizedBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();


                intent.putExtra("personImage",byteArray);
                startActivity(intent);

            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintBlue = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintGreen = new Paint(Paint.ANTI_ALIAS_FLAG);

        paint.setColor(Color.RED);
        paintBlue.setColor(Color.BLUE);
        paintGreen.setColor(Color.GREEN);

        FirebaseApp.initializeApp(getApplicationContext());

        progressBar =  findViewById(R.id.spin_kit);
        Sprite doubleBounce = new Circle();



        titleList.add("Analyzing...");
        titleList.add("Analyzing Nose");
        titleList.add("Analyzing Eyes");
        titleList.add("Analyzing Mouth");
        titleList.add("Finding your match");

        if (getIntent().getParcelableExtra("selectedImage") != null) {
            Observable.fromCallable(new Callable<Bitmap>() {
                @Override
                public Bitmap call() {
                    progressBar.setVisibility(View.VISIBLE);
                    analyzingTxt.setVisibility(View.VISIBLE);

                    //CHANGE TEXT ON BACGROUND THREAD
                    Observable<Long> intervalObservable = Observable
                            .interval(3, TimeUnit.SECONDS)
                            .subscribeOn(Schedulers.io())
                            .takeWhile(new Predicate<Long>() { // stop the process if more than 5 seconds passes
                                @Override
                                public boolean test(Long aLong) throws Exception {

                                    return aLong <= 4;
                                }
                            })
                            .observeOn(AndroidSchedulers.mainThread());

                    intervalObservable.subscribe(new Observer<Long>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                        }
                        @Override
                        public void onNext(Long aLong) {
                            Log.d(TAG, "onNext: interval: " + titleList.get(aLong.intValue()));
                            analyzingTxt.setText( titleList.get(aLong.intValue()));
                        }
                        @Override
                        public void onError(Throwable e) {

                        }
                        @Override
                        public void onComplete() {

                        }
                    });


                    Bitmap bitmapSmall = getIntent().getParcelableExtra("selectedImage");
                         bitmap=Bitmap.createScaledBitmap(bitmapSmall, bitmapSmall.getWidth()*3, bitmapSmall.getHeight()*3, true);
                    gender = getIntent().getExtras().getString("gender");
//                    ByteArrayOutputStream out = new ByteArrayOutputStream();
//                    bitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
//                    Bitmap decoded = BitmapFactory.decodeStream(new ByteArrayInputStream(out.toByteArray()));
//                    Bitmap resizedBitmap2 = Bitmap.createScaledBitmap(
//                            decoded, decoded.getWidth() , decoded.getHeight() , false);
                    return bitmap;
                }
            })
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<Bitmap>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(Bitmap bitmap) {
                            resizedBitmap = bitmap;
                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onComplete() {
                            renderImage();

                        }
                    });
        }


        selectedImage = getIntent().getParcelableExtra("selectedImage2");
        if (selectedImage != null) {
            gender = getIntent().getExtras().getString("gender");
//            InputStream inputStream = null;
//            try {
//                inputStream = getContentResolver().openInputStream(selectedImage);
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
//            resizedBitmap = bitmap;
//            renderImage();


            Observable.fromCallable(new Callable<Bitmap>() {
                @Override
                public Bitmap call() {

                    //CHANGE TEXT ON BACGROUND THREAD
                    Observable<Long> intervalObservable = Observable
                            .interval(3, TimeUnit.SECONDS)
                            .subscribeOn(Schedulers.io())
                            .takeWhile(new Predicate<Long>() { // stop the process if more than 5 seconds passes
                                @Override
                                public boolean test(Long aLong) throws Exception {

                                    return aLong <= 4;
                                }
                            })
                            .observeOn(AndroidSchedulers.mainThread());

                    intervalObservable.subscribe(new Observer<Long>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                        }
                        @Override
                        public void onNext(Long aLong) {
                            Log.d(TAG, "onNext: interval: " + titleList.get(aLong.intValue()));
                            analyzingTxt.setText( titleList.get(aLong.intValue()));
                        }
                        @Override
                        public void onError(Throwable e) {

                        }
                        @Override
                        public void onComplete() {

                        }
                    });

                    Bitmap bitmap2 = null;
                    try {
                        progressBar.setVisibility(View.VISIBLE);
                        analyzingTxt.setVisibility(View.VISIBLE);
                        InputStream inputStream = getContentResolver().openInputStream(selectedImage);
                        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                        ByteArrayOutputStream out = new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.PNG, 60, out);
                        Bitmap decoded = BitmapFactory.decodeStream(new ByteArrayInputStream(out.toByteArray()));
                        Bitmap resizedBitmap2 = Bitmap.createScaledBitmap(
                                decoded, decoded.getWidth()/2, decoded.getHeight()/2, false);

                        bitmap2 = resizedBitmap2;
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    return bitmap2;
                }
            })
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<Bitmap>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(Bitmap bitmap) {
                            resizedBitmap = bitmap;
                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onComplete() {
                            renderImage();
                           // progressBar.setVisibility(View.GONE);
                        }
                    });


        }
    }

    @Override
    public void onBackPressed() {
        mInterstitialAd.show();
        super.onBackPressed();
    }

    public void renderImage() {

        FirebaseVisionFaceDetectorOptions highAccuracyOpts =
                new FirebaseVisionFaceDetectorOptions.Builder()
                        .setPerformanceMode(FirebaseVisionFaceDetectorOptions.FAST)
                        .setContourMode(FirebaseVisionFaceDetectorOptions.ALL_CONTOURS)
                        .setLandmarkMode(FirebaseVisionFaceDetectorOptions.ALL_LANDMARKS)
                        .build();

        FirebaseVisionImage image2 = FirebaseVisionImage.fromBitmap(resizedBitmap);

        FirebaseVisionFaceDetector detector = FirebaseVision.getInstance()
                .getVisionFaceDetector(highAccuracyOpts);

        final Bitmap mutableBitmap = resizedBitmap.copy(Bitmap.Config.ARGB_8888, true);
        final Canvas canvas = new Canvas(mutableBitmap);

        Task<List<FirebaseVisionFace>> result2 =
                detector.detectInImage(image2)
                        .addOnSuccessListener(
                                new OnSuccessListener<List<FirebaseVisionFace>>() {
                                    @Override
                                    public void onSuccess(List<FirebaseVisionFace> faces) {
                                        // Task completed successfully
                                        // ...
                                        try {

                                            //Log.d(TAG, "onSuccess: pronaso sam facu");
                                            if (faces.size() == 0) {
                                                Log.d(TAG, "onSuccess: nisam naso face");
                                                analyzingTxt.setVisibility(View.GONE);
                                                didntFindFaceTxt.setVisibility(View.VISIBLE);
                                               // Toast.makeText(MainActivity.this, "nisam naso facu", Toast.LENGTH_LONG).show();
                                            }
                                            for (FirebaseVisionFace face : faces) {

                                                List<FirebaseVisionPoint> allPoints = face.getContour(FirebaseVisionFaceContour.ALL_POINTS).getPoints();
                                                List<FirebaseVisionPoint> faceConture = face.getContour(FirebaseVisionFaceContour.FACE).getPoints();


                                                List<FirebaseVisionPoint> faceConture2 = face.getContour(FirebaseVisionFaceContour.LEFT_EYE).getPoints();
                                                List<FirebaseVisionPoint> faceConture3 = face.getContour(FirebaseVisionFaceContour.RIGHT_EYE).getPoints();

                                                List<FirebaseVisionPoint> faceConture4 = face.getContour(FirebaseVisionFaceContour.LEFT_EYEBROW_BOTTOM).getPoints();
                                                List<FirebaseVisionPoint> faceConture5 = face.getContour(FirebaseVisionFaceContour.LEFT_EYEBROW_TOP).getPoints();

                                                List<FirebaseVisionPoint> faceConture6 = face.getContour(FirebaseVisionFaceContour.LOWER_LIP_TOP).getPoints();
                                                List<FirebaseVisionPoint> faceConture7 = face.getContour(FirebaseVisionFaceContour.LOWER_LIP_BOTTOM).getPoints();

                                                List<FirebaseVisionPoint> faceConture8 = face.getContour(FirebaseVisionFaceContour.RIGHT_EYEBROW_BOTTOM).getPoints();
                                                List<FirebaseVisionPoint> faceConture9 = face.getContour(FirebaseVisionFaceContour.RIGHT_EYEBROW_TOP).getPoints();

                                                List<FirebaseVisionPoint> faceConture10 = face.getContour(FirebaseVisionFaceContour.UPPER_LIP_BOTTOM).getPoints();
                                                List<FirebaseVisionPoint> faceConture11 = face.getContour(FirebaseVisionFaceContour.UPPER_LIP_BOTTOM).getPoints();


                                                List<FirebaseVisionPoint> Nose = face.getContour(FirebaseVisionFaceContour.NOSE_BOTTOM).getPoints();
                                                List<FirebaseVisionPoint> bridgeNose = face.getContour(FirebaseVisionFaceContour.NOSE_BRIDGE).getPoints();


                                                FirebaseVisionPoint NOSE_LEFT = Nose.get(0);
                                                FirebaseVisionPoint NOSE_RIGHT = Nose.get(2);

                                                canvas.drawCircle(NOSE_LEFT.getX(), NOSE_LEFT.getY(), 3, paintBlue);
                                                canvas.drawCircle(NOSE_RIGHT.getX(), NOSE_RIGHT.getY(), 3, paintBlue);


                                                if (!bridgeNose.isEmpty()) {
                                                    FirebaseVisionPoint NOSE_TOP = bridgeNose.get(0);
                                                    FirebaseVisionPoint NOSE_BOTTOM = bridgeNose.get(1);

                                                    canvas.drawCircle(NOSE_TOP.getX(), NOSE_TOP.getY(), 3, paintGreen);
                                                    canvas.drawCircle(NOSE_BOTTOM.getX(), NOSE_BOTTOM.getY(), 3, paintGreen);


                                                    double nose_width = Math.sqrt((Math.pow(NOSE_LEFT.getX() - NOSE_RIGHT.getX(), 2) + Math.pow(NOSE_LEFT.getY() - NOSE_RIGHT.getY(), 2)));
                                                    double nose_height = Math.sqrt((Math.pow(NOSE_TOP.getY() - NOSE_BOTTOM.getX(), 2) + Math.pow(NOSE_TOP.getY() - NOSE_BOTTOM.getY(), 2)));


                                                    Log.d("distances", "Ratio nose= " + nose_width / nose_height);
                                                    Log.d("distances", "nose width= " + nose_width);
                                                    Log.d("distances", "nose height= " + nose_height);

                                                    noseRatio = nose_width / nose_height;

                                                }


                                                FirebaseVisionPoint TOP_HEAD = faceConture.get(0);
                                                FirebaseVisionPoint BOTTOM_HEAD = faceConture.get(18);


                                                FirebaseVisionPoint LEFT_CHEEK = face.getLandmark(FirebaseVisionFaceLandmark.LEFT_CHEEK).getPosition();
                                                FirebaseVisionPoint RIGHT_CHEEK = face.getLandmark(FirebaseVisionFaceLandmark.RIGHT_CHEEK).getPosition();
                                                FirebaseVisionPoint LEFT_EAR = face.getLandmark(FirebaseVisionFaceLandmark.LEFT_EAR).getPosition();
                                                FirebaseVisionPoint RIGHT_EAR = face.getLandmark(FirebaseVisionFaceLandmark.RIGHT_EAR).getPosition();
                                                FirebaseVisionPoint LEFT_EYE = face.getLandmark(FirebaseVisionFaceLandmark.LEFT_EYE).getPosition();
                                                FirebaseVisionPoint RIGHT_EYE = face.getLandmark(FirebaseVisionFaceLandmark.RIGHT_EYE).getPosition();
                                                FirebaseVisionPoint MOUTH_LEFT = face.getLandmark(FirebaseVisionFaceLandmark.MOUTH_LEFT).getPosition();
                                                FirebaseVisionPoint MOUTH_RIGHT = face.getLandmark(FirebaseVisionFaceLandmark.MOUTH_RIGHT).getPosition();
                                                FirebaseVisionPoint MOUTH_BOTTOM = face.getLandmark(FirebaseVisionFaceLandmark.MOUTH_BOTTOM).getPosition();
                                                FirebaseVisionPoint NOSE_BASE = face.getLandmark(FirebaseVisionFaceLandmark.NOSE_BASE).getPosition();

//                                            Log.d("distances", "face2: Eye distance" +Math.abs(RIGHT_EYE.getX().intValue()-LEFT_EYE.getX().intValue()) );
//                                            Log.d("distances", "face2: Mouth distance" +Math.abs(MOUTH_RIGHT.getX().intValue()-MOUTH_LEFT.getX().intValue()) );

                                                int x1 = LEFT_EYE.getX().intValue() + ((RIGHT_EYE.getX().intValue() - LEFT_EYE.getX().intValue()) / 2);
                                                int y1 = LEFT_EYE.getY().intValue() + ((RIGHT_EYE.getY().intValue() - LEFT_EYE.getY().intValue()) / 2);

                                                int x2 = MOUTH_LEFT.getX().intValue() + ((MOUTH_RIGHT.getX().intValue() - MOUTH_LEFT.getX().intValue()) / 2);
                                                int y2 = MOUTH_LEFT.getY().intValue() + ((MOUTH_RIGHT.getY().intValue() - MOUTH_LEFT.getY().intValue()) / 2);

                                                canvas.drawCircle(x1, y1, 3, paint);
                                                canvas.drawCircle(x2, y2, 3, paint);

                                                double eyes_mouth = Math.sqrt((Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));

                                                double head_chin = Math.sqrt((Math.pow(TOP_HEAD.getX() - BOTTOM_HEAD.getX(), 2) + Math.pow(TOP_HEAD.getY() - BOTTOM_HEAD.getY(), 2)));

                                                Log.d("distances", "Ratio.36 = " + eyes_mouth / head_chin);

                                                ratio36 = eyes_mouth / head_chin;

                                                double ear = Math.sqrt((Math.pow(LEFT_EAR.getX() - RIGHT_EAR.getX(), 2) + Math.pow(LEFT_EAR.getY() - RIGHT_EAR.getY(), 2)));
                                                double pupiles = Math.sqrt((Math.pow(RIGHT_EYE.getX() - LEFT_EYE.getX(), 2) + Math.pow(RIGHT_EYE.getY() - LEFT_EYE.getY(), 2)));

                                                Log.d("distances", "Ratio.46 = " + pupiles / ear);
                                                Log.d("distances", "point = " + canvas.getDensity());
                                                Log.d("distances", "pointH = " + canvas.getHeight());
                                                Log.d("distances", "pointW = " + canvas.getWidth());

                                                ratio46 = pupiles / ear;


                                                Observable.fromCallable(new Callable<Celebrity>() {
                                                    @Override
                                                    public Celebrity call() throws Exception {
                                                        return databaseRepository.getCelebritiesWithValue(gender, noseRatio, ratio36, ratio46);
                                                    }
                                                }).subscribeOn(Schedulers.io())
                                                        .observeOn(AndroidSchedulers.mainThread())
                                                        .subscribe(new Observer<Celebrity>() {
                                                                       @Override
                                                                       public void onSubscribe(Disposable d) {

                                                                       }

                                                                       @Override
                                                                       public void onNext(Celebrity celebrity) {
                                                                           Drawable drawable = getResources().getDrawable(getResources()
                                                                                   .getIdentifier(celebrity.getName(), "drawable", getPackageName()));

                                                                            name = celebrity.getName();
                                                                           char first = Character.toUpperCase( name.charAt(0));
                                                                           char second = ' ';
                                                                           String prezime = "";
                                                                           String ime = "";
                                                                           if(name.contains("_")) {
                                                                               second = Character.toUpperCase(name.charAt(name.indexOf('_') + 1));
                                                                               prezime = second+name.substring(name.indexOf('_')+2);
                                                                               ime = first+name.substring(1,name.indexOf('_'));
                                                                           }else{
                                                                               ime = first+name.substring(1);
                                                                           }
                                                                           DecimalFormat df = new DecimalFormat("#.####");
                                                                           df.setRoundingMode(RoundingMode.CEILING);

                                                                           littleDudeLookLike.setVisibility(View.VISIBLE);
                                                                           CelebImageView.setImageDrawable(drawable);
                                                                           pin2.setVisibility(View.VISIBLE);
                                                                           progressBar.setVisibility(View.GONE);
                                                                           analyzingTxt.setVisibility(View.GONE);
                                                                           didntFindFaceTxt.setVisibility(View.GONE);
                                                                           chalkText.setVisibility(View.VISIBLE);
                                                                           celebNameView.setText( ime + " " + prezime);
                                                                           noseRatioTxt.setText("Nose Ratio : " +df.format(celebrity.getNoseRation()));//+c.geg..
                                                                           eyeEarTxt.setText("Eyes Ratio : " + df.format(celebrity.getRatio36()));
                                                                           mouthChinTxt.setText("Mouth Ratio : " +df.format( celebrity.getRatio46()));

                                                                       }

                                                                       @Override
                                                                       public void onError(Throwable e) {

                                                                       }

                                                                       @Override
                                                                       public void onComplete() {

                                                                       }
                                                                   });
//                                                AsyncTask.execute(new Runnable() {
//                                                    @Override
//                                                    public void run() {
//                                                        //TODO your background code
//                                                         celebrity = databaseRepository.getCelebritiesWithValue(gender, noseRatio, ratio36, ratio46);
//                                                        Log.d(TAG, "run: " + celebrity.getName());
//
//
//
//
////                                                        String realName = ime + " " + prezime ;
////                                                        Log.d(TAG, "run: "+ime);
////                                                        Log.d(TAG, "run: "+prezime);
//
//                                                    }
//                                                });



                                                    float radius = canvas.getWidth() / 240;

                                                        canvas.drawCircle((float) LEFT_CHEEK.getX().intValue(), (float) LEFT_CHEEK.getY().intValue(), radius, paint);
                                                canvas.drawCircle((float) RIGHT_CHEEK.getX().intValue(), (float) RIGHT_CHEEK.getY().intValue(), radius, paint);
                                                canvas.drawCircle((float) LEFT_EAR.getX().intValue(), (float) LEFT_EAR.getY().intValue(), radius, paint);
                                                canvas.drawCircle((float) RIGHT_EAR.getX().intValue(), (float) RIGHT_EAR.getY().intValue(), radius, paint);
                                                canvas.drawCircle((float) LEFT_EYE.getX().intValue(), (float) LEFT_EYE.getY().intValue(), radius, paint);
                                                canvas.drawCircle((float) RIGHT_EYE.getX().intValue(), (float) RIGHT_EYE.getY().intValue(), radius, paint);
                                                canvas.drawCircle((float) MOUTH_LEFT.getX().intValue(), (float) MOUTH_LEFT.getY().intValue(), radius, paint);
                                                canvas.drawCircle((float) MOUTH_RIGHT.getX().intValue(), (float) MOUTH_RIGHT.getY().intValue(), radius, paint);
                                                canvas.drawCircle((float) MOUTH_BOTTOM.getX().intValue(), (float) MOUTH_BOTTOM.getY().intValue(), radius, paint);
                                                canvas.drawCircle((float) NOSE_BASE.getX().intValue(), (float) NOSE_BASE.getY().intValue(), radius, paint);

                                                canvas.drawCircle((float) TOP_HEAD.getX().intValue(), (float) TOP_HEAD.getY().intValue(), radius, paint);
                                                canvas.drawCircle((float) BOTTOM_HEAD.getX().intValue(), (float) BOTTOM_HEAD.getY().intValue(), radius, paint);


                                                for (int i = 0; i < faceConture.size() - 1; i++) {

                                                    canvas.drawLine(faceConture.get(i).getX(), faceConture.get(i).getY(), faceConture.get(i + 1).getX(), faceConture.get(i + 1).getY(), paint);
                                                }

                                                for (int i = 0; i < faceConture2.size() - 1; i++) {

                                                    canvas.drawLine(faceConture2.get(i).getX(), faceConture2.get(i).getY(), faceConture2.get(i + 1).getX(), faceConture2.get(i + 1).getY(), paint);
                                                }
                                                for (int i = 0; i < faceConture3.size() - 1; i++) {

                                                    canvas.drawLine(faceConture3.get(i).getX(), faceConture3.get(i).getY(), faceConture3.get(i + 1).getX(), faceConture3.get(i + 1).getY(), paint);
                                                }
                                                for (int i = 0; i < faceConture4.size() - 1; i++) {

                                                    canvas.drawLine(faceConture4.get(i).getX(), faceConture4.get(i).getY(), faceConture4.get(i + 1).getX(), faceConture4.get(i + 1).getY(), paint);
                                                }
                                                for (int i = 0; i < faceConture5.size() - 1; i++) {

                                                    canvas.drawLine(faceConture5.get(i).getX(), faceConture5.get(i).getY(), faceConture5.get(i + 1).getX(), faceConture5.get(i + 1).getY(), paint);
                                                }
                                                for (int i = 0; i < faceConture6.size() - 1; i++) {

                                                    canvas.drawLine(faceConture6.get(i).getX(), faceConture6.get(i).getY(), faceConture6.get(i + 1).getX(), faceConture6.get(i + 1).getY(), paint);
                                                }
                                                for (int i = 0; i < faceConture7.size() - 1; i++) {

                                                    canvas.drawLine(faceConture7.get(i).getX(), faceConture7.get(i).getY(), faceConture7.get(i + 1).getX(), faceConture7.get(i + 1).getY(), paint);
                                                }
                                                for (int i = 0; i < faceConture8.size() - 1; i++) {

                                                    canvas.drawLine(faceConture8.get(i).getX(), faceConture8.get(i).getY(), faceConture8.get(i + 1).getX(), faceConture8.get(i + 1).getY(), paint);
                                                }
                                                for (int i = 0; i < faceConture9.size() - 1; i++) {

                                                    canvas.drawLine(faceConture9.get(i).getX(), faceConture9.get(i).getY(), faceConture9.get(i + 1).getX(), faceConture9.get(i + 1).getY(), paint);
                                                }
                                                for (int i = 0; i < faceConture10.size() - 1; i++) {

                                                    canvas.drawLine(faceConture10.get(i).getX(), faceConture10.get(i).getY(), faceConture10.get(i + 1).getX(), faceConture10.get(i + 1).getY(), paint);
                                                }
                                                for (int i = 0; i < faceConture11.size() - 1; i++) {

                                                    canvas.drawLine(faceConture11.get(i).getX(), faceConture11.get(i).getY(), faceConture11.get(i + 1).getX(), faceConture11.get(i + 1).getY(), paint);
                                                }


                                                imageView.setImageBitmap(mutableBitmap);
                                                pin1.setVisibility(View.VISIBLE);
                                            }


                                        } catch (Exception e) {
                                            Log.d(TAG, "onSuccess: "+e.getMessage());
                                            Toast.makeText(MainActivity.this, "Please select new image", Toast.LENGTH_LONG).show();
                                        }


                                    }
                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.d(TAG, "onFailure: nisam naso facu");

                                    }
                                });


    }
}

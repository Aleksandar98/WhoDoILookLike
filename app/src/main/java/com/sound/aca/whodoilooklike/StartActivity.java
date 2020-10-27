package com.sound.aca.whodoilooklike;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.sound.aca.whodoilooklike.Models.CelebrityData;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class StartActivity extends AppCompatActivity {

    private static final int PICK_IMAGE = 1;
    static final int REQUEST_IMAGE_CAPTURE = 2;

    ImageView maleBtn,femaleBtn,cameraBtn,galleryBtn,littleDude;
    LinearLayout btn_holder;
    LinearLayout btn_holder2;
    Animation left2right,left2right2,go_right,shake;
    TextView cameraTxt,galleryTxt;
    String gender;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        btn_holder2 = findViewById(R.id.btn_holder2);
        btn_holder = findViewById(R.id.btn_holder);

        maleBtn = findViewById(R.id.maleBtn);
        femaleBtn = findViewById(R.id.femaleBtn);
        cameraBtn = findViewById(R.id.cameraBtn);
        galleryBtn = findViewById(R.id.galleryBtn);

        cameraTxt = findViewById(R.id.cameraTxt);
        galleryTxt = findViewById(R.id.galleryTxt);

        littleDude = findViewById(R.id.littleDude);




        /*RotateAnimation rotate = new RotateAnimation(0, 45, Animation., 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(2000);
        rotate.setInterpolator(new LinearInterpolator());



        littleDude.startAnimation(rotate);*/


        left2right = AnimationUtils.loadAnimation(this,R.anim.left2right);
        left2right2 = AnimationUtils.loadAnimation(this,R.anim.left2right);
        go_right = AnimationUtils.loadAnimation(this,R.anim.go_right);

        shake = AnimationUtils.loadAnimation(this,R.anim.shake);

        littleDude.startAnimation(left2right2);
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

        maleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    gender = "male";
                    btn_holder.startAnimation(go_right);
                    btn_holder2.startAnimation(left2right);
                littleDude.setImageDrawable(getDrawable(R.drawable.nice_to_meet1));
            }
        });
        femaleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender = "female";
                btn_holder.startAnimation(go_right);
                btn_holder2.startAnimation(left2right);
                littleDude.setImageDrawable(getDrawable(R.drawable.nice_to_meet2));
            }
        });

        cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(v.getContext())
                        .setTitle("Disclaimer")
                        .setMessage("Results may vary depending on a distance picture was taken from.For more consistent results load images form gallery")

                        // Specifying a listener allows you to take an action before dismissing the dialog.
                        // The dialog is automatically dismissed when a dialog button is clicked.
                        .setPositiveButton("Use Camera", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Continue with delete operation
                                dispatchTakePictureIntent();

                            }
                        })

                        // A null listener allows the button to dismiss the dialog and take no further action.
                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();

            }
        });

        galleryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);


            }
        });



        left2right.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                btn_holder.setVisibility(View.GONE);

               // cameraTxt.setVisibility(View.VISIBLE);
               // galleryTxt.setVisibility(View.VISIBLE);

                cameraTxt.setText("Camera");
                galleryTxt.setText("Gallery");

                galleryTxt.startAnimation(shake);
                cameraTxt.startAnimation(shake);

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        // yourMethod();
                        littleDude.setImageDrawable(getDrawable(R.drawable.load_images_dialog));
                    }
                }, 1500);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    @Override
    public void onBackPressed() {
        mInterstitialAd.show();
        super.onBackPressed();
    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.btnShare:
//                try {
//                    Intent i = new Intent(Intent.ACTION_SEND);
//                    i.setType("text/plain");
//                    i.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name));
//                    String sAux = "Create awesome Baby photos with unique costumes & stickers.\n";
//                    sAux = sAux + "https://play.google.com/store/apps/details?id=" + getPackageName() + "";
//                    i.putExtra(Intent.EXTRA_TEXT, sAux);
//                    startActivity(Intent.createChooser(i, "choose one"));
//
//                } catch (Exception e) {
//                }
//                break;
//            case R.id.btnRate:
//                final String appPackageName = getApplication().getPackageName();
//                try {
//                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
//                } catch (android.content.ActivityNotFoundException anfe) {
//                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + appPackageName)));
//                }
//                break;
//            case R.id.btnHelp:
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                String subject = getString(R.string.app_name) + " Support Request ";
//                String body = "";
//                Uri data = Uri.parse("mailto:" + getString(R.string.SUPPORT_EMAIL) + "?subject=" + subject + "&body=" + body);
//                intent.setData(data);
//                startActivity(intent);
//                break;
//            case R.id.btnMore:
//                try {
//                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.PRIVACY_URL))));
//                } catch (Exception e) {
//                }
//                break;
//        }
//    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            if (data != null) {
             //   try {
//                    InputStream inputStream = getContentResolver().openInputStream(data.getData());
//                  Bitmap  bitmap = BitmapFactory.decodeStream(inputStream);
//                    ByteArrayOutputStream out = new ByteArrayOutputStream();
//                    bitmap.compress(Bitmap.CompressFormat.PNG, 50, out);
//                    Bitmap decoded = BitmapFactory.decodeStream(new ByteArrayInputStream(out.toByteArray()));
//                  Bitmap  resizedBitmap = Bitmap.createScaledBitmap(
//                            decoded, decoded.getWidth()/3  , decoded.getHeight()/3, false);
//                    Log.d("IMAGE_SIZE", "onActivityResult: "+ resizedBitmap.getByteCount());


                    Intent intent = new Intent(this,MainActivity.class);
                    intent.putExtra("selectedImage2",data.getData());
                    intent.putExtra("gender",gender);
                    startActivity(intent);
                mInterstitialAd.show();
                   // imageView.setImageBitmap(resizedBitmap);
                  //  renderImage();

//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                }
            }

            //Now you can do whatever you want with your inpustream, save it as file, upload to a server, decode a bitmap...
        }

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            Intent intent = new Intent(this,MainActivity.class);
            intent.putExtra("selectedImage",imageBitmap);
            intent.putExtra("gender",gender);

            startActivity(intent);
            mInterstitialAd.show();
        }
    }
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
}

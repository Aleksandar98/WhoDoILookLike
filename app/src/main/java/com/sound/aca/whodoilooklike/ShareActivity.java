package com.sound.aca.whodoilooklike;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        ImageView image = findViewById(R.id.testImage);
        ImageView imageShare = findViewById(R.id.shareFinal);

        String celebrityName = getIntent().getStringExtra("celebrityName");

        Drawable drawable = getResources().getDrawable(getResources()
                .getIdentifier(celebrityName, "drawable", getPackageName()));

        Bitmap famous = drawableToBitmap(drawable);

        //Bitmap bitmapSmall = getIntent().getParcelableExtra("personImage");

        byte[] byteArray = getIntent().getByteArrayExtra("personImage");
        Bitmap person = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

        final Bitmap finalBitmap = combineImages(famous,person);
        image.setImageBitmap(finalBitmap);

        imageShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_STREAM, saveImage(finalBitmap));
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                intent.setType("image/png");
                startActivity(intent);
            }
        });


    }

    public static Bitmap drawableToBitmap (Drawable drawable) {
        Bitmap bitmap = null;

        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if(bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }

        if(drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888); // Single color bitmap will be created of 1x1 pixel
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }
    public Bitmap combineImages(Bitmap c, Bitmap s)
    {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int widthHalf = displayMetrics.widthPixels/2;
        int myImageHeight =(int)(widthHalf+widthHalf*0.2);

        Bitmap c2 = Bitmap.createScaledBitmap(c,widthHalf,displayMetrics.widthPixels,false);
        Bitmap s2 = Bitmap.createScaledBitmap(s,widthHalf,myImageHeight,false);
        Bitmap cs = null;

        int width, height = 0;

        if(c.getWidth() > s.getWidth()) {
            width = c.getWidth() + s.getWidth();
            height = c.getHeight();
        } else {
            width = s.getWidth() + s.getWidth();
            height = c.getHeight();
        }



        cs = Bitmap.createBitmap(displayMetrics.widthPixels, displayMetrics.widthPixels, Bitmap.Config.ARGB_8888);


        Canvas comboImage = new Canvas(cs);

        Typeface plain = Typeface.createFromAsset(getAssets(),"chalk_font.ttf");

        Paint paint = new Paint();
        Paint paint2 = new Paint();
        Paint paint3 = new Paint();
        paint.setTypeface(plain);
        paint2.setTypeface(plain);

        //Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.white));
        paint2.setColor(getResources().getColor(R.color.white));
        paint3.setColor(getResources().getColor(R.color.white));
        paint.setTextSize(150);
        paint2.setTextSize(80);
        paint3.setStrokeWidth(10);

        comboImage.drawColor(Color.BLACK);
        comboImage.drawBitmap(c2, 0f, 0f, null);
        comboImage.drawBitmap(s2, widthHalf, 0f, null);
        comboImage.drawText("92%",widthHalf,myImageHeight+150,paint);
        comboImage.drawText("Match",widthHalf,myImageHeight+150+150,paint2);
        comboImage.drawLine(widthHalf,0,widthHalf,displayMetrics.widthPixels,paint3);
        comboImage.drawLine(widthHalf,myImageHeight,displayMetrics.widthPixels,myImageHeight,paint3);
       // comboImage.drawText("Chris Brown",c.getWidth(),s.getHeight()+150+150+150,paint2);


        return cs;
    }

    private Uri saveImage(Bitmap image) {
        //TODO - Should be processed in another thread
        File imagesFolder = new File(getCacheDir(), "images");
        Uri uri = null;
        try {
            imagesFolder.mkdirs();
            File file = new File(imagesFolder, "shared_image.png");

            FileOutputStream stream = new FileOutputStream(file);
            image.compress(Bitmap.CompressFormat.PNG, 90, stream);
            stream.flush();
            stream.close();
            uri = FileProvider.getUriForFile(this, "com.mydomain.fileprovider", file);

        } catch (IOException e) {
            Log.d("mojTag", "IOException while trying to write file for sharing: " + e.getMessage());
        }
        return uri;
    }
}

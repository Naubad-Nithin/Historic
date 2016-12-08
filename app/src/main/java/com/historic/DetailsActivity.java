package com.historic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created by Nithin on 12/4/2016.
 */
public class DetailsActivity extends AppCompatActivity{
//    private TextView country;

    private ShareActionProvider mShareActionProvider;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_layout);
        Toolbar mtoolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        Intent in = getIntent();

        final Content content = (Content) in.getSerializableExtra("pass");


//        String title = in.getStringExtra("title");
        TextView titleView = (TextView) findViewById(R.id.details_title);
        titleView.setText(content.getName());

        TextView fullName = (TextView) findViewById(R.id.detail_name);
        fullName.setText(content.getFullName());

        TextView description = (TextView) findViewById(R.id.details_desc);
        description.setText(content.getDescription());

        ImageView personImage = (ImageView) findViewById(R.id.details_image);
        personImage.setImageResource(Utils.getResId(content.getImage(), R.drawable.class));

        TextView period = (TextView) findViewById(R.id.details_period);
        period.setText("Period: " + content.getPeriod());

        TextView country = (TextView) findViewById(R.id.detail_country);
        country.setText("Country: " + content.getCountry());

        TextView references = (TextView) findViewById(R.id.details_reference);
        references.setText(content.getReferences());

        TextView keys = (TextView) findViewById(R.id.details_famous_for);
        keys.setText(content.getKeys());

        ImageView imageBack  = (ImageView) findViewById(R.id.details_back);
        imageBack.setClickable(true);
        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Back clicked", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        final ImageView imageBookmark  = (ImageView) findViewById(R.id.details_bookmark);
        imageBookmark.setClickable(true);

        final SharedPreferences.Editor editor = getSharedPreferences("pref", MODE_PRIVATE).edit();
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);


        imageBookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Clicked", Toast.LENGTH_LONG).show();
                if(Integer.parseInt(imageBookmark.getTag().toString())==1){
                    imageBookmark.setImageResource(R.drawable.bookmark);
                    imageBookmark.setTag(2);
                    editor.putInt("bookmark", Integer.parseInt(imageBookmark.getTag().toString()));
                    editor.commit();
                } else {
                    imageBookmark.setImageResource(R.drawable.bookmark_not);
                    imageBookmark.setTag(1);
                    editor.putInt("bookmark", Integer.parseInt(imageBookmark.getTag().toString()));
                    editor.commit();
                }
            }
        });

        int bookMark = pref.getInt("bookmark",0);
        if(bookMark!=0){
            imageBookmark.setTag(bookMark);
        }

        
        ImageView imageShare = (ImageView) findViewById(R.id.details_share);
        imageShare.setClickable(true);
        imageShare.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Sharing..",Toast.LENGTH_LONG).show();
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("*/*");
                String shareBody = "Name:"+content.getFullName()+'\n'+"Period:"+content.getPeriod();
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Know more from Historic");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });

    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu){
//        getMenuInflater().inflate(R.menu.details_menu, menu);
//        return true;
//    }
}

package com.example.android.bucharesttourguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attraction_details);

        // Get current attraction title
        String display_title = getIntent().getStringExtra("title");

        // Find the TextView for the current attraction title in the details.xml layout file
        TextView current_title = findViewById(R.id.current_title_textview);

        //Set the current attraction title
        current_title.setText(display_title);

        // Get current attraction description
        String display_description = getIntent().getStringExtra("description");

        // Find the TextView for the current attraction description in the details.xml layout file
        TextView current_description = findViewById(R.id.current_description_textview);

        //Set the current attraction description
        current_description.setText(display_description);

        // Get current image resource id
        int display_image = getIntent().getIntExtra("image", 0);

        // Find the TextView for the current image in the attraction_details.xmlml layout file
        ImageView current_image = findViewById(R.id.current_image_attraction);

        //Set the current image
        current_image.setImageResource(display_image);

        // Stretch image in imageView to fit screen
        current_image.setScaleType(ImageView.ScaleType.FIT_XY);

    }
}

package com.example.android.bucharesttourguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lfotache on 16.03.2018.
 */

public class LocationAdapter extends ArrayAdapter<Location> {

    public LocationAdapter(Activity context, ArrayList<Location> locations) {

        // Initialize the ArrayAdapter's internal storage for the context
        super(context, 0, locations);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the Location object located at this position in the list
        Location currentLocation = getItem(position);

        // Find the Title TextView in the playlist_item.xml layout
        TextView Title = listView.findViewById(R.id.attraction_title_item);

        // Get the location description from the currentLocation object and set this text on the attraction_description TextView
        Title.setText(currentLocation.getTitle());

        // Find the Description TextView in the playlist_item.xml layout
        TextView Description = listView.findViewById(R.id.attraction_description_item);

        // Get the location description from the currentLocation object and set this text on the attraction_description TextView
        Description.setText(currentLocation.getDescription());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView imageView = listView.findViewById(R.id.image);

        // Display the provided image based on the resource ID
        imageView.setImageResource(currentLocation.getImageResourceId());

        // Make sure the view is visible
        imageView.setVisibility(View.VISIBLE);

        // Stretch image in imageView to fit screen
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);

        // Return the list_item view
        return listView;
    }
}



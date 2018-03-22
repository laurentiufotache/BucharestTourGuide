package com.example.android.bucharesttourguide;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BestOffFragment extends Fragment {


    public BestOffFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        //Create the ArrayList
        final ArrayList<Location> locations = new ArrayList<>();

        locations.add(new Location(getString(R.string.palace_of_parliament), getString(R.string.palace_of_parliament_description), R.drawable.palaceofparliament));
        locations.add(new Location(getString(R.string.romanian_athenaeum), getString(R.string.romanian_athenaeum_description), R.drawable.atheneum));
        locations.add(new Location(getString(R.string.national_bank), getString(R.string.national_bank_description), R.drawable.nationabank));
        locations.add(new Location(getString(R.string.arch), getString(R.string.arch_description), R.drawable.arch));
        locations.add(new Location(getString(R.string.km0), getString(R.string.km0_description), R.drawable.km0));
        locations.add(new Location(getString(R.string.old_town), getString(R.string.old_town_description), R.drawable.oldtown));

        // Create the LocationAdapter, whose data source is a list of locations. The adapter knows how to create list items for each item in the list
        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);

        // Find the ListView object in the list.xml layout file
        ListView listView = rootView.findViewById(R.id.list);

        //Set the background color for listView
        listView.setBackgroundColor(Color.parseColor("#880E4F"));

        // Make the listView to use the LocationAdapter we created above, so that the listView will display list items for each location in the list
        listView.setAdapter(adapter);

        // Set a click listener to open the details activity when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Get the attraction title at the given position the user clicked on
                String title = locations.get(position).getTitle();

                // Get the attraction description at the given position the user clicked on
                String description = locations.get(position).getDescription();

                // Get the image resource id attraction at the given position the user clicked on
                int image = locations.get(position).getImageResourceId();

                //create the DetailsIntent and send extra info to Details Activity
                Intent DetailsIntent = new Intent(getActivity(), Details.class);
                DetailsIntent.putExtra("description", description);
                DetailsIntent.putExtra("title", title);
                DetailsIntent.putExtra("image", image);
                startActivity(DetailsIntent);
            }
        });

        return rootView;
    }
}

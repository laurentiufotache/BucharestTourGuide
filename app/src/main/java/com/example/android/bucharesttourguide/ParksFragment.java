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
public class ParksFragment extends Fragment {


    public ParksFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        //Create the ArrayList
        final ArrayList<Location> locations = new ArrayList<>();

        locations.add(new Location(getString(R.string.herastrau), getString(R.string.herastrau_description), R.drawable.herastrau));
        locations.add(new Location(getString(R.string.cismigiu), getString(R.string.cismigiu_description), R.drawable.cismigiu));
        locations.add(new Location(getString(R.string.kiseleff), getString(R.string.kiseleff_description), R.drawable.kiseleff));
        locations.add(new Location(getString(R.string.opera), getString(R.string.opera_description), R.drawable.opera));
        locations.add(new Location(getString(R.string.ior), getString(R.string.ior_description), R.drawable.ior));

        // Create the LocationAdapter, whose data source is a list of locations. The adapter knows how to create list items for each item in the list
        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);

        // Find the ListView object in the list.xml layout file
        ListView listView = rootView.findViewById(R.id.list);

        //Set the background color for listView
        listView.setBackgroundColor(Color.parseColor("#00695C"));

        // Make the listView to use the LocationAdapter we created above, so that the listView will display list items for each tour in the list
        listView.setAdapter(adapter);

        // Set a click listener to open the details activity when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Get the attraction description at the given position the user clicked on
                String title = locations.get(position).getTitle();

                // Get the attraction description at the given position the user clicked on
                String description = locations.get(position).getDescription();

                // Get the attraction description at the given position the user clicked on
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

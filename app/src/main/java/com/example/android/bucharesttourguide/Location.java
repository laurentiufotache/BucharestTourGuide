package com.example.android.bucharesttourguide;

/**
 * Created by lfotache on 16.03.2018.
 */

public class Location {

    //Declare the private variables
    private String mDescription;
    private String mTitle;
    private int mImageResourceId;

    /**
     * Create a new Word object.
     *
     * @param Title           is the title of the attraction
     * @param Description     is the description of the attraction
     * @param imageResourceId is the drawable resource ID for the image associated with the word
     */
    public Location(String Title, String Description, int imageResourceId) {
        mTitle = Title;
        mDescription = Description;
        mImageResourceId = imageResourceId;
    }

    /**
     * Return the image resource ID of the tour.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Return the title of the attraction
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Return the description of the attraction
     */
    public String getDescription() {
        return mDescription;
    }
}

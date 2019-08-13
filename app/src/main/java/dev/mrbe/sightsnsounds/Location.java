package dev.mrbe.sightsnsounds;

import android.os.Parcel;
import android.os.Parcelable;

public class Location implements Parcelable {
    /**
     * Creator
     */
    public static final Creator<Location> CREATOR =
            new Creator<Location>() {
                @Override
                public Location createFromParcel(Parcel source) {
                    return new Location(source);
                }

                @Override
                public Location[] newArray(int size) {
                    return new Location[size];
                }
            };
    //Default value for image resources
    private static final int NO_IMAGE_PRESENT = -8;
    /**
     * {@link Location represents a collection of attractions and their locations}
     */
    //Attraction name
    private String mAttractionName;
    //Location name
    private String mLocationName;
    //Attraction Details text
    private String mAtrractionDetails;
    //Primary Image resource for Attraction
    private int mPrimaryImageResource = NO_IMAGE_PRESENT;
    //Category name
    private String mCategoryName;

    /**
     * Constructor for {@link Location} object with single image
     *
     * @param mAttractionName       is the name of the attraction in the tour guide
     * @param mLocationName         is the place where the attraction can be found
     * @param mPrimaryImageResource is the image to be used in the list view
     */
    public Location(String mAttractionName, String mLocationName, int mPrimaryImageResource, String atrractionDetails, String categoryName) {
        this.mAttractionName = mAttractionName;
        this.mLocationName = mLocationName;
        this.mAttractionName = atrractionDetails;
        this.mPrimaryImageResource = mPrimaryImageResource;
        this.mCategoryName = categoryName;
    }

    /**
     * Constructor for {@link Location} object with single Image and attraction details
     *
     * @param mAttractionName       is the name of the attraction in the tour guide
     * @param mLocationName         is the place where the attraction can be found
     * @param mPrimaryImageResource is the image to be used in the list view
     * @param mAtrractionDetails    is the detailed description of attraction
     */
    public Location(String mAttractionName, String mLocationName,
                    int mPrimaryImageResource, String mAtrractionDetails) {
        this.mAttractionName = mAttractionName;
        this.mLocationName = mLocationName;
        this.mPrimaryImageResource = mPrimaryImageResource;
        this.mAtrractionDetails = mAtrractionDetails;
    }

    /**
     * Constructor for {@link Location} object with no Image
     * This constructor is used for Lodging list
     *
     * @param mAttractionName is the name of the lodging
     * @param mLocationName   is the location of the lodging
     */
    public Location(String mAttractionName, String mLocationName) {
        this.mAttractionName = mAttractionName;
        this.mLocationName = mLocationName;
    }

    /**
     * Read parcelable constructor
     */
    private Location(Parcel source) {
        this.mAttractionName = source.readString();
        this.mAtrractionDetails = source.readString();
        this.mPrimaryImageResource = source.readInt();
        this.mCategoryName = source.readString();

    }

    /*Getter methods for the location parameters*/
    //Get attraction name
    public String getmAttractionName() {
        return mAttractionName;
    }

    //Get name of attraction location
    public String getmLocationName() {
        return mLocationName;
    }

    //Get primary Image resource for attraction
    public int getmPrimaryImageResource() {
        return mPrimaryImageResource;
    }

    //Get attraction details for attraction
    public String getmAtrractionDetails() {
        return mAtrractionDetails;
    }

    public void setAttractionName(String attractionName) {
        mAttractionName = attractionName;
    }

    public void setLocationName(String locationName) {
        mLocationName = locationName;
    }

    public void setAtrractionDetails(String atrractionDetails) {
        mAtrractionDetails = atrractionDetails;
    }

    public void setPrimaryImageResource(int primaryImageResource) {
        mPrimaryImageResource = primaryImageResource;
    }

    //Check if image is present
    public boolean hasImage() {
        return mPrimaryImageResource != NO_IMAGE_PRESENT;
    }

    public String getCategoryName() {
        return mCategoryName;
    }

    public void setCategoryName(String categoryName) {
        mCategoryName = categoryName;
    }

    /**
     * Parcelable methods
     */
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        /*Write activity content to parcel*/
        dest.writeString(mAttractionName);
        dest.writeString(mAtrractionDetails);
        dest.writeInt(mPrimaryImageResource);
        dest.writeString(mCategoryName);
    }
}

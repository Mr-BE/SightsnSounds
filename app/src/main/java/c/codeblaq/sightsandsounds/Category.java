package c.codeblaq.sightsandsounds;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Category implements Parcelable {
    /**
     * Parcelable methods
     */

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };
    private String mCategoryName;
    private int imageInCat;
    private String locationInCat;

//    public Category(String categoryName, int imageInCat, String locationInCat) {
//        mCategoryName = categoryName;
//        this.imageInCat = imageInCat;
//        this.locationInCat = locationInCat;
//    }
    private List<Location> mLocations;

    public Category(String categoryName, List<Location> locations) {
        mCategoryName = categoryName;
        mLocations = locations;
    }

    /**
     * Parcelable constructor
     */
    private Category(Parcel in) {
        this.mCategoryName = in.readString();
//        this.mLocations = new ArrayList<Location>();
//        in.readList(mLocations, null);
        this.imageInCat = in.readInt();
        this.locationInCat = in.readString();
    }

    public int getImageInCat() {
        for (int i = 0; i < getLocations().size(); i++) {
            imageInCat = getLocations().get(i).getmPrimaryImageResource();
        }
        int a = getLocations().size();
        return imageInCat;
    }

    public void setImageInCat(int imageInCat) {

        this.imageInCat = imageInCat;
    }

    public String getCategoryName() {
        return mCategoryName;
    }

    public String getLocationInCat() {
        for (int i = 0; i < getLocations().size(); i++) {
            locationInCat = getLocations().get(i).getmLocationName();
        }
        return locationInCat;
    }

    public void setLocationInCat(String locationInCat) {
        this.locationInCat = locationInCat;
    }

    public List<Location> getLocations() {
        return mLocations;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mCategoryName);
        dest.writeInt(imageInCat);
        dest.writeString(locationInCat);
//        dest.writeList(mLocations);
    }


}

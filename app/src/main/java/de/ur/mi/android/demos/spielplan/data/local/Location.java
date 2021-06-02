package de.ur.mi.android.demos.spielplan.data.local;

import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("LocationCity")
    public final String city;
    @SerializedName("LocationStadium")
    public final String stadium;

    public Location(String city, String stadium) {
        this.city = city;
        this.stadium = stadium;
    }

}

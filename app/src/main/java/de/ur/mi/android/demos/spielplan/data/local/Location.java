package de.ur.mi.android.demos.spielplan.data.local;

import org.json.JSONException;
import org.json.JSONObject;

public class Location {
    public final String city;
    public final String stadium;

    public Location(String city, String stadium) {
        this.city = city;
        this.stadium = stadium;
    }

    public static class LocationBuilder implements JSONBuilder<Location> {

        @Override
        public Location fromJSONObject(JSONObject object) throws JSONException {
            String city = object.getString("LocationCity");
            String stadium = object.getString("LocationStadium");
            return new Location(city, stadium);
        }

    }

}

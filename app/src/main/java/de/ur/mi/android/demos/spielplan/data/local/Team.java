package de.ur.mi.android.demos.spielplan.data.local;

import com.google.gson.annotations.SerializedName;

public class Team {

    @SerializedName("TeamName")
    public final String teamName;
    @SerializedName("ShortName")
    public final String shortName;

    public Team(String teamName, String shortName) {
        this.teamName = teamName;
        this.shortName = shortName;
    }
}

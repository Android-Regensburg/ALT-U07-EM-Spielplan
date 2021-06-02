package de.ur.mi.android.demos.spielplan.data.local;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Match {

    @SerializedName("Team1")
    public final Team teamOne;
    @SerializedName("Team2")
    public final Team teamTwo;
    @SerializedName("Location")
    public final Location location;
    @SerializedName("MatchDateTime")
    private final String matchDateTime;

    public Match(Team teamOne, Team teamTwo, Location location, String matchDateTime) {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        this.location = location;
        this.matchDateTime = matchDateTime;
    }

    public static ArrayList<Match> fromJSONString(String jsonString) {
        ArrayList<Match> matches = new ArrayList<>();
        JsonArray jsonArray = new Gson().fromJson(jsonString, JsonArray.class);
        jsonArray.forEach(jsonElement -> {
            matches.add(new Gson().fromJson(jsonElement.getAsJsonObject().toString(), Match.class));
        });
        return matches;
    }

    public LocalDateTime getMatchDateTime() {
        return LocalDateTime.parse(matchDateTime);
    }

    @Override
    public String toString() {
        return "Match{" +
                "teamOne=" + teamOne +
                ", teamTwo=" + teamTwo +
                ", location=" + location +
                ", matchDateTime=" + matchDateTime +
                '}';
    }
}

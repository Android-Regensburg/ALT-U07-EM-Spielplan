package de.ur.mi.android.demos.spielplan.data.local;

import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDateTime;

public class Match {

    public final Team teamOne;
    public final Team teamTwo;
    public final Location location;
    public final LocalDateTime matchDateTime;

    public Match(Team teamOne, Team teamTwo, Location location, LocalDateTime matchDateTime) {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        this.location = location;
        this.matchDateTime = matchDateTime;
    }

    public static Match fromJSONObject(JSONObject object) throws JSONException {
        Team teamOne = Team.fromJSONObject(object.getJSONObject("Team1"));
        Team teamTwo = Team.fromJSONObject(object.getJSONObject("Team2"));
        Location location = Location.fromJSONObject(object.getJSONObject("Location"));
        LocalDateTime matchDateTime = LocalDateTime.parse(object.getString("MatchDateTime"));
        return new Match(teamOne, teamTwo, location, matchDateTime);
    }

}

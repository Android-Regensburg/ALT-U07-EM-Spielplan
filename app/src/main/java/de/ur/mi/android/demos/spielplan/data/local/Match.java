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

    @Override

    public String toString() {
        return "Match{" +
                "teamOne=" + teamOne +
                ", teamTwo=" + teamTwo +
                ", location=" + location +
                ", matchDateTime=" + matchDateTime +
                '}';
    }

    public static class MatchBuilder implements JSONBuilder<Match> {

        @Override
        public Match fromJSONObject(JSONObject object) throws JSONException {
            Team teamOne = new Team.TeamBuilder().fromJSONObject(object.getJSONObject("Team1"));
            Team teamTwo = new Team.TeamBuilder().fromJSONObject(object.getJSONObject("Team2"));
            Location location = new Location.LocationBuilder().fromJSONObject(object.getJSONObject("Location"));
            LocalDateTime matchDateTime = LocalDateTime.parse(object.getString("MatchDateTime"));
            return new Match(teamOne, teamTwo, location, matchDateTime);
        }

    }
}

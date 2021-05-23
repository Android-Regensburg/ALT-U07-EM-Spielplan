package de.ur.mi.android.demos.spielplan.data.local;

import org.json.JSONException;
import org.json.JSONObject;

public class Team {

    public final String teamName;
    public final String shortName;

    public Team(String teamName, String shortName) {
        this.teamName = teamName;
        this.shortName = shortName;
    }

    public static class TeamBuilder implements JSONBuilder<Team> {

        @Override
        public Team fromJSONObject(JSONObject object) throws JSONException {
            String teamName = object.getString("TeamName");
            String shortName = object.getString("ShortName");
            return new Team(teamName, shortName);
        }

    }
}

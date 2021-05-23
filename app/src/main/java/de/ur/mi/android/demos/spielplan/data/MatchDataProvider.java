package de.ur.mi.android.demos.spielplan.data;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.ArrayList;

import de.ur.mi.android.demos.spielplan.data.local.Match;

public class MatchDataProvider {

    private final Context context;
    private ArrayList<Match> matchData;

    public MatchDataProvider(Context context) {
        this.context = context;
    }

    public void getDataForMatchday(MatchDay matchDay, DataListener listener) {
        if (matchData == null) {
            updateMatchData(new APIRequest.ResponseListener() {
                @Override
                public void onResponse(String response) {
                    matchData = buildMatchDataFromJSONString(response);
                    listener.onDataAvailable(getMatchesForMatchDay(matchDay));
                }

                @Override
                public void onError() {

                }
            });
        } else {
            listener.onDataAvailable(getMatchesForMatchDay(matchDay));
        }
    }

    private ArrayList<Match> getMatchesForMatchDay(MatchDay matchDay) {
        ArrayList<Match> matcheForThisDay = new ArrayList<>();
        for (Match match : matchData) {
            if (match.matchDateTime.toLocalDate().equals(matchDay.date)) {
                matcheForThisDay.add(match);
            }
        }

        return matcheForThisDay;
    }

    private void updateMatchData(APIRequest.ResponseListener listener) {
        APIRequest request = new APIRequest(context, APIRequest.Route.MATCH_DATA);
        request.send(listener);
    }

    private ArrayList<Match> buildMatchDataFromJSONString(String jsonString) {
        ArrayList<Match> matchData = new ArrayList<>();
        try {
            JSONArray jsonMatches = new JSONArray(jsonString);
            for (int i = 0; i < jsonMatches.length(); i++) {
                JSONObject jsonMatch = jsonMatches.getJSONObject(i);
                Match match = (new Match.MatchBuilder()).fromJSONObject(jsonMatch);
                matchData.add(match);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return matchData;
    }

    public enum MatchDay {
        FIRST("2021-06-11", "Erster Spieltag"),
        SECOND("2021-06-12", "Zweiter Spieltag"),
        THIRD("2021-06-13", "Dritter Spieltag"),
        FOURTH("2021-06-14", "Vierter Spieltag"),
        FIFTH("2021-06-15", "Fünfter Spieltag");

        public final LocalDate date;
        public final String label;

        MatchDay(String dateAsString, String label) {
            this.date = LocalDate.parse(dateAsString);
            this.label = label;
        }

        public MatchDay next() {
            if (this.ordinal() == MatchDay.values().length - 1) {
                return MatchDay.FIRST;
            }
            return MatchDay.values()[this.ordinal() + 1];
        }

        public MatchDay previous() {
            if (this.ordinal() == 0) {
                return MatchDay.FIFTH;
            } else {
                return MatchDay.values()[this.ordinal() - 1];
            }
        }
    }

    public interface DataListener {
        void onDataAvailable(ArrayList<Match> data);
    }
}

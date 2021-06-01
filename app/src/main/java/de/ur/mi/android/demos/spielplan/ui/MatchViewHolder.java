package de.ur.mi.android.demos.spielplan.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.ur.mi.android.demos.spielplan.R;
import de.ur.mi.android.demos.spielplan.data.local.Match;
import de.ur.mi.android.demos.spielplan.utils.DataFormatter;

public class MatchViewHolder extends RecyclerView.ViewHolder {

    public final View matchView;
    private final TextView matchDayText;
    private final TextView matchResultText;
    private final TextView matchLocationText;
    private final TextView teamNamesText;
    private final TextView teamOneText;
    private final TextView teamTwoText;

    public MatchViewHolder(@NonNull View matchView) {
        super(matchView);
        this.matchView = matchView;
        matchDayText = matchView.findViewById(R.id.text_match_day);
        matchResultText = matchView.findViewById(R.id.text_result);
        matchLocationText = matchView.findViewById(R.id.text_location);
        teamNamesText = matchView.findViewById(R.id.text_team_names);
        teamOneText = matchView.findViewById(R.id.text_team_one_short);
        teamTwoText = matchView.findViewById(R.id.text_team_two_short);
    }

    public void bindView(Match match, Context context) {
        matchDayText.setText(DataFormatter.createDateStringForUI(match.matchDateTime));
        teamNamesText.setText(String.format(context.getString(R.string.match_team_names_de), match.teamOne.teamName, match.teamTwo.teamName));
        matchResultText.setText(String.format(context.getString(R.string.match_result), 0, 0));
        matchLocationText.setText(String.format(context.getString(R.string.match_location), match.location.stadium, match.location.city));
        teamOneText.setText(match.teamOne.shortName);
        teamTwoText.setText(match.teamTwo.shortName);
    }


}

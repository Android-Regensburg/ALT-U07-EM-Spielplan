package de.ur.mi.android.demos.spielplan.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.ur.mi.android.demos.spielplan.R;
import de.ur.mi.android.demos.spielplan.data.local.Match;

/**
 * Dieser ViewHolder stellt einen einzelnen Eintrag im RecyclerView dar.
 */
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

    /**
     * Mit dieser Methode werden die Inhalte des ViewHolder angepasst, um die Werte aus dem übergebenen
     * Match-Objekt anzuzeigen.
     */
    public void bindView(Match match, Context context) {
        // TODO Ergänzung: Übertragen Sie hier die Eigenschaften des übergebenen Match-Objektes in die
        //  vorbereiteten TextViews des ViewHolders.
        // z.B.: teamOneText.setText(match.teamOne.teamName);
    }


}

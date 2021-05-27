package de.ur.mi.android.demos.spielplan.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.ur.mi.android.demos.spielplan.R;
import de.ur.mi.android.demos.spielplan.data.local.Match;

/**
 * Dieser Adapter ermöglicht es angeschlossenen RecyclerViews, Objekte vom Typ Match darzustellen.
 * Der Adapter führt dazu eine ArrayListe, in der die Spiele des aktuell darzustellenden Spieltags
 * gespeichert sind. Zur Darstellung einzelner Spiele wird ein ViewHolder verwendet, der das eigentliche
 * "Binding" der Match-Objekte an einen View durchführt.
 */
public class MatchListRecyclerAdapter extends RecyclerView.Adapter<MatchViewHolder> {

    private final Context context;
    private ArrayList<Match> currentMatches;

    public MatchListRecyclerAdapter(Context context) {
        this.context = context;
        this.currentMatches = new ArrayList<>();
    }

    /**
     * Mit dieser Methode wird dem Adapter ein neues Set an Spielen übergeben (die zu einem gemeinsamen
     * Spieltag gehören). Der Adapter informiert den angeschlossenen RecyclerView über die aktualisierten
     * Daten.
     */
    public void setMatches(ArrayList<Match> matches) {
        this.currentMatches = matches;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Erstellt einen neuen ViewHolder auf Basis des via XML-Datei vordefinierten Layouts
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_match_item, parent, false);
        return new MatchViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder holder, int position) {
        Match match = currentMatches.get(position);
        holder.bindView(match, context);
    }

    @Override
    public int getItemCount() {
        return currentMatches.size();
    }
}

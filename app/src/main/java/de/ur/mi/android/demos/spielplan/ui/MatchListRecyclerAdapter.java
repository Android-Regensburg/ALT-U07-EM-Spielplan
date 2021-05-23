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

public class MatchListRecyclerAdapter extends RecyclerView.Adapter<MatchViewHolder> {

    private final Context context;
    private ArrayList<Match> currentMatches;


    public MatchListRecyclerAdapter(Context context) {
        this.context = context;
        this.currentMatches = new ArrayList<>();
    }

    public void setMatches(ArrayList<Match> matches) {
        this.currentMatches = matches;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
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

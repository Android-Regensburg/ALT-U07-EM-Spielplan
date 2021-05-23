package de.ur.mi.android.demos.spielplan;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.ur.mi.android.demos.spielplan.data.MatchDataProvider;
import de.ur.mi.android.demos.spielplan.data.local.Match;
import de.ur.mi.android.demos.spielplan.data.utils.DataFormatter;
import de.ur.mi.android.demos.spielplan.ui.MatchListRecyclerAdapter;

public class MainActivity extends AppCompatActivity {

    private MatchDataProvider dataProvider;
    private MatchListRecyclerAdapter dataAdapter;
    private MatchDataProvider.MatchDay selectedMatchDay;
    private TextView matchDayTitle;
    private TextView matchDayDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
        initData();
    }

    private void initUI() {
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.match_list);
        dataAdapter = new MatchListRecyclerAdapter(getApplicationContext());
        recyclerView.setAdapter(dataAdapter);
        matchDayTitle = findViewById(R.id.match_day_title);
        matchDayDate = findViewById(R.id.match_day_subtitle);
        ImageButton selectPreviousMatchDayButton = findViewById(R.id.view_button_previous_match_day);
        ImageButton selectNextMatchDayButton = findViewById(R.id.view_button_next_match_day);
        selectPreviousMatchDayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMatchDataFor(selectedMatchDay.previous());
            }
        });
        selectNextMatchDayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMatchDataFor(selectedMatchDay.next());
            }
        });
    }

    private void initData() {
        dataProvider = new MatchDataProvider(getApplicationContext());
        setMatchDataFor(MatchDataProvider.MatchDay.FIRST);
    }

    private void setMatchDataFor(MatchDataProvider.MatchDay matchDay) {
        selectedMatchDay = matchDay;
        dataProvider.getDataForMatchday(matchDay, new MatchDataProvider.DataListener() {
            @Override
            public void onDataAvailable(ArrayList<Match> data) {
                renderMatchDayData(matchDay, data);
            }
        });
    }

    private void renderMatchDayData(MatchDataProvider.MatchDay matchDay, ArrayList<Match> matches) {
        matchDayTitle.setText(matchDay.label);
        matchDayDate.setText(DataFormatter.createDateStringForUI(matchDay.date));
        dataAdapter.setMatches(matches);
    }


}
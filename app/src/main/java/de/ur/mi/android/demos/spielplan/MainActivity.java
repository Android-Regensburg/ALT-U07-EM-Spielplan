package de.ur.mi.android.demos.spielplan;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.ur.mi.android.demos.spielplan.data.local.Match;
import de.ur.mi.android.demos.spielplan.ui.MatchListRecyclerAdapter;

/**
 * In dieser Aufgabe implementieren Sie eine App, die den Spielplan der kommenden Europameisterschaft
 * anzeigt. Das UI zur Anzeige der Spiele ist vorgegeben. Ihre Aufgabe ist das Integrieren der via
 * HTTP-API bezogenen Daten in die Anwendung.
 * <p>
 * TODO Aufgabe: Vervollständigen Sie die Match-Klasse, um Spiel zu repäsentieren (ggf. mit weiteren Klassen)
 * TODO Aufgabe: Laden Sie via Volley den JSON-formatierten Spielplan herunter (https://em.software-engineering.education/api/getmatchdata/em20/)
 * TODO Aufgabe: Überführen Sie die JSON-Daten in konkrete Java-Obnjekte auf Basis der vorbereiteten Klassen (z.B. Match)
 * TODO Aufgabe: Schaffen Sie eine Möglichkeit, Spiele eines bestimmten Spieltags auszuwählen
 * TODO Aufgabe: Vervollständigen Sie die bindView-Methode im ViewHolder
 * TODO Aufgabe: Integrieren Sie die Daten an geeigneter Stelle in die App, in dem Sie die ArrayList im Adapter passend aktualisieren
 */
public class MainActivity extends AppCompatActivity {

    private MatchListRecyclerAdapter dataAdapter;
    private TextView matchDayTitle;
    private TextView matchDayDate;
    // TODO Ergänzung: Merken Sie sich in einer Instanzvariable, welcher Spieltag aktuell angezeigt wird

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
        initData();
    }

    /**
     * Das User Interface der Anwendung wird beim Start vollständig initialisiert. Bis auf eine Methode
     * im ViewHolder müssen Sie keine Änderungen am vorgegebenen Code vornehmen. Sie können sich vollständig
     * auf die Implementierung der Datenschicht der Anwendung konzentrieren.
     */
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
                // TODO Ergänzung: Erfragen Sie die Spieldaten des vorherigen Spieltags vom MatchDataProvider
                //  und zeigen Sie diese im UI an.
            }
        });
        selectNextMatchDayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Ergänzung: Erfragen Sie die Spieldaten des nöchsten Spieltags vom MatchDataProvider
                //  und zeigen Sie diese im UI an.
            }
        });
    }

    // TODO Ergänzung: Nutzen Sie diese Funktion, um den MatchDataProvider zu initialiseren, die Spieldaten vom
    //  Server zu erfragen und im Anschluss die Informationen zum ersten Spieltag im UI anzuzeigen.
    private void initData() {

    }

    /**
     * Diese Funktion aktualisiert die anzuzeigenden Match-Daten im Adpater und trägt zusätzlich
     * Titel und Datum des aktuellen Spieltags im UI der Activity ein.
     *
     * @param matchDayTitleText
     * @param matchDayDateText
     * @param matches
     */
    private void renderMatchDayData(String matchDayTitleText, String matchDayDateText, ArrayList<Match> matches) {
        matchDayTitle.setText(matchDayTitleText);
        matchDayDate.setText(matchDayDateText);
        dataAdapter.setMatches(matches);
    }


}
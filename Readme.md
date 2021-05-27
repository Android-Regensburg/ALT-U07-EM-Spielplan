# U07 | EM-Spielplan

## Aufgabe

In knapp zwei Wochen startet die [Fußballeuropameisterschaft 2021](https://de.wikipedia.org/wiki/Fu%C3%9Fball-Europameisterschaft_2021) (_Euro 2020_). In dieser Aufgabe implementieren Sie eine App, die den Spielplan des Turniers anzeigt. Die Daten zu den einzelnen Spielen werden dabei von einer externen Quelle bezogen und via HTTP-Anfrage in die Anwendung integriert. Das _User Interface_ der Anwendung haben wir für Sie vorbereitet. Ihre Aufgabe ist das Implementieren der Datenanfrage und das Integrieren und Anzeigen der vom Server erhaltenen Informationen in die bzw. der Anwendung.

### Daten

Über die URL `https://em.software-engineering.education/api/getmatchdata/em20` können Sie eine JSON-formatierte Übersicht über die Spiele der Gruppenphase herunterladen. Das Ergebniss ist ein _Array_ aus Spielen, die alle diesem Aufbau folgen:

``` json
{
"MatchID":59958,
"MatchDateTime":"2021-06-11T21:00:00",
"TimeZoneID":"W. Europe Standard Time",
"LeagueId":4457,
"LeagueName":"UEFA EURO 2020",
"MatchDateTimeUTC":"2021-06-11T19:00:00Z",
"Group":{
 "GroupName":"1. Runde Gruppenphase",
 "GroupOrderID":1,
 "GroupID":36890
},
"Team1":{
"TeamId":3205,
"TeamName":"Türkei",
"ShortName":"TUR",
"TeamIconUrl":"https://upload.wikimedia.org/wikipedia/commons/thumb/b/b4/Flag_of_Turkey.svg/2000px-Flag_of_Turkey.svg.png",
"TeamGroupName":"Gruppe A"
},
"Team2":{
"TeamId":3203,
"TeamName":"Italien",
"ShortName":"ITA",
"TeamIconUrl":"https://upload.wikimedia.org/wikipedia/en/0/03/Flag_of_Italy.svg",
"TeamGroupName":"Gruppe A"
},
"LastUpdateDateTime":"2020-11-17T12:39:27.657",
"MatchIsFinished":false,
"MatchResults":[],
"Goals":[],
"Location":{
"LocationID":378,
"LocationCity":"Rom",
"LocationStadium":"Stadio Olimpico"},
"NumberOfViewers":null},
```

Diese Daten stammen von der Webseite [openligadb.de](https://www.openligadb.de/). Wir haben diese auf unseren eigenen Server kopiert, um die offizielle API nicht durch zu viele Anfragen zu belasten. Der Zugriff bzw. der Aufbau der URL folgt aber dem gleichen Prinzip, das auch bei der Verwendung der offiziellen API benötigt werden würde. D.h., wenn Sie Ihre Lösung auch während der EM nutzen wollen, können Sie einfach zu openligadb wechseln, in dem Sie im Code nur die verwendet URL austauschen. **Beachten Sie bitte, dass die Daten noch nicht vollständig sind. Es liegen nur die Spiel für den ersten Spieltag der Gruppenphase vor.** In unserer App verstehen wir unter dem Begriff Spieltag daher erst einmal einen individuellen Tag, an dem Spiel statt finden.

## Algemeine Hinweise

* Verwenden Sie für die Anfragen an den Server das _Volley_-Framework, das [hier](https://developer.android.com/training/volley) näher beschrieben wird
* Die JSON-formatierte Antwort des Servers können Sie über die Funktionalitäten der Klassen [`JSONArray`](https://developer.android.com/reference/org/json/JSONArray) und [`JSONObject`](https://developer.android.com/reference/org/json/JSONObject) verarbeiten und in eigene Objekte überführen.
* Große Teile des UIs bzw. der zugehörigen Klassen sind vorgegeben. Stellen, an denen Sie i späteren Verlauf eigenen Code ergänzen müssen, sind entsprechend gekennzeichnet. Generell sind alle notwendigen Schritte grob als [TODO-Kommentare](https://www.jetbrains.com/help/idea/using-todo.html) im Code festgehalten.

## Vorgehen
### Darstellung der EM-Spiele.  
Zunächst sollten die Cardviews korrekt befüllt werden. Dazu empfiehlt es sich die entsprechenden Klassen wie `Location`, `Team` und `Match` so zu modellieren, dass am Ende alle notwendigen Informationen am Ende in der Cardview einzusehen ist (siehe Screenshot).
Bevor allerdings die Ausgabe funktioniert, sollten in `MatchViewHolder` die Methode `bindView`noch ergänzt werden, da die Texte dort vorerst durch "Placeholder" ersetzt wurden.

### Abfrage der Bundesligadaten von gegebender URL
Im zweiten Teil der Aufgabe sollen nun die Bundesligadaten aus der Onlinequelle bezogen werden.

Für den Zugriff Ihrer Anwendung auf das Internet ist eine entsprechende Berechtigung erforderlich. Überprüfen Sie das `Manifest` der Anwendung und beantragen Sie dort gegebenenfalls die (aus der Vorlesung bekannte) benötigte Berechtigung.

Zu Lesen ist die Dokumentation von Volley, damit die Klasse `APIRequest` für eine einfache Anfrage an oben genannte URL eingerichtet werden kann. `MatchDataProvider` kann mit dieser entsprechende Machtes zusammenstellen. Die sogemannten "..."-Builder-Klassen in `Location`, `Team` und `Match`(z.B. LocationBuilder) sind an der Stelle dafür mit einer entprechenden Methode für das Verarbeiten des JSON-Strings zuständig.

## Screenshots der Anwendung

![Screenshots der Laufapp](./docs/screenshots.png)

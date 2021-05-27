# U08 | EM-Spielplan

## Aufgabe

Das Ziel dieser Aufgabe ist die Implementierung einer App zur Darstellung (aktueller) EM Matches. Um bereits bekannte Konzepte, wie die Darstellung von Informationen in einem RecyclerView mit Adapter und ein Card-Layout für die Einträge, mit den neu erlernten Konzepten der Netzwerkprogrammierung zu verknüpfen, werden die Daten über die Fußball-Europameisterschaft über eine HTTP-Anfrage (mit Volley) bezogen und über Parsing von JSON-Strings in eine Objektstruktur übertragen.

## Hinweise

* Link zu den gefragten Spielplänen: https://em.software-engineering.education/api/getmatchdata/em20/
* Über die eine APIRequest mit Volley wird man hier fündig: https://developer.android.com/training/volley
* Die Schwerpunkte sind das Verarbeiten und Erhalten eines JSON-Strings und das vollständige Modellieren von notwendigen einzelnen Java-Klassen (Match, Team, usw.) Es wird auch empfohlen die Provider-Klasse zu nutzen um die richtigen Spiele für die korrekten Tage zu erhalten
* Zum Verarbeiten Verarbeiten von `JSON`-Strings:
  * `JSONArray`: https://developer.android.com/reference/org/json/JSONArray
  * `JSONObject`: https://developer.android.com/reference/org/json/JSONObject

## Ausgangslage
* Alle notwendigen UI-Elemente wie z.B. der RecyclerView sind bereits vorhanden und müssen nur befüllt werden
* Alle benötigten Klassen sind bereits erstellt. In einigen Fällen wurden zwar bereits Ansätze eines groben Grundgerüsts umgesetzt, jedoch ist keine der Klassen vollständig implementiert.

## Vorgehen
### Darstellung der EM-Spiele.  
Zunächst sollten die Cardviews korrekt befüllt werden. Dazu empfiehlt es sich die entsprechenden Klassen wie `Location`, `Team` und `Match` so zu modellieren, dass alle notwendigen Informationen am Ende in der Cardview einzusehen ist (siehe Screenshot).

### Abfrage der Bundesligadaten von gegebender URL
Im zweiten Teil der Aufgabe sollen nun die Bundesligadaten aus der Onlinequelle bezogen werden.

Für den Zugriff Ihrer Anwendung auf das Internet ist eine entsprechende Berechtigung erforderlich. Überprüfen Sie das `Manifest` der Anwendung und beantragen Sie dort gegebenenfalls die (aus der Vorlesung bekannte) benötigte Berechtigung.

Zu Lesen ist die Dokumentation von Volley, damit die Klasse `APIRequest` für eine einfache Anfrage an oben genannte URL eingerichtet werden kann. `MatchDataProvider` kann mit dieser entsprechende Machtes zusammenstellen. Die sogemannten "..."-Builder-Klassen in `Location`, `Team` und `Match`(z.B. LocationBuilder) sind an der Stelle dafür mit einer entprechenden Methode für das Verarbeiten des JSON-Strings zuständig.

## Screenshots der Anwendung

![Screenshots der Laufapp](./docs/screenshots.png)

# IU-Ghostnets

Projektrepository für das Modul **Programmierung von industriellen Informationssystemen mit Java EE (IPWA02-01)**.

## 📋 Projektbeschreibung

Ziel dieser Webanwendung ist es der Non-Profit-Organisation **Shea Sepherd** das Bergen von **Geisternetzen** zu vereinfachen. Freiwillige sollen Geisternetze unter Angabe ihrer Position und Koordinaten (anonym) melden können. Anschließend sollen registrierte Benutzer der Anwendung in der Lage sein die gemeldeten Netze bergen zu können.

## 🌐 Live-Demo

Die Live-Demo wird, im Gegensatz zur Entwicklungsumgebung, in einem Tomcat Docker-Container ausgeführt. Leider funktioniert dort der DatePicker auf der "Geisternetz Melden"-Seite nicht wie erwartet. In der Entwicklungsumgebung unter Windows gab es keine Probleme. Der Fehler konnte bisher nicht behoben werden.

[**Zur Live-Demo**](https://ghostnets.filser.io) 

- **Nutzer:** `demo`  
- **Passwort:** `demo`  

## 🛠️ Technologien

- **JavaServer Faces:** Enterprise Java-Umgebung für die Entwicklung von Webanwendungen.
- **Maven:** Build-Management-Tool zur Verwaltung von Abhängigkeiten.
- **Tomcat:** Docker-Container zum Bereitstellen der Anwendung.
- **PrimeFaces:** Komponentenbibliothek für JavaServer Faces.
- **Hibernate:** Framework, welches die persistente Speicherung von Java-Objekten vereinfacht.
- **MariaDB:** SQL Datenbankmanagementsystem.
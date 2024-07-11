Um ein umfassendes Anwendungsfalldiagramm gemäß den beschriebenen Kriterien zu erstellen, müssen wir zuerst alle Akteure und deren Anforderungen erfassen. Danach können wir die Relationen zwischen Akteuren und Anforderungen visualisieren.

### Anwendungsfalldiagramm Beschreibung

#### Systemkontext und Titel:
**Systemtitel:** Coworking Space Management System

#### Akteure:
1. **Administrator**
2. **Mitglied**
3. **Besucher (nicht authentifizierter Benutzer)**

#### Funktionale Anforderungen:
1. **Besucher:**
   - Registrierung (Vorname, Nachname, E-Mail, Passwort)
   - Anmeldung (E-Mail, Passwort)
   
2. **Mitglied:**
   - Buchung von halben und ganzen Tagen
   - Überprüfung des Buchungsstatus
   - Stornierung zukünftiger Buchungen
   
3. **Administrator:**
   - Mitgliederverwaltung (erstellen, bearbeiten, löschen)
   - Buchungsanfragen akzeptieren/ablehnen
   - Buchungen verwalten (erstellen, bearbeiten, löschen)

#### Zusätzliche Funktionale Anforderungen:
1. **Mitglied:**
   - Bearbeitung persönlicher Daten (Vorname, Nachname, E-Mail, Passwort)
   - Zugriff auf Rechnungen und Zahlungsinformationen
   - Teilnahme an Events und Workshops buchen

#### Zusätzliche Nicht-funktionale Anforderungen:
1. **Sicherheitsanforderungen:**
   - Datenspeicherung nach neuesten Sicherheitsstandards
   - Zugriffskontrollen und Rechteverwaltung
   - Datenverschlüsselung bei Übertragung und Speicherung

### Anwendungsfalldiagramm erstellen

Hier ist das Anwendungsfalldiagramm in Textform, welches dann grafisch in UML 2.0 umgesetzt werden kann:

#### Anwendungsfälle:
1. **Registrieren** (Besucher)
2. **Anmelden** (Besucher)
3. **Buchung anfragen** (Mitglied)
4. **Buchungsstatus überprüfen** (Mitglied)
5. **Buchung stornieren** (Mitglied)
6. **Mitglieder verwalten** (Administrator)
7. **Buchungsanfragen bearbeiten** (Administrator)
8. **Buchungen verwalten** (Administrator)
9. **Persönliche Daten bearbeiten** (Mitglied)
10. **Rechnungen anzeigen** (Mitglied)
11. **Eventbuchung** (Mitglied)

#### Relationen:
- Besucher -> Registrieren
- Besucher -> Anmelden
- Mitglied -> Anmelden
- Mitglied -> Buchung anfragen
- Mitglied -> Buchungsstatus überprüfen
- Mitglied -> Buchung stornieren
- Mitglied -> Persönliche Daten bearbeiten
- Mitglied -> Rechnungen anzeigen
- Mitglied -> Eventbuchung
- Administrator -> Mitglieder verwalten
- Administrator -> Buchungsanfragen bearbeiten
- Administrator -> Buchungen verwalten


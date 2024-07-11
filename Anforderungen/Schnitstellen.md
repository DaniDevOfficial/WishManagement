### Schnittstellenplanung

Die Angaben der Variabeln in den Schnittstellen und was manche bedeuten können im Klassendiagramm eingesehen werden.

#### REST API Endpunkte

1. **Registrierung eines Besuchers**
   - **Pfad**: `/api/register`
   - **HTTP-Verben**: `POST`
   - **Beschreibung**: Registriert einen neuen Benutzer als Besucher.
   - **Parameter**: 
     - Body: 
       ```json
       {
         "vorname": "string",
         "nachname": "string",
         "email": "string",
         "passwort": "string"
       }
       ```
   - **Antworten**:
     - **201 Created**: Benutzer erfolgreich registriert.
     - **400 Bad Request**: Fehlende oder ungültige Eingabedaten.

2. **Anmeldung eines Benutzers**
   - **Pfad**: `/api/login`
   - **HTTP-Verben**: `POST`
   - **Beschreibung**: Authentifiziert einen Benutzer und gibt ein JWT zurück (gibt auch gerade Rolle an User).
   - **Parameter**:
     - Body:
       ```json
       {
         "email": "string",
         "passwort": "string"
       }
       ```
   - **Antworten**:
     - **200 OK**: Erfolgreiche Authentifizierung, JWT wird zurückgegeben.
     - **401 Unauthorized**: Ungültige Anmeldeinformationen.

3. **Buchung anfragen (Mitglied)**
   - **Pfad**: `/api/bookings`
   - **HTTP-Verben**: `POST`
   - **Beschreibung**: Ein Mitglied fragt eine Buchung für halbe oder ganze Tage an.
   - **Parameter**:
     - Header: `Autorisierung  mit JWT`
     - Body:
       ```json
       {
         "datum": Date,
         "mietZeit": MietZeit<enum>,
         "raumId": Long
       }
       ```
   - **Antworten**:
     - **201 Created**: Buchungsanfrage erfolgreich erstellt.
     - **400 Bad Request**: Fehlende oder ungültige Eingabedaten.
     - **401 Unauthorized**: Fehlende oder ungültige Authentifizierung.

4. **Buchung überprüfen (Mitglied)**
   - **Pfad**: `/api/bookings/{buchungId}`
   - **HTTP-Verben**: `GET`
   - **Beschreibung**: Überprüft eine Buchung.
   - **Parameter**:
     - Header: `Autorisierung  mit JWT`
     - Pfad: `{buchungId}`
   - **Antworten**:
     - **200 OK**: Buchungsstatus erfolgreich abgerufen.
     - **404 Not Found**: Buchung nicht gefunden.
     - **401 Unauthorized**: Fehlende oder ungültige Authentifizierung.

5. **Zukünftige Buchungen stornieren (Mitglied)**
   - **Pfad**: `/api/bookings/stornieren`
   - **HTTP-Verben**: `PUT`
   - **Beschreibung**: Setzt den Status einer zukünftigen Buchung auf "storniert".
   - **Parameter**:
     - Header: `Autorisierung  mit JWT`
     - Body:  
       ```json
       {
            "buchungsId": Long
       }
       ```
   - **Antworten**:
     - **200 OK**: Buchung erfolgreich storniert.
     - **404 Not Found**: Buchung nicht gefunden.
     - **401 Unauthorized**: Fehlende oder ungültige Authentifizierung.

6. **Mitglieder verwalten (Administrator)**
   - **Pfad**: `/api/users`
   - **HTTP-Verben**: `GET`, `POST`, `PUT`, `DELETE`
   - **Beschreibung**: Verwaltung der Mitglieder.
   - **Parameter**:
     - Header: `Autorisierung  mit JWT`
     - GET: 
       - Pfad: `/api/users/{userId}`
     - POST:
       ```json
       {
         "vorname": "string",
         "nachname": "string",
         "email": "string",
         "passwort": "string",
         "rollenId": rollenId (Admin oder Mitglied)
       }
       ```
     - PUT:
       ```json
       {
         "userId": Long,
         "vorname": "string",
         "nachname": "string",
         "email": "string",
         "passwort": "string",
         "rollenId": rollenId (Admin oder Mitglied)
       }
       ```
     - DELETE:
       - Pfad: `/api/users/{userId}`
   - **Antworten**:
     - **200 OK**: Anfragen erfolgreich durchgeführt.
     - **201 Created**: Benutzer erfolgreich erstellt (für POST).
     - **404 Not Found**: Benutzer nicht gefunden.
     - **400 Bad Request**: Fehlende oder ungültige Eingabedaten.
     - **401 Unauthorized**: Fehlende oder ungültige Authentifizierung.

7. **Buchungsanfragen akzeptieren/ablehnen (Administrator)**
   - **Pfad**: `/api/bookings/{buchungId}/status`
   - **HTTP-Verben**: `PUT`
   - **Beschreibung**: Akzeptiert oder lehnt eine Buchungsanfrage ab.
   - **Parameter**:
     - Header: `Autorisierung  mit JWT`
     - Pfad: `{buchungId}`
     - Body:
       ```json
       {
         "status": "bestätigt" | "abgelehnt"
       }
       ```
   - **Antworten**:
     - **200 OK**: Buchungsstatus erfolgreich aktualisiert.
     - **404 Not Found**: Buchung nicht gefunden.
     - **400 Bad Request**: Fehlende oder ungültige Eingabedaten.
     - **401 Unauthorized**: Fehlende oder ungültige Authentifizierung.

8. **Buchungen verwalten (Administrator)**
   - **Pfad**: `/api/bookings`
   - **HTTP-Verben**: `GET`, `POST`, `PUT`, `DELETE`
   - **Beschreibung**: Verwalten der Buchungen.
   - **Parameter**:
     - Header: `Autorisierung  mit JWT`
     - GET: 
       - Pfad: `/api/bookings/{buchungId}` (Optional, für spezifische Buchung)
     - POST:
       ```json
       {
         "userId": Long,
         "datum": Date,
         "mietZeit": MietZeit<enum>,
         "raumId": Long,
         "status": Status
       }
       ```
     - PUT:
       ```json
       {
         "buchungId": Long,
         "datum": Date,
         "mietZeit": MietZeit<enum>,
         "raumId": Long,
         "status": "angefragt" | "bestätigt" | "abgelehnt"
       }
       ```
     - DELETE:
       - Pfad: `/api/bookings/{buchungId}`
   - **Antworten**:
     - **200 OK**: Anfragen erfolgreich durchgeführt.
     - **201 Created**: Buchung erfolgreich erstellt (für POST).
     - **404 Not Found**: Buchung nicht gefunden.
     - **400 Bad Request**: Fehlende oder ungültige Eingabedaten.
     - **401 Unauthorized**: Fehlende oder ungültige Authentifizierung.



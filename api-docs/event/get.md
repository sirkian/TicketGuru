# Näytä kaikki tapahtumat

**URL**: `/events`

**Metodi**: `GET`

**Vaadittu rooli**: -

## Vastauksen paluukoodit

**Koodit**:

`200 OK`

_Jos tapahtumia ei ole, API palauttaa tyhjän taulukon koodilla 200 OK_

## Esimerkkivastaus:

**Polku**: `BASE_URL/events`

```json
[
  {
    "eventId": 1,
    "eventName": "Testitapahtuma",
    "description": "Tapahtuman kuvaus",
    "startTime": "2023-02-14T16:00:00",
    "endTime": "2023-02-14T18:00:00",
    "amountTickets": 100,
    "presaleEnds": "2023-02-12T18:00:00",
    "cancelled": false,
    "venue": {
      "venueId": 1,
      "venueName": "tapahtumapaikka1",
      "venueDescription": "pieni paikka",
      "address": "Maitokatu 1",
      "postalCode": {
        "postalCode": "00100",
        "city": "Helsinki"
      }
    }
  },
  {
    "eventId": 2,
    "eventName": "Tapahtuma 2",
    "description": "Kuvaus kakkostapahtumalle",
    "startTime": "2023-04-20T20:30:00",
    "endTime": "2023-04-20T22:00:00",
    "amountTickets": 200,
    "presaleEnds": "2023-04-19T18:00:00",
    "cancelled": false,
    "venue": {
      "venueId": 2,
      "venueName": "tapahtumapaikka2",
      "venueDescription": "iso paikka",
      "address": "Piimätie 34",
      "postalCode": {
        "postalCode": "33101",
        "city": "Tampere 10"
      }
    }
  }
]
```

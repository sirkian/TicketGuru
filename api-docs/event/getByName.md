# Näytä tapahtumat, joissa hakusana vastaa eventNamea

Palauttaa kaikki tapahtumat, joiden nimi sisältää hakusanana käytetyn merkkijonon kirjainkoosta välittämättä.

Palauttaa tyhjän listan koodilla 200 OK, mikäli hakusanalla ei löydy yhtäkään tapahtumaa.

**URL**: `/events/q?name=:hakusana`

**Metodi**: `GET`

## Vastauksen paluukoodi

**Koodit**: 

`200 OK`

## Esimerkkivastaus:

**Polku**: `BASE_URL/events/q?name=testi`

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
  }
]
```

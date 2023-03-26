# Lisää uusi tapahtuma

**URL**: `/events`

**Metodi**: `POST`

**Vaadittu rooli**: Admin

## Vastauksen paluukoodit

**Koodit**:

`201 CREATED`

`400 BAD REQUEST`

> `"message": "Validation failed for object='event'. Error count: n"`

## Esimerkkipyyntö:

**Polku**: `BASE_URL/events`

```json
{
  "eventName": "Uusi tapahtuma",
  "description": "Uuden tapahtuman kuvaus",
  "startTime": "2023-02-14T16:00:00",
  "endTime": "2023-02-14T18:00:00",
  "amountTickets": 1500,
  "presaleEnds": "2023-02-12T18:00:00",
  "cancelled": false,
  "venue": {
    "venueId": 1
  }
}
```

## Esimerkkivastaus:

```json
{
  "eventId": 4,
  "eventName": "Uusi tapahtuma",
  "description": "Uden tapahtuman kuvaus",
  "startTime": "2023-02-14T16:00:00",
  "endTime": "2023-02-14T18:00:00",
  "amountTickets": 1500,
  "presaleEnds": "2023-02-12T18:00:00",
  "cancelled": false,
  "venue": {
    "venueId": 1,
    "venueName": null,
    "venueDescription": null,
    "address": null,
    "postalCode": null
  }
}
```

joka GET:illä haun jälkeen päivittyy jälkeen päivittyy:

```json
{
  "eventId": 4,
  "eventName": "Uusi tapahtuma",
  "description": "Uden tapahtuman kuvaus",
  "startTime": "2023-02-14T16:00:00",
  "endTime": "2023-02-14T18:00:00",
  "amountTickets": 1500,
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
```

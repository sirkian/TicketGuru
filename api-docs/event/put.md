# Muokkaa id:llä haettua tapahtumaa

**URL**: `/events/:pk`

**Metodi**: `PUT`

## Vastauksen paluukoodit

**Koodit**:

`200 OK`

`400 BAD REQUEST`

> `"message": "Validation failed for object='event'. Error count: n"`

`404 NOT FOUND`

> `"message": "Annetulla id:llä ei ole olemassa tapahtumaa"`

## Esimerkkipyyntö:

**Polku**: `BASE_URL/events/1`

```json
{
  "eventName": "Testimuokkaus",
  "description": "Muokattu tapahtuman kuvaus",
  "startTime": "2023-02-14T16:00:00",
  "endTime": "2023-02-14T18:00:00",
  "amountTickets": 600,
  "presaleEnds": "2023-02-12T18:00:00",
  "cancelled": false,
  "venue": {
    "venueId": 2
  }
}
```

## Esimerkkivastaus:

```json
{
  "eventId": 1,
  "eventName": "Testimuokkaus",
  "description": "Muokattu tapahtuman kuvaus",
  "startTime": "2023-02-14T16:00:00",
  "endTime": "2023-02-14T18:00:00",
  "amountTickets": 600,
  "presaleEnds": "2023-02-12T18:00:00",
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
```

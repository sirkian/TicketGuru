# Näytä yhden tapahtuman lipputyypit

**URL**: `/events/:pk/eventtickettypes` , jossa pk on eventId.

**Metodi**: `GET`

**Vaadittu rooli**: -

## Vastauksen paluukoodit

**Koodit**:

`200 OK`

`404 NOT FOUND`

> `"message": "Tapahtumaa ei ole olemassa"`

## Esimerkkivastaus:

**Polku**: `BASE_URL/events/1/eventtickettypes`

```json
[
  {
    "eventTypeId": 1,
    "price": 15.0,
    "event": {
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
    "ticketType": {
      "typeId": 2,
      "typeName": "Eläkeläinen"
    }
  },
  {
    "eventTypeId": 2,
    "price": 10.5,
    "event": {
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
    "ticketType": {
      "typeId": 1,
      "typeName": "Opiskelija-lippu"
    }
  }
]
```

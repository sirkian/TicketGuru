# Näytä kaikkien tapahtumien lipputyypit

**URL**: `/eventtickettypes`

**Metodi**: `GET`

## Vastauksen paluukoodi

**Koodit**: 

`200 OK`

## Esimerkkivastaus:

**Polku**: `BASE_URL/eventtickettypes`

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
  },
  {
    "eventTypeId": 3,
    "price": 11.0,
    "event": {
      "eventId": 3,
      "eventName": "Kolmas tapahtuma toden sanoo",
      "description": "Syvällistä pohdintaa ja runonlausuntaa aiheesta testidatan keksimisen vaikeus",
      "startTime": "2023-04-20T20:30:00",
      "endTime": "2023-04-20T22:00:00",
      "amountTickets": 200,
      "presaleEnds": "2023-04-19T18:00:00",
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

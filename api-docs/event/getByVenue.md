# Näytä tapahtumapaikan kaikki tapahtumat

**URL**: `/venues/:pk/events` , jossa pk on venueId.

**Metodi**: `GET`

**Vaadittu rooli**: Admin tai Myyjä

## Vastauksen paluukoodit

**Koodit**:

`200 OK`

_Jos tapahtumia ei ole, API palauttaa tyhjän taulukon koodilla 200 OK_

`404 NOT FOUND`

> `"message": "Tapahtumapaikkaa ei ole olemassa"`

## Esimerkkivastaus:

**Polku**: `BASE_URL/venues/1/events`

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
  }
]
```

## Huom.

~~Käytännössä samaan lopputulokseen päästään myös polulla `venues/1/events`, jolloin vastaus on mallia:~~

Endpointin polku muutettu, korvaa alla olevan esimerkin.

```json
{
  "_embedded": {
    "events": [
      {
        "eventName": "Testitapahtuma",
        "description": "Tapahtuman kuvaus",
        "startTime": "2023-02-14T16:00:00",
        "endTime": "2023-02-14T18:00:00",
        "amountTickets": 100,
        "presaleEnds": "2023-02-12T18:00:00",
        "cancelled": false,
        "_links": {
          "self": {
            "href": "http://localhost:8080/events/1"
          },
          "event": {
            "href": "http://localhost:8080/events/1"
          },
          "eventTicketTypes": {
            "href": "http://localhost:8080/events/1/eventTicketTypes"
          },
          "venue": {
            "href": "http://localhost:8080/events/1/venue"
          }
        }
      },
      {
        "eventName": "Kolmas tapahtuma toden sanoo",
        "description": "Syvällistä pohdintaa ja runonlausuntaa aiheesta testidatan keksimisen vaikeus",
        "startTime": "2023-04-20T20:30:00",
        "endTime": "2023-04-20T22:00:00",
        "amountTickets": 200,
        "presaleEnds": "2023-04-19T18:00:00",
        "cancelled": false,
        "_links": {
          "self": {
            "href": "http://localhost:8080/events/3"
          },
          "event": {
            "href": "http://localhost:8080/events/3"
          },
          "eventTicketTypes": {
            "href": "http://localhost:8080/events/3/eventTicketTypes"
          },
          "venue": {
            "href": "http://localhost:8080/events/3/venue"
          }
        }
      }
    ]
  },
  "_links": {
    "self": {
      "href": "http://localhost:8080/venues/1/events"
    }
  }
}
```

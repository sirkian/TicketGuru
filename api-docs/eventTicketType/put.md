# Muokkaa tapahtuman lipputyyppiä

**URL**: `/eventtickettypes/:pk`

**Metodi**: `PUT`

## Vastauksen paluukoodit

**Koodit**:

`200 OK`

`404 NOT FOUND`

> `"message": "Tarkista viiteavaimet: Unable to find com.example.TicketGuru.domain.Event with id 5"`

> `"message": "Tapahtuman lipputyyppiä ei löytynyt"`

## Esimerkkipyyntö:

**Polku**: `BASE_URL/eventtickettypes/1`

```json
{
  "event": {
    "eventId": 1
  },
  "ticketType": {
    "typeId": 1
  },
  "price": 25.0
}
```

## Esimerkkivastaus:

```json
{
  "eventTypeId": 1,
  "price": 25.0,
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
```

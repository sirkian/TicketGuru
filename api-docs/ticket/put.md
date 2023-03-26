# Muokkaa id:llä haettua lippua

**URL**: `/tickets/:pk`

**Metodi**: `PUT`

**Vaadittu rooli**: Admin tai Myyjä tai Lipuntarkastaja

## Vastauksen paluukoodi

**Koodit**:

`200 OK`

`400 BAD REQUEST`

`404 NOT FOUND`

> `"message": "Tarkista viiteavaimet: Unable to find com.example.TicketGuru.domain.EventTicketType with id 99"`

## Esimerkkipyyntö:

**Polku**: `BASE_URL/tickets/1`

```json
{
  "usedDate": "2023-03-05T15:43:27.004Z",
  "eventTicketType": { "eventTypeId": 1 },
  "transaction": { "transactionId": 1 }
}
```

## Esimerkkivastaus:

```json
{
  "ticketId": 1,
  "verificationCode": null,
  "usedDate": "2023-03-05",
  "eventTicketType": {
    "eventTypeId": 1,
    "price": 12.5,
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
  "transaction": {
    "transactionId": 1,
    "transactionDate": "2023-03-05T15:43:27.004",
    "appUser": null
  }
}
```

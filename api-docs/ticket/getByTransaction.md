# Hae kaikki myyntitapahtuman liput

**URL**: `/transactions/:pk/tickets` _:pk = transactionId_

**Metodi**: `GET`

## Vastauksen paluukoodit

**Koodit**:

`200 OK`

`404 NOT FOUND`

> `"message": "Myyntitapahtumaa ei ole olemassa"`

> `"message": "Myyntitapahtumalla ei ole lippuja"`

## Esimerkkivastaus:

**Polku**: `BASE_URL/transactions/1/tickets`

```json
[
  {
    "ticketId": 3,
    "verificationCode": null,
    "usedDate": null,
    "eventTicketType": {
      "eventTypeId": 1,
      "price": 12.5,
      "event": {
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
      },
      "ticketType": {
        "typeId": 1,
        "typeName": "Opiskelija-lippu"
      }
    },
    "transaction": {
      "transactionId": 1,
      "transactionDate": "2023-03-10T19:00:09.109437",
      "appUser": null
    }
  },
  {
    "ticketId": 5,
    "verificationCode": "f0bff3ad",
    "usedDate": null,
    "eventTicketType": {
      "eventTypeId": 1,
      "price": 12.5,
      "event": {
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
      },
      "ticketType": {
        "typeId": 1,
        "typeName": "Opiskelija-lippu"
      }
    },
    "transaction": {
      "transactionId": 1,
      "transactionDate": "2023-03-10T19:00:09.109437",
      "appUser": null
    }
  }
]
```

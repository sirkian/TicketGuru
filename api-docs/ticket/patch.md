# Merkkaa lipun usedDate-kenttään aikaleiman

**URL**: `/tickets/:pk`

**Metodi**: `PATCH`

**Vaadittu rooli**: Admin tai Lipuntarkastaja

## Vastauksen paluukoodi

**Koodit**:

`200 OK`

`404 NOT FOUND`

> `"message": "Annetulla id:llä ei ole olemassa lippua"`

## Esimerkkipyyntö:

**Polku**: `BASE_URL/tickets/1`

## Esimerkkivastaus:

```json
{
  "ticketId": 1,
  "verificationCode": "d77364fd",
  "usedDate": "2023-03-28T18:59:12.9234573",
  "eventTicketType": {
    "eventTypeId": 4,
    "price": 10.5,
    "event": {
      "eventId": 2,
      "eventName": "Uusi tapahtuma",
      "description": "Uuden tapahtuman kuvaus",
      "startTime": "2023-02-14T16:00:00",
      "endTime": "2023-02-14T18:00:00",
      "amountTickets": 1500,
      "presaleEnds": "2023-02-12T18:00:00",
      "cancelled": false,
      "venue": {
        "venueId": 1,
        "venueName": "Postitalo",
        "venueDescription": "Postimiehen koti, komee äänentoisto",
        "address": "Postikatu 1",
        "postalCode": {
          "postalCode": "04200",
          "city": "Kerava"
        }
      }
    },
    "ticketType": {
      "typeId": 1,
      "typeName": "Postilippu"
    }
  },
  "transaction": {
    "transactionId": 1,
    "transactionDate": "2023-03-28T18:57:58.446113",
    "appUser": {
      "userId": 1,
      "firstName": "Anneli",
      "lastName": "Admin",
      "email": "admin@tiketguru.com",
      "phoneNum": "+358123456",
      "details": "Järjestelmän pääkäyttäjä",
      "address": "Osoite1",
      "postalCode": {
        "postalCode": "00100",
        "city": "Helsinki"
      }
    }
  }
}
```

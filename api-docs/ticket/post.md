# Lisää uusi lippu

**URL**: `/tickets`

**Metodi**: `POST`

**Vaadittu rooli**: Admin tai Myyjä

## Vastauksen paluukoodit

**Koodit**:

`201 Created`

`400 BAD REQUEST`

## Esimerkkipyyntö:

**Polku**: `BASE_URL/tickets`

```json
{
  "usedDate": null,
  "eventTicketType": { "eventTypeId": 1 },
  "transaction": { "transactionId": 1 }
}
```

## Esimerkkivastaus:

```json
{
  "ticketId": 1,
  "verificationCode": "0a50ec7f",
  "usedDate": null,
  "eventTicketType": {
    "eventTypeId": 1,
    "price": 0.0,
    "event": null,
    "ticketType": null
  },
  "transaction": {
    "transactionId": 1,
    "transactionDate": null,
    "appUser": null
  }
}
```

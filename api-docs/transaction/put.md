# Muokkaa id:llä haettua myyntitapahtumaa

**URL**: `/transactions/:pk`

**Metodi**: `PUT`

## Vastauksen paluukoodit

**Koodit**:

`200 OK`

`201 Created`

`204 No content`

## Esimerkkipyyntö:

**Polku**: `BASE_URL/transactions/1`

```json
{
  "appUser": { "userId": 2 }
}
```

## Esimerkkivastaus:

```json
{
  "transactionId": 1,
  "transactionDate": "2023-03-12T15:23:21.5211701",
  "appUser": {
    "userId": 2,
    "firstName": "Mantero",
    "lastName": "Myyjä",
    "email": "myyja@ticketguru.com",
    "password": "password123",
    "phoneNum": "+358654321",
    "details": "TG:n luottomyyjä",
    "address": "Hesentie 11",
    "postalCode": {
      "postalCode": "00100",
      "city": "Helsinki"
    }
  }
}
```

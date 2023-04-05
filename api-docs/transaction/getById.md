# Näytä kaikki myyntitapahtumat

**URL**: `/transactions/:pk`

**Metodi**: `GET`

**Vaadittu rooli**: Admin tai Myyjä

## Vastauksen paluukoodi

**Koodit**:

`200 OK`

`404 NOT FOUND`

> `"message": "Myyntitapahtumaa ei löydy"`

## Esimerkkivastaus:

**Polku**: `BASE_URL/transactions/1`

```json
[
  {
    "transactionId": 1,
    "transactionDate": "2023-03-12T15:10:27.758503",
    "appUser": {
      "userId": 1,
      "firstName": "Pera",
      "lastName": "Pääkäyttäjä",
      "email": "pertsa@ticketguru.com",
      "phoneNum": "+358123456",
      "details": "Järjestelmän pääkäyttäjä",
      "address": "Kävelykatu 1",
      "postalCode": {
        "postalCode": "04200",
        "city": "Kerava"
      }
    }
  }
]
```

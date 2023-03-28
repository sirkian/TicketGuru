# Näytä kaikki myyntitapahtumat

**URL**: `/transactions`

**Metodi**: `GET`

**Vaadittu rooli**: Admin

## Vastauksen paluukoodi

**Koodit**:

`200 OK`

_Jos myyntitapahtumia ei ole, API palauttaa tyhjän taulukon koodilla 200 OK_

## Esimerkkivastaus:

**Polku**: `BASE_URL/transactions`

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

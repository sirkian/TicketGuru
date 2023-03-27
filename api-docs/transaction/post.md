# Lisää uusi myyntitapahtuma

**URL**: `/transactions`

**Metodi**: `POST`

**Vaadittu rooli**: Admin tai Myyjä

## Vastauksen paluukoodit

**Koodit**:

`201 CREATED`

`400 BAD REQUEST`

## Esimerkkipyyntö:

**Polku**: `BASE_URL/transactions`

```json
{
  "appUser": { "userId": 1 }
}
```

## Esimerkkivastaus:

```json
{
  "transactionId": 1,
  "transactionDate": "2023-03-12T15:10:27.7585033",
  "appUser": {
    "userId": 1,
    "firstName": null,
    "lastName": null,
    "email": null,
    "password": null,
    "phoneNum": null,
    "details": null,
    "address": null,
    "postalCode": null
  }
}
```

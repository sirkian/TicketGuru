# Näytä käyttäjän roolit

**URL**: `/appusers/:pk/appuserroles` _:pk = userId_

**Metodi**: `GET`

**Vaadittu rooli**: Admin

## Vastauksen paluukoodi

**Koodit**:

`200 OK`

_Jos käyttäjällä ei ole rooleja, API palauttaa tyhjän taulukon koodilla 200 OK_

`404 NOT FOUND`

> `"message": "Id:llä ei löytynyt käyttäjää"`

## Esimerkkivastaus:

**Polku**: `BASE_URL/appusers/1/appuserroles`

```json
[
  {
    "appUserRoleId": 1,
    "appUser": {
      "userId": 1,
      "firstName": "Pera",
      "lastName": "Pääkäyttäjä",
      "email": "pertsa@ticketguru.com",
      "password": "ghba2eo234igfnhi324iqaengineb342n",
      "phoneNum": "+358123456",
      "details": "Järjestelmän pääkäyttäjä",
      "address": "Kävelykatu 1",
      "postalCode": {
        "postalCode": "04200",
        "city": "Kerava"
      }
    },
    "role": {
      "roleId": 2,
      "role": "MYYJÄ"
    }
  },
  {
    "appUserRoleId": 2,
    "appUser": {
      "userId": 1,
      "firstName": "Pera",
      "lastName": "Pääkäyttäjä",
      "email": "pertsa@ticketguru.com",
      "password": "ghba2eo234igfnhi324iqaengineb342n",
      "phoneNum": "+358123456",
      "details": "Järjestelmän pääkäyttäjä",
      "address": "Kävelykatu 1",
      "postalCode": {
        "postalCode": "04200",
        "city": "Kerava"
      }
    },
    "role": {
      "roleId": 1,
      "role": "ADMIN"
    }
  }
]
```

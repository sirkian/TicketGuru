# Näytä kaikkien käyttäjien roolit

**URL**: `/appuserroles`

**Metodi**: `GET`

**Vaadittu rooli**: Admin

## Vastauksen paluukoodi

**Koodit**:

`200 OK`

_Jos mitään ei löydy, API palauttaa tyhjän taulukon koodilla 200 OK_

## Esimerkkivastaus:

**Polku**: `BASE_URL/appuserroles`

```json
[
  {
    "appUserRoleId": 1,
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
    },
    "role": {
      "roleId": 1,
      "role": "ADMIN"
    }
  },
  {
    "appUserRoleId": 4,
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
    },
    "role": {
      "roleId": 2,
      "role": "MYYJÄ"
    }
  },
  {
    "appUserRoleId": 5,
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
    },
    "role": {
      "roleId": 2,
      "role": "MYYJÄ"
    }
  }
]
```

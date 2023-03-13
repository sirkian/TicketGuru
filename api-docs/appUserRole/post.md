# Lisää rooli käyttäjälle

**URL**: `/appuserroles`

**Metodi**: `POST`

## Vastauksen paluukoodi

**Koodit**:

`201 CREATED`

`400 BAD REQUEST`

_Jos yritetään luoda virheellisella userId:llä tai roleId:llä._

## Esimerkkipyyntö:

**Polku**: `BASE_URL/appuserroles`

```json
{
  "appUser": { "userId": 1 },
  "role": { "roleId": 1 }
}
```

## Esimerkkivastaus:

```json
{
  "appUserRoleId": 1,
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
  },
  "role": {
    "roleId": 1,
    "role": null
  }
}
```

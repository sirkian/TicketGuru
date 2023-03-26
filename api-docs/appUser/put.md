# Muokkaa id:llä haettua käyttäjää

**URL**: `/appusers/:pk`

**Metodi**: `PUT`

**Vaadittu rooli**: Admin

## Vastauksen paluukoodit

**Koodit**:

`200 OK`

`400 BAD REQUEST`

`404 NOT FOUND`

## Esimerkkipyyntö:

**Polku**: `BASE_URL/appusers/1`

```json
    {
        "userId": 1,
        "firstName": "Esimerkki",
        "lastName": "Muokattu sukunimi",
        "email": "test@tester.com",
        "password": "test123",
        "phoneNum": "040404404",
        "details": "Muokkaillaan taas",
        "address": "Testikatu 324b",
        "postalCode": {
            "postalCode": "33101",
            "city": "Tampere 10"
        }
    }
```

## Esimerkkivastaus:

```json
{
    "userId": 1,
    "firstName": "Esimerkki",
    "lastName": "Muokattu sukunimi",
    "email": "test@tester.com",
    "password": "test123",
    "phoneNum": "040404404",
    "details": "Muokkaillaan taas",
    "address": "Testikatu 324b",
    "postalCode": {
        "postalCode": "33101",
        "city": "Tampere 10"
    }
}
```

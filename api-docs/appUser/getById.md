# Näytä käyttäjän userId:llä

**URL**: `/appusers/:pk`

**Metodi**: `GET`

**Vaadittu rooli**: Admin

## Vastauksen paluukoodit

**Koodit**:

`200 OK`

`404 NOT FOUND`

## Esimerkkivastaus:

**Polku**: `BASE_URL/appusers/1`

```json
{
    "userId": 1,
    "firstName": "Esimerkki",
    "lastName": "Testiläinen",
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

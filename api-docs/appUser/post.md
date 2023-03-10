# Lisää uusi käyttäjä

**URL**: `/appusers`

**Metodi**: `POST`

## Vastauksen paluukoodit

**Koodit**:

`201 CREATED`

`400 BAD REQUEST`

## Esimerkkipyyntö:

**Polku**: `BASE_URL/eventsappusers`
```json
{
    "firstName": "Testi",
    "lastName": "Testiläinen",
    "email": "test@tester.com",
    "password": "test123",
    "phoneNum": "040404404",
    "details": "Testaillaan tässä nyt vähäsen",
    "address": "Testikatu 324b",
       "postalCode": {
            "postalCode": "33101"
        } 
}
```

## Esimerkkivastaus:

```json
{
    "userId": 2,
    "firstName": "Testi",
    "lastName": "Testiläinen",
    "email": "test@tester.com",
    "password": "test123",
    "phoneNum": "040404404",
    "details": "Testaillaan tässä nyt vähäsen",
    "address": "Testikatu 324b",
    "postalCode": {
        "postalCode": "33101",
        "city": null
    }
}
```
_Kaupunki ei oikeasti ole null, sen tietoja ei vain ole vielä haettu GET-metodilla._

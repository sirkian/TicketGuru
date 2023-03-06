# Muokkaa tapahtumapaikkaa

**URL**: `/venues/:pk`

**Metodi**: `PUT`

#### Jos id ei löydy tietokannasta, metodi luo uuden tapahtumapaikan seuraavalle vapaalle id:lle

## Vastauksen paluukoodi

**Koodit**:

`200 OK`

`201 Created`

`204 No content`

`400 Bad Request`

## Esimerkkipyyntö:

**Polku**: `BASE_URL/venues/3`

```json
{
    "venueId": 3,
    "venueName": "Kulttuuritalo MUOKATTU",
    "venueDescription": "Musiikkitapahtumille, juhlille, kokouksille ja gaaloille",
    "address": "Sturenkatu 4",
    "postalCode": {
        "postalCode": "00100",
        "city": "Helsinki"
    }
}

```
## Esimerkkivastaus:

```json
{
    "venueId": 3,
    "venueName": "Kulttuuritalo MUOKATTU",
    "venueDescription": "Musiikkitapahtumille, juhlille, kokouksille ja gaaloille",
    "address": "Sturenkatu 4",
    "postalCode": {
        "postalCode": "00100",
        "city": "Helsinki"
    }
}

```


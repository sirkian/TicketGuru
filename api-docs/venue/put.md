# Muokkaa tapahtumapaikkaa

**URL**: `/venues/:pk`

**Metodi**: `PUT`

## Vastauksen paluukoodi

**Koodit**:

`200 OK`

`400 Bad Request`

`404 Not Found`

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


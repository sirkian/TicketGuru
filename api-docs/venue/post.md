# Lisää uusi tapahtumapaikka

**URL**: `/venues`

**Metodi**: `POST`

## Vastauksen paluukoodi

**Koodit**:

`201 Created`

`200 OK`

`204 No Content`

`400 Bad request`

## Esimerkkipyyntö:

```json
{
        "venueName": "Nokia Arena",
        "venueDescription": "Jäähalli, yleisöä mahtuu 3000 henkilöä",
        "address": "Kansikatu 3",
        "postalCode": {
            "postalCode": "33101"
        }    
}

```

## Esimerkkivastaus:

```json
 {
        "venueId": 6,
        "venueName": "Nokia Arena",
        "venueDescription": "Jäähalli, yleisöä mahtuu 3000 henkilöä",
        "address": "Kansikatu 3",
        "postalCode": {
            "postalCode": "33101",
            "city": "Tampere 10"
        }
    }

```

# Lisää uusi tapahtumapaikka

**URL**: `/venues`

**Metodi**: `POST`

**Vaadittu rooli**: Admin

## Vastauksen paluukoodi

**Koodit**:

`201 Created`

`400 Bad request`

`404 Not found`

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

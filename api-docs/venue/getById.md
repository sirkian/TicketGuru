# Näytä tapahtumapaikka venueId:llä

**URL**: `/venues/:pk`

**Metodi**: `GET`

## Vastauksen paluukoodit

**Koodi**: `200 OK`

**Koodi**: `404 NOT FOUND`

## Esimerkkivastaus:

**Polku**: `BASE_URL/venues/1`

```json
{
  "venueId": 1,
  "venueName": "tapahtumapaikka1",
  "venueDescription": "pieni paikka",
  "address": "Maitokatu 1",
  "postalCode": {
    "postalCode": "00100",
    "city": "Helsinki"
  }
}
```

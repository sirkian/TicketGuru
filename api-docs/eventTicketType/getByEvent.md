# Näytä kaikkien tapahtumien lipputyypit

**URL**: `/events/:pk/eventtickettypes` , jossa pk on eventId.

**Metodi**: `GET`

## Vastauksen paluukoodit

**Koodi**: `200 OK`

**Koodi**: `404 NOT FOUND`

Jos yritetään hakea ilman tapahtumapaikan id:tä.

**Koodi**: `500 INTERNAL SERVER ERROR`

Jos yritetään hakea tapahtumapaikan id:llä, jota ei ole olemassa.

Vastaus: `"Required path variable 'venueId' is not present."`

## Esimerkkivastaus:

**Polku**: `BASE_URL/events/1/eventtickettypes`

```json
// TODO
```

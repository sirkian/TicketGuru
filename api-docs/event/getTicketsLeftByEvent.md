# Näyttää tapahtuman myymättömien lippujen määrän

Palauttaa kokonaislukuna kuinka monta lippua tapahtumaan on vielä myymättä.
Hakee tapahtumalle asetetun lippumäärän, sekä myytyjen lippujen määrän ja palauttaa lukujen erotuksen.

**URL**: `/events/:pk/ticketsleft`

**Metodi**: `GET`

**Vaadittu rooli**: Admin tai Myyjä

## Vastauksen paluukoodit

**Koodit**:

`200 OK`

`404 NOT FOUND`

> `"message": "Annetulla id:llä ei ole olemassa tapahtumaa"`

## Esimerkkivastaus:

**Polku**: `BASE_URL/events/1/ticketsleft`

```json
1499
```

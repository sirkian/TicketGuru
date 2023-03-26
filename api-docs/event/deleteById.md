# Tapahtuman poisto

**URL**: `/events/:pk`

**Metodi**: `DELETE`

**Vaadittu rooli**: Admin

## Vastauksen paluukoodit

**Koodit**:

`200 OK`

> _Poisto onnistui, haetaan kaikki tapahtumat_

`204 NO CONTENT`

> _Jos poiston jälkeen ei ole enää tapahtumia_

`404 NOT FOUND`

> `"message": "Annetulla id:llä ei ole olemassa tapahtumaa"`

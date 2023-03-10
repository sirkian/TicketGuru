# Poista lippu ticketId:llä

**URL**: `/tickets/:pk`

**Metodi**: `DELETE`

## Vastauksen paluukoodi

**Koodit**:

`200 OK`

> _Palautetaan loput liput_

`204 No Content`

> _Jos poiston jälkeen ei ole enää yhtään lippua_

`404 Not Found`

> `"message": "Annetulla id:llä ei ole olemassa lippua"`

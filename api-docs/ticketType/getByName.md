## Hae lipputyyppi nimellä

**URL**: `/tickettypes/q?name=:hakusana`

**metodi**: `GET`

**Vaadittu rooli**: -

## Vastauksen paluukoodi

**Koodit**:

`200 OK`

`404 NOT FOUND`

> `"message": "Nimeä vastaavaa lippua ei löytynyt"`

## Esimerkkivastaus:

**Polku**: `BASE_URL/tickettypes/q?name=lippu`

```json
[
  {
    "typeId": 1,
    "typeName": "Postilippu"
  }
]
```

# Lisää uusi postinumero

**URL**: `/postalcodes`

**Metodi**: `POST`

**Vaadittu rooli**: Admin

## Vastauksen paluukoodit

**Koodit**:

`201 Created`


`400 Bad Request`


## Esimerkkipyyntö:

**Polku**: `BASE_URL/postalcodes`

```json
{
    "postalCode": "41340",
    "city": "Laukaa"
}
```

## Esimerkkivastaus:

```json
{
    "postalCode": "41340",
    "city": "Laukaa"
}
```

Tapahtumapaikat lisätään postinumeroon tapahtumapaikkaa lisätessä.


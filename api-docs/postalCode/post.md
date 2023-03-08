# Lisää uusi postinumero

**URL**: `/postalcodes`

**Metodi**: `POST`

## Vastauksen paluukoodit

**Koodit**:

`201 Created`

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


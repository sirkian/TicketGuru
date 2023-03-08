# Näytä postinumerot, joissa hakusana vastaa kaupunkia

Palauttaa kaikki postinumerot, joiden kaupungin nimi sisältää hakusanana käytetyn merkkijonon kirjainkoosta välittämättä.

Palauttaa tyhjän listan koodilla 200 OK, mikäli hakusanalla ei löydy yhtäkään postinumeroa.

**URL**: `/postalcodes/q?city=:hakusana`

**Metodi**: `GET`

## Vastauksen paluukoodi

**Koodit**: 

`200 OK`

## Esimerkkivastaus:

**Polku**: `BASE_URL/postalcodes/q?city=hels`

```json
[
    {
        "postalCode": "00100",
        "city": "Helsinki"
    }
]
```

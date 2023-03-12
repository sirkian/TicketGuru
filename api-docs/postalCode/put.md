# Muokkaa postinumerolla haettua postinumerotietuetta

**URL**: `/postalcodes/:pk`

**Metodi**: `PUT`

## Vastauksen paluukoodit

**Koodit**:

`200 OK`

`400 Bad Request`

`404 Not Found`

## Esimerkkipyyntö:

**Polku**: `BASE_URL/postalcodes/33101`

```json
{ 
    "city":"Tampere"
}
```

## Esimerkkivastaus:

```json
{
    "postalCode": "33101",
    "city": "Tampere"
}
```

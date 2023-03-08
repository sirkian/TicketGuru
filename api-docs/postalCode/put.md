# Muokkaa postinumerolla haettua postinumerotietuetta

**URL**: `/postalcodes/:pk`

**Metodi**: `PUT`

## Vastauksen paluukoodit

**Koodit**:

`200 OK`

`201 Created`

`204 No content`

## Esimerkkipyyntö:

**Polku**: `BASE_URL/postalcodes/33101`

```json
{ 
    "city":"Tampere (Suomen Chicago)"
}
```

## Esimerkkivastaus:

```json
{
    "postalCode": "33101",
    "city": "Tampere (Suomen Chicago)"
}
```

# Näytä rooli roleId:llä

**URL**: `/roles/:pk`

**Metodi**: `GET`

**Vaadittu rooli**: Admin

## Vastauksen paluukoodit

**Koodit**: 

`200 OK`

`404 NOT FOUND`

## Esimerkkivastaus:

**Polku**: `BASE_URL/roles/1`

```json
{
    "roleId": 1,
    "role": "Testirooli"
}
```

# Lisää uusi rooli

**URL**: `/roles`

**Metodi**: `POST`

## Vastauksen paluukoodit

**Koodit**:

`201 Created`

## Esimerkkipyyntö:

**Polku**: `BASE_URL/roles`

```json
    {
        "role": "Uusi Testirooli"
    }
```

## Esimerkkivastaus:

```json
{
    "roleId": 2,
    "role": "Uusi Testirooli"
}
```

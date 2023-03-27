# Lisää uusi tapahtuman lipputyyppi

**URL**: `/eventtickettypes`

**Metodi**: `POST`

**Vaadittu rooli**: Admin

## Vastauksen paluukoodi

**Koodit**:

`201 CREATED`

`400 BAD REQUEST`

## Esimerkkipyyntö:

**Polku**: `BASE_URL/eventtickettypes`

```json
{
  "event": {
    "eventId": 1
  },
  "ticketType": {
    "typeId": 2
  },
  "price": 15.0
}
```

## Esimerkkivastaus:

```json
{
  "eventTypeId": 1,
  "price": 15.0,
  "event": {
    "eventId": 1,
    "eventName": null,
    "description": null,
    "startTime": null,
    "endTime": null,
    "amountTickets": 0,
    "presaleEnds": null,
    "cancelled": false,
    "venue": null
  },
  "ticketType": {
    "typeId": 2,
    "typeName": null
  }
}
```

_Kenttien arvo ei oikeasti ole null, tapahtuman ja lipputyypin tietoja ei vain ole vielä haettu GET-metodilla._

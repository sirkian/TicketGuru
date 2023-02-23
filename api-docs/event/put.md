# Muokkaa id:llä haettua tapahtumaa

**URL**: `/events:pk`

**Metodi**: `PUT`

## Vastauksen paluukoodit

**Koodit**: 

`200 OK`

`201 Created`

`204 No content`


## Esimerkkivastaus:

**Polku**: `BASE_URL/events:pk`

```json
[
{
  "eventName": "string",
  "description": "string",
  "startTime": "2023-02-23T06:27:44.400Z",
  "endTime": "2023-02-23T06:27:44.400Z",
  "amountTickets": 0,
  "presaleEnds": "2023-02-23T06:27:44.400Z",
  "cancelled": true,
  "_links": {
    "additionalProp1": {
      "href": "string",
      "hreflang": "string",
      "title": "string",
      "type": "string",
      "deprecation": "string",
      "profile": "string",
      "name": "string",
      "templated": true
    },
    "additionalProp2": {
      "href": "string",
      "hreflang": "string",
      "title": "string",
      "type": "string",
      "deprecation": "string",
      "profile": "string",
      "name": "string",
      "templated": true
    },
    "additionalProp3": {
      "href": "string",
      "hreflang": "string",
      "title": "string",
      "type": "string",
      "deprecation": "string",
      "profile": "string",
      "name": "string",
      "templated": true
    }
  }
}
]
```

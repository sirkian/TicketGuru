# TicketGuru

Koodivelehot: Estrada Salla, Helminen Sonja, Koskinen Erika, Laaja Milla, Sirkiä Anssi, Ümera Björn-Erik

## Johdanto

Projekti tuottaa “TicketGuru” nimisen lipunmyyntijärjestelmän lipputoimiston käyttöön.

Järjestelmää käyttävät lipputoimiston pääkäyttäjät ja lippujen myyjät. Pääkäyttäjät voivat muun muassa lisätä järjestelmään tapahtumia, määrittää lippujen hintoja ja tarkastella menneiden tapahtumien tietoja. Myyjät voivat järjestelmän kautta myydä ja tulostaa uniikilla 8-merkkisellä koodilla varustettuja lippuja, jotka merkitään käytetyksi tapahtumaan saavuttaessa. Järjestelmää voidaan käyttää pohjana myöhemmin toteutettavalle verkkokaupalle.

Valmiin tuotoksen tulee olla ominaisuuksiltaan käyttäjäystävällinen. Tämä voidaan toteuttaa esimerkiksi sisällyttämällä järjestelmään search bar-ominaisuus tietyn tapahtuman etsimistä varten ja suunnittelemalla järjestelmän ulkoasu yksinkertaiseksi.

Järjestelmä hyödyntää palvelinratkaisussa Spring Framework -alustaa ja alustavasti MariaDB -tietokantajärjestelmää. Järjestelmän käyttöliittymä toteutetaan desktop-versiona.

## Järjestelmän määrittely

**Pääkäyttäjä**

- Pääkäyttäjällä on käyttöoikeudet kaikkiin järjestelmän tarjoamiin toimintoihin ja ominaisuuksiin. Pääkäyttäjä voi lisätä järjestelmään tapahtumia ja lipputyyppejä, sekä muokata tapahtuman ja lipputyypin tietoja. Pääkäyttäjä voi lisäksi tarkastella järjestelmän tapahtumahistoriaa.

**Myyjä**

- Myyjä myy ja tulostaa asiakkaalle lippuja tapahtumiin järjestelmän kautta. Myyjä voi valita kerralla useamman lipun yhteen tai useaan tapahtumaan, ja tulostaa ne heti asiakkaan käyttöön. Myyjä voi myös tarkastella tapahtumakohtaisten lippujen jäljellä olevaa määrää sekä tulostaa jäljellä olevat liput kerralla ovelle myytäväksi.

**Lipuntarkastaja**

- Lipuntarkastaja kirjautuu järjestelmään, jotta voi todentaa käytettävän lipun järjestelmästä.

**Järjestelmä**

- Järjestelmä tunnistaa käyttäjän kirjautumisen perusteella, ja hakee tämän käyttöön käyttöoikeuksissa määritellyt toiminnot, jotta käyttäjä voi tehdä vain sen mihin hänellä on oikeuksia. Järjestelmä myös generoi lippuihin uniikkeja koodeja, jotka se osaa tunnistaa ja merkitä käytetyiksi. Järjestelmään mahtuu 500 eri tapahtuman tiedot. Myyntitapahtumat ja muu tapahtumahistoria tallentuu automaattisesti. Järjestelmä ei kaadu käyttäjän tekemiin virheisiin, esimerkiksi virheelliseen syötteeseen.

**Käyttötapauskaavio**

![TicketGuru](https://user-images.githubusercontent.com/118562724/217886824-f2d973aa-295a-4c25-a1c5-402aa8b6b4a0.png)

## Käyttöliittymä

**Lipunmyynti** toteutetaan valitsemalla tapahtumaan oikea määrä oikean lipputyypin lippuja ja vahvistamalla myyntitapahtuma. Vahvistuksen jälkeen järjestelmä näyttää tehdyn myyntitapahtuman tiedot, ja myydyt liput tulostusta varten.

![lipunmyynti](https://user-images.githubusercontent.com/118562724/216830185-57b29eff-eecc-4302-8de2-5e49887690b9.png)

**Tapahtumia hallitaan** yhteisnäkymästä, jossa tapahtumat on listattu. Näkymässä jokaista olemassa olevaa tapahtumaa voi muokata, sen lipputyyppejä voi tarkastella, muokata sekä lisätä, tai ottaa tapahtumasta myyntiraportin. Samasta näkymästä pääsee lisäämään uuden tapahtuman.

![tapahtumien_hallinta](https://user-images.githubusercontent.com/118562724/216830349-4b8a5827-883b-46ee-99d7-1b436aaf5558.png)

**Myyntiraportti** näyttää, montako mitäkin lipputyyppiä on tapahtumaan myyty, ja paljonko lipputuotot ovat per lipputyyppi sekä kaikki myydyt liput yhteensä. Raportin kautta pääsee selaamaan listaa tapahtuman myyntitapahtumista, joka näyttää jokaisen myyntitapahtuman ajan, uniikin id:n sekä yhteissumman.

![myyntiraportti](https://user-images.githubusercontent.com/118562724/216830550-99eab081-4e99-4e12-9a96-9f7a6185226d.png)

Wireframemallit on saatu asiakkaalta.

## Tietokannat

![entityrel2 0](https://user-images.githubusercontent.com/91193039/218547193-ea9347d9-9cb2-4124-b8f1-5283c1ab4040.png)

[Tietohakemisto](https://github.com/Bjorn-Eric/TicketGuru/files/10724406/Tietokannan.suunnittelu.docx)

## Rajapinnan kuvaus

---

**Base URL:** `http://localhost:8080/`

_Vielä yksityiskohtaisempaa API-dokumentaatiota varten käytössä on Open-API:n Swagger-UI osoitteessa: `http://localhost:8080/swagger-ui/index.html`._

_YAML-muotoinen API-dokumentaatio on ladattavissa [täältä](localhost:8080/v3/api-docs.yaml)._

---

### Tapahtumat

| Toiminto                                                                                                    | Metodi | Polku                           | Param. tyyppi  |
| ----------------------------------------------------------------------------------------------------------- | ------ | ------------------------------- | -------------- |
| [Hae tapahtumat](https://github.com/Bjorn-Eric/TicketGuru/blob/develop/api-docs/event/get.md)               | `GET`  | `/events`                       | -              |
| [Hae tapahtuma id:llä](https://github.com/Bjorn-Eric/TicketGuru/blob/develop/api-docs/event/getById.md)     | `GET`  | `/events/:pk`                   | Integer (Long) |
| [Hae tapahtumia nimellä](https://github.com/Bjorn-Eric/TicketGuru/blob/develop/api-docs/event/getByName.md) | `GET`  | `/events/search?name=:hakusana` | String         |
| [Lisää tapahtuma](https://github.com/Bjorn-Eric/TicketGuru/blob/develop/api-docs/event/post.md)             | `POST` | `/events`                       | -              |
| [Muokkaa tapahtumaa](https://github.com/Bjorn-Eric/TicketGuru/blob/develop/api-docs/event/put.md)           | `PUT`  | `/events/:pk`                   | Integer (Long) |
| [Poista tapahtuma](https://github.com/Bjorn-Eric/TicketGuru/blob/develop/api-docs/event/deleteById.md)      | `DELETE`  | `/events/:pk`             | Integer (Long) |

### Tapahtumapaikat

| Toiminto                                                                                                      | Metodi   | Polku               | Param. tyyppi  |
| ------------------------------------------------------------------------------------------------------------- | -------- | ------------------- | -------------- |
| [Hae tapahtumapaikat](https://github.com/Bjorn-Eric/TicketGuru/blob/develop/api-docs/venue/get.md)            | `GET`    | `/venues`           | -              |
| [Hae tapahtumapaikka id:llä](https://github.com/Bjorn-Eric/TicketGuru/blob/develop/api-docs/venue/getById.md) | `GET`    | `/venues/:pk`       | Integer (Long) |
| [Lisää tapahtumapaikka](https://github.com/Bjorn-Eric/TicketGuru/blob/develop/api-docs/venue/post.md)         | `POST`   | `/venues`           | -              |
| [Muokkaa tapahtumapaikkaa](https://github.com/Bjorn-Eric/TicketGuru/blob/develop/api-docs/venue/put.md)       | `PUT`    | `/venues/:pk`       | Integer (Long) |
| [Poista tapahtumapaikka](https://github.com/Bjorn-Eric/TicketGuru/blob/develop/api-docs/venue/delete.md)      | `DELETE` | `/delete_venue/:pk` | Integer (Long) |

### Tapahtuman lipputyypit

| Toiminto                                                                                                                         | Metodi | Polku                          | Param. tyyppi  |
| -------------------------------------------------------------------------------------------------------------------------------- | ------ | ------------------------------ | -------------- |
| [Hae kaikki tapahtumien lipputyypit](https://github.com/Bjorn-Eric/TicketGuru/blob/develop/api-docs/eventTicketType/get.md)      | `GET`  | `/eventtickettypes`            | -              |
| [Hae yhden tapahtuman lipputyypit](https://github.com/Bjorn-Eric/TicketGuru/blob/develop/api-docs/eventTicketType/getByEvent.md) | `GET`  | `/events/:pk/eventtickettypes` | Integer (Long) |
| [Lisää tapahtumalle lipputyyppi](https://github.com/Bjorn-Eric/TicketGuru/blob/develop/api-docs/eventTicketType/post.md)         | `POST` | `/eventtickettypes`            | -              |
| [Muokkaa tapahtuman lipputyyppiä](TODO)                                                                                          | `PUT`  | `/eventtickettypes/:pk`        | Integer (Long) |

### Liput

| Toiminto                                                                                                      | Metodi   | Polku               | Param. tyyppi  |
| ------------------------------------------------------------------------------------------------------------- | -------- | ------------------- | -------------- |
| [Hae liput](https://github.com/Bjorn-Eric/TicketGuru/blob/develop/api-docs/ticket/get.md)                     | `GET`    | `/tickets`           | -              |
| [Hae lippu id:llä](https://github.com/Bjorn-Eric/TicketGuru/blob/develop/api-docs/ticket/getById.md)          | `GET`    | `/tickets/:pk`       | Integer (Long) |
| [Lisää lippu](https://github.com/Bjorn-Eric/TicketGuru/blob/develop/api-docs/ticket/post.md)                  | `POST`   | `/tickets`           | -              |
| [Muokkaa lippua](https://github.com/Bjorn-Eric/TicketGuru/blob/develop/api-docs/ticket/put.md)                | `PUT`    | `/tickets/:pk`       | Integer (Long) |
| [Poista lippu](https://github.com/Bjorn-Eric/TicketGuru/blob/develop/api-docs/ticket/deleteById.md)           | `DELETE` | `/tickets/:pk`      | Integer (Long) |

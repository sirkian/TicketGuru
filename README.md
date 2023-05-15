# TicketGuru

Koodivelehot: Estrada Salla, Helminen Sonja, Koskinen Erika, Laaja Milla, Sirkiä Anssi

## Johdanto

Projekti tuottaa “TicketGuru” nimisen lipunmyyntijärjestelmän lipputoimiston käyttöön.

Järjestelmää käyttävät lipputoimiston pääkäyttäjät ja lippujen myyjät. Pääkäyttäjät voivat muun muassa lisätä järjestelmään tapahtumia, määrittää lippujen hintoja ja tarkastella menneiden tapahtumien tietoja. Myyjät voivat järjestelmän kautta myydä ja tulostaa uniikilla 8-merkkisellä koodilla varustettuja lippuja, jotka merkitään käytetyksi tapahtumaan saavuttaessa. Järjestelmää voidaan käyttää pohjana myöhemmin toteutettavalle verkkokaupalle.

Valmis tuotos on ominaisuuksiltaan selkeä ja käyttäjäystävällinen. Tämä on toteutettu esimerkiksi sisällyttämällä järjestelmään search bar-ominaisuus tietyn tapahtuman etsimistä varten ja suunnittelemalla järjestelmän ulkoasu yksinkertaiseksi.

Järjestelmä hyödyntää palvelinratkaisussa Spring Framework -alustaa ja MySQL -tietokantajärjestelmää. Järjestelmän käyttöliittymä toteutetaan desktop-versiona.

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

**Lipunmyynti** toteutetaan valitsemalla tapahtuma listasta, jolloin alle avautuu tapahtuman eri lipputyypit. Lipputyypeistä valitaan myytävien lippujen määrät, ja myydään liput. Myynnin jälkeen näkyviin tulee myyntitapahtuma, jonka kautta voi tulostaa liput asiakkaalle tai peruuttaa myyntitapahtuman.

![Lipunmyynti](https://github.com/sirkian/TicketGuru/assets/118562724/58e840c7-8804-44b7-bd79-6fe6cbd3bb3d)

[Lipunmyynnin rautalankamalli](https://user-images.githubusercontent.com/118562724/216830185-57b29eff-eecc-4302-8de2-5e49887690b9.png)

---

**Tapahtumia hallitaan** resurssien hallinnan kautta. Tapahtumat -napin kautta pääsee lisäämään uuden tapahtuman sekä muokkaamaan olemassa olevia tapahtumia. Tapahtumapaikat -painikkeen kautta pääsee lisäämään uuden tapahtumapaikan, muokkaamaan tai poistamaan olemassa olevia tapahtumapaikkoja, sekä lisäämään uusia postinumeroita. Tapahtuman lipputyypit -painikkeen kautta voi hakea kunkin tapahtuman lipputyypit sekä lisätä tapahtumalle uusia lipputyyppejä ja muokata nykyisten lipputyyppien hintoja. Täysin uusia lipputyypejä pääsee myös lisäämään erillisen Lipputyypit -painikkeen kautta.

![Tapahtumien hallinta](https://github.com/sirkian/TicketGuru/assets/118562724/adada89f-801f-4eb5-b8b9-a1a509f8d134)

[Tapahtumien hallinnan rautalankamalli](https://user-images.githubusercontent.com/118562724/216830349-4b8a5827-883b-46ee-99d7-1b436aaf5558.png)

---

**Myyntiraportti** näyttää, montako mitäkin lipputyyppiä on tapahtumaan myyty, ja paljonko lipputuotot ovat per lipputyyppi. Jokaisen tapahtuman myyntiraportti haetaan näkyville Hae raportti -painikkeen kautta.

![Myyntiraportti](https://github.com/sirkian/TicketGuru/assets/118562724/6dc8116c-cd25-43ac-a970-4c9a4bd60dd8)

[Myyntiraportin rautalankamalli](https://user-images.githubusercontent.com/118562724/216830550-99eab081-4e99-4e12-9a96-9f7a6185226d.png)

---

**Lippu tarkistetaan** tarkistuskoodin kautta. Lipun tiedot näytetään ja lipun voi merkata käytetyksi painikkeen kautta. Jos käytettyä lippua haetaan uudelleen, antaa järjestelmä virheilmoituksen, jossa kerrotaan milloin lippu on jo käytetty. 

![Lipun tarkistus](https://github.com/sirkian/TicketGuru/assets/118562724/2c8ae46c-ec8e-45ca-a030-491e95944718)


Wireframemallit on saatu asiakkaalta.

## Tietokannat

![entityrel7](https://user-images.githubusercontent.com/91193039/223218196-ccd1cb24-3d3d-4db8-bef9-89015640deb0.jpg)



Versiohistoria:

[Versio 1](https://user-images.githubusercontent.com/91193039/220620475-552eafc8-0e00-4c67-84d4-bca138d11271.png)

[Tietohakemisto](https://github.com/sirkian/TicketGuru/files/10951928/Tietohakemisto.docx)


## Tekninen kuvaus

Projektin palvelinpuolen repositoryssa on kolme haaraa: develop, main ja prod.

- **Develop** on kehityshaara, jossa käytetään MySQL -tietokantaa joka jokaisen uudelleen käynnistyksen yhteydessä tyhjentää tietokannan ja luo sen uudelleen.
- **Main** oli alunperin julkaisuhaara, johon siirrettiin develop -haara aina sprintin päätteeksi. Nykyään main -haarassa varmistetaan ettää konfiguraatiot ovat kunnossa julkaisua varten.
- **Prod** on julkaisuhaara jonka muutokset julkaistaan GitHub Actionsilla automaattisesti Microsoft Azureen. Azuressa tietokanta on persistentti.

Projektin client on erillisessä [repositoryssa.](https://github.com/sirkian/ticketguru-client)

**Yleiskuvaus**

- Palvelin on toteutettu Spring Boot -alustalle, tietokantana käytetään MySQL ja palvelinohjelma on julkaistu Microsoft Azure -palveluun. Client pyörii [GitHub Pagesissa.](https://sirkian.github.io/ticketguru-client/)
- Palvelinohjelma käyttää HTTP Basic -autentikointia.

---

**Base URL:** `http://localhost:8080/`

_Vielä yksityiskohtaisempaa API-dokumentaatiota varten käytössä on Open-API:n Swagger-UI osoitteessa:_ [/swagger-ui.html](http://localhost:8080/swagger-ui/index.html)

_YAML-muotoinen API-dokumentaatio on ladattavissa_ [/v3/api-docs.yaml](localhost:8080/v3/api-docs.yaml)

---

**REST-rajapintojen kuvaukset**

### Tapahtumat

| Toiminto                                                                                                    | Metodi   | Polku                      | Param. tyyppi  |
| ----------------------------------------------------------------------------------------------------------- | -------- | -------------------------- | -------------- |
| [Hae tapahtumat](https://github.com/sirkian/TicketGuru/blob/main/api-docs/event/get.md)               | `GET`    | `/events`                  | -              |
| [Hae tapahtuma id:llä](https://github.com/sirkian/TicketGuru/blob/main/api-docs/event/getById.md)     | `GET`    | `/events/:pk`              | Integer (Long) |
| [Hae tapahtumia nimellä](https://github.com/sirkian/TicketGuru/blob/main/api-docs/event/getByName.md) | `GET`    | `/events/q?name=:hakusana` | String         |
| [Lisää tapahtuma](https://github.com/sirkian/TicketGuru/blob/main/api-docs/event/post.md)             | `POST`   | `/events`                  | -              |
| [Muokkaa tapahtumaa](https://github.com/sirkian/TicketGuru/blob/main/api-docs/event/put.md)           | `PUT`    | `/events/:pk`              | Integer (Long) |
| [Poista tapahtuma](https://github.com/sirkian/TicketGuru/blob/main/api-docs/event/deleteById.md)      | `DELETE` | `/events/:pk`              | Integer (Long) |

### Tapahtumapaikat

| Toiminto                                                                                                      | Metodi   | Polku         | Param. tyyppi  |
| ------------------------------------------------------------------------------------------------------------- | -------- | ------------- | -------------- |
| [Hae tapahtumapaikat](https://github.com/sirkian/TicketGuru/blob/main/api-docs/venue/get.md)            | `GET`    | `/venues`     | -              |
| [Hae tapahtumapaikka id:llä](https://github.com/sirkian/TicketGuru/blob/main/api-docs/venue/getById.md) | `GET`    | `/venues/:pk` | Integer (Long) |
| [Lisää tapahtumapaikka](https://github.com/sirkian/TicketGuru/blob/main/api-docs/venue/post.md)         | `POST`   | `/venues`     | -              |
| [Muokkaa tapahtumapaikkaa](https://github.com/sirkian/TicketGuru/blob/main/api-docs/venue/put.md)       | `PUT`    | `/venues/:pk` | Integer (Long) |
| [Poista tapahtumapaikka](https://github.com/sirkian/TicketGuru/blob/main/api-docs/venue/deleteById.md)  | `DELETE` | `/venues/:pk` | Integer (Long) |

### Tapahtuman lipputyypit

| Toiminto                                                                                                                         | Metodi | Polku                          | Param. tyyppi  |
| -------------------------------------------------------------------------------------------------------------------------------- | ------ | ------------------------------ | -------------- |
| [Hae kaikki tapahtumien lipputyypit](https://github.com/sirkian/TicketGuru/blob/main/api-docs/eventTicketType/get.md)      | `GET`  | `/eventtickettypes`            | -              |
| [Hae yhden tapahtuman lipputyypit](https://github.com/sirkian/TicketGuru/blob/main/api-docs/eventTicketType/getByEvent.md) | `GET`  | `/events/:pk/eventtickettypes` | Integer (Long) |
| [Lisää tapahtumalle lipputyyppi](https://github.com/sirkian/TicketGuru/blob/main/api-docs/eventTicketType/post.md)         | `POST` | `/eventtickettypes`            | -              |
| [Muokkaa tapahtuman lipputyyppiä](https://github.com/sirkian/TicketGuru/blob/main/api-docs/eventTicketType/put.md)         | `PUT`  | `/eventtickettypes/:pk`        | Integer (Long) |

### Lipputyypit

| Toiminto                                                                                             | Metodi   | Polku                       | Param. tyyppi  |
| ---------------------------------------------------------------------------------------------------- | -------- | --------------------------- | -------------- |
| [Hae lipputyypit](https://github.com/sirkian/TicketGuru/blob/main/api-docs/ticketType/get.md)  | `GET`    | `/tickettypes`              | -              |
| [Hae lipputyyppi nimellä](https://github.com/sirkian/TicketGuru/blob/main/api-docs/ticketType/getByName.md)  | `GET`    | `/tickettypes/q?name=:hakusana`              | String             |
| [Lisää lipputyyppi](https://github.com/sirkian/TicketGuru/blob/main/api-docs/ticketType/post.md)  | `POST`   | `/tickettypes`           | -              |
| [Muokkaa lipputyyppiä](https://github.com/sirkian/TicketGuru/blob/main/api-docs/ticketType/put.md) | `PUT`    | `/tickettypes/:pk`              | Integer (Long) |

### Liput

| Toiminto                                                                                             | Metodi   | Polku                       | Param. tyyppi  |
| ---------------------------------------------------------------------------------------------------- | -------- | --------------------------- | -------------- |
| [Hae liput](https://github.com/sirkian/TicketGuru/blob/main/api-docs/ticket/get.md)            | `GET`    | `/tickets`                  | -              |
| [Hae lippu id:llä](https://github.com/sirkian/TicketGuru/blob/main/api-docs/ticket/getById.md) | `GET`    | `/tickets/:pk`              | Integer (Long) |
| [Hae myyntitapahtuman liput](https://github.com/sirkian/TicketGuru/blob/main/api-docs/ticket/getByTransaction.md)                                                                 | `GET`    | `/transactions/:pk/tickets` | Integer (Long) |
| [Hae tarkastuskoodilla](https://github.com/sirkian/TicketGuru/blob/main/api-docs/ticket/getByVerificationCode.md)                                                                      | `GET`    | `/tickets/q?name=:koodi`    | String         |
| [Lisää lippu](https://github.com/sirkian/TicketGuru/blob/main/api-docs/ticket/post.md)         | `POST`   | `/tickets`                  | -              |
| [Muokkaa lippua](https://github.com/sirkian/TicketGuru/blob/main/api-docs/ticket/put.md)       | `PUT`    | `/tickets/:pk`              | Integer (Long) |
| [Poista lippu](https://github.com/sirkian/TicketGuru/blob/main/api-docs/ticket/deleteById.md)  | `DELETE` | `/tickets/:pk`              | Integer (Long) |
| [Merkkaa lippu käytetyksi](https://github.com/sirkian/TicketGuru/blob/main/api-docs/ticket/patch.md)  | `PATCH` | `/tickets/:pk`              | Integer (Long) |

### Ostotapahtuma

| Toiminto                                                                                             | Metodi   | Polku                       | Param. tyyppi  |
| ---------------------------------------------------------------------------------------------------- | -------- | --------------------------- | -------------- |
| [Hae ostotapahtumat](https://github.com/sirkian/TicketGuru/blob/main/api-docs/transaction/get.md)| `GET`    | `/transactions`           | -              |
| [Hae ostotapahtuma id:llä](https://github.com/sirkian/TicketGuru/blob/main/api-docs/transaction/getById.md) | `GET`    | `/transactions/:pk`| Integer (Long) |
| [Lisää ostotapahtuma](https://github.com/sirkian/TicketGuru/blob/main/api-docs/transaction/post.md)         | `POST`   | `/transactions`  | -              |
| [Muokkaa ostotapahtumaa](https://github.com/sirkian/TicketGuru/blob/main/api-docs/transaction/put.md)       | `PUT`    | `/transactions/:pk` | Integer (Long) |
| [Poista ostotapahtuma](https://github.com/sirkian/TicketGuru/blob/main/api-docs/transaction/deleteById.md)  | `DELETE` | `/transactions/:pk` | Integer (Long) |

### Postinumerot

| Toiminto                                                                                                                       | Metodi | Polku                           | Param. tyyppi |
| ------------------------------------------------------------------------------------------------------------------------------ | ------ | ------------------------------- | ------------- |
| [Hae postinumerot](https://github.com/sirkian/TicketGuru/blob/main/api-docs/postalCode/get.md)                           | `GET`  | `/postalcodes`                  | -             |
| [Hae postinumeroita kaupungin nimellä](https://github.com/sirkian/TicketGuru/blob/main/api-docs/postalCode/getByName.md) | `GET`  | `/postalcodes/q?city=:hakusana` | String        |
| [Lisää postinumero](https://github.com/sirkian/TicketGuru/blob/main/api-docs/postalCode/post.md)                         | `POST` | `/postalcodes`                  | -             |
| [Muokkaa postinumeroa](https://github.com/sirkian/TicketGuru/blob/main/api-docs/postalCode/put.md)                       | `PUT`  | `/postalcodes/:pk`              | String        |

### Roolit

| Toiminto                                                                                           | Metodi | Polku        | Param. tyyppi  |
| -------------------------------------------------------------------------------------------------- | ------ | ------------ | -------------- |
| [Hae roolit](https://github.com/sirkian/TicketGuru/blob/main/api-docs/role/get.md)           | `GET`  | `/roles`     | -              |
| [Hae rooli id:llä](https://github.com/sirkian/TicketGuru/blob/main/api-docs/role/getById.md) | `GET`  | `/roles/:pk` | Integer (Long) |
| [Lisää rooli](https://github.com/sirkian/TicketGuru/blob/main/api-docs/role/post.md)         | `POST` | `/roles`     | -              |

### Käyttäjät

| Toiminto                                                                                                 | Metodi | Polku           | Param. tyyppi  |
| -------------------------------------------------------------------------------------------------------- | ------ | --------------- | -------------- |
| [Hae käyttäjät](https://github.com/sirkian/TicketGuru/blob/main/api-docs/appUser/get.md)           | `GET`  | `/appusers`     | -              |
| [Hae käyttäjä id:llä](https://github.com/sirkian/TicketGuru/blob/main/api-docs/appUser/getById.md) | `GET`  | `/appusers/:pk` | Integer (Long) |
| [Lisää käyttäjä](https://github.com/sirkian/TicketGuru/blob/main/api-docs/appUser/post.md)         | `POST` | `/appusers`     | -              |
| [Muokkaa käyttäjää](https://github.com/sirkian/TicketGuru/blob/main/api-docs/appUser/put.md)       | `PUT`  | `/appusers/:pk` | Integer (Long) |

### Käyttäjän roolit

| Toiminto                                                                                             | Metodi   | Polku                       | Param. tyyppi  |
| ---------------------------------------------------------------------------------------------------- | -------- | --------------------------- | -------------- |
| [Hae kaikkien käyttäjien roolit](https://github.com/sirkian/TicketGuru/blob/main/api-docs/appUserRole/get.md) | `GET`    | `/appuserroles` | -              |
| [Hae käyttäjän roolit](https://github.com/sirkian/TicketGuru/blob/main/api-docs/appUserRole/getByAppUser.md)   | `GET`    | `/appusers/:pk/appuserroles` |  Integer (Long)  |
| [Lisää rooli käyttäjälle](https://github.com/sirkian/TicketGuru/blob/main/api-docs/appUserRole/post.md)       | `POST`    | `/appuserroles` | Integer (Long) |
| [Poista käyttäjän rooli](https://github.com/sirkian/TicketGuru/blob/main/api-docs/appUserRole/deleteById.md)  | `DELETE` | `/appuserroles/:pk` | Integer (Long) |


## Testaus

Kaikkia järjestelmän rajapintoja on testattu tutkivalla testauksella Postman -sovellusta ja clientiä käyttäen. 

| Testattava asia | Testin suoritus |
| ----------------| ----------------|
| Yksittäiset luokat ja niitä vastaavien repositorioiden toiminta. | Ajetaan testiluokat palvelinohjelmistossa. Ajetaan aina kun ohjelmaan lisätään uusia ominaisuuksia.|
| Integraatiotesti. Tapahtuman ja lipun testaus rajapinnan (REST API) kautta. | Ajetaan testit palvelinohjelmistossa. MocMVC. Testataan rajapinnan käyttö autentikoinnin kanssa. |
| End-to-end testit. Järjestelmän toiminta clientiltä tietokannalle. | Testataan käyttämällä ohjelmistoa clientin kautta sekä Postman- ohjelmalla. Lisäksi automatisoituja testejä Robot frameworkillä. |

Testeissä ei ilmennyt korjattavia ongelmia, ja tutkivassa testauksessa havaituista virheistä avattiin issuet projektin scrum boardille, ja ne hoidettiin joko kuluvassa tai seuraavassa sprintissä pois.

## Asennustiedot

**Palvelin**
- Asenna koneelle esimerkiksi Eclipse tai VS Code.
- Asenna koneelle MySQL -tietokanta ja määrittele se käyttämään porttia 3307 (tai muokkaa serverin application-dev.properties -tiedosta portti oikeaksi).
- Kloonaa projektin repositorio GitHubista.
- Laita application-dev.properties -tiedostoon MySQL:n käyttäjätunnus sekä salasana ja varmista, että application.properties -tiedostossa aktiivinen profiili on "dev".
- Käynnistä palvelin (käynnistyy portissa 8080).

**Client**
- Kloonaa projektin repositorio GitHubista. (https://github.com/sirkian/ticketguru-client)
- Navigoi kloonattuun kansioon ja suorita "npm install".
- Käynnistä client "npm start" -komennolla.


## Käynnistys- ja käyttöohje

#### Sovelluksen käyttäminen paikallisessa kehitysympäristössä
Sovellus käynnistetään asennustietojen ohjeiden mukaisesti.
Kehitysympäristössä tietokantaan luodaan automaattisesti kolme käyttäjää: admin, myyjä ja lipuntarkastaja.  
- ADMIN: admin@tiketguru.com / admin
- MYYJÄ: make@tiketguru.com / user
- LIPUNTARKASTAJA: liisa@tiketguru.com / inspector

#### Sovelluksen käyttäminen julkaistussa ympäristössä
Tietokantaan on tallennettu kolme käyttäjää: admin (admin@tiketguru.com), myyjä (myyja_make@tiketguru.com) ja lipuntarkastaja (liisa@tiketguru.com). Salasanat käyttäjille on saatavilla tiimin jäseniltä. 

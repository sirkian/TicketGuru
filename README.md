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

**Lipuntarkastaja
- Lipuntarkastaja kirjautuu järjestelmään, jotta voi todentaa käytettävän lipun järjestelmästä. 

**Järjestelmä**
- Järjestelmä tunnistaa käyttäjän kirjautumisen perusteella, ja hakee tämän käyttöön käyttöoikeuksissa määritellyt toiminnot, jotta käyttäjä voi tehdä vain sen mihin hänellä on oikeuksia. Järjestelmä myös generoi lippuihin uniikkeja koodeja, jotka se osaa tunnistaa ja merkitä käytetyiksi. Järjestelmään mahtuu 500 eri tapahtuman tiedot. Myyntitapahtumat ja muu tapahtumahistoria tallentuu automaattisesti. Järjestelmä ei kaadu käyttäjän tekemiin virheisiin, esimerkiksi virheelliseen syötteeseen. 

**Käyttötapauskaavio**

![TicketGuru](https://user-images.githubusercontent.com/118562724/217886433-715e4284-3655-4b7f-827f-095d2e7d1ee5.png)


## Käyttöliittymä
**Lipunmyynti** toteutetaan valitsemalla tapahtumaan oikea määrä oikean lipputyypin lippuja ja vahvistamalla myyntitapahtuma. Vahvistuksen jälkeen järjestelmä näyttää tehdyn myyntitapahtuman tiedot, ja myydyt liput tulostusta varten.

![lipunmyynti](https://user-images.githubusercontent.com/118562724/216830185-57b29eff-eecc-4302-8de2-5e49887690b9.png)

**Tapahtumia hallitaan** yhteisnäkymästä, jossa tapahtumat on listattu. Näkymässä jokaista olemassa olevaa tapahtumaa voi muokata, sen lipputyyppejä voi tarkastella, muokata sekä lisätä, tai ottaa tapahtumasta myyntiraportin. Samasta näkymästä pääsee lisäämään uuden tapahtuman.

![tapahtumien_hallinta](https://user-images.githubusercontent.com/118562724/216830349-4b8a5827-883b-46ee-99d7-1b436aaf5558.png)

**Myyntiraportti** näyttää, montako mitäkin lipputyyppiä on tapahtumaan myyty, ja paljonko lipputuotot ovat per lipputyyppi sekä kaikki myydyt liput yhteensä. Raportin kautta pääsee selaamaan listaa tapahtuman myyntitapahtumista, joka näyttää jokaisen myyntitapahtuman ajan, uniikin id:n sekä yhteissumman.

![myyntiraportti](https://user-images.githubusercontent.com/118562724/216830550-99eab081-4e99-4e12-9a96-9f7a6185226d.png)

Wireframemallit on saatu asiakkaalta.

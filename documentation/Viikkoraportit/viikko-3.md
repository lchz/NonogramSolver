# Viikkoraportti 3

## Mitä olen tehnyt
Tällä viikolla olen saanut koko sovelluksen toimimaan, kun sille annetaan sovelluksen juurihakemiston polku ja pelin tiedoston nimi. Lisäsin muutamia pelin tiedostoja projektin toteuttamiseksi ja testaamiseksi. Olen myös laatinut uusille luokille yksikkötestejä.

## Mitä opin
Olen oppinut uutta algoritmia, AC3-algoritmia, jota pelin ratkaisemiseksi käytetään. Algoritmi toimii muuttujien, muuttujien arvojoukon ja rajoituksien yhteydessä. Arvojoukko määrittää, mitä arvoja muuttujan on mahdollistaa ottaa, mutta valintaan vaikuttaa myös jonkinlainen rajoitus. 

Nonogrammin ratkaisijalle toiminta on samanlainen. Yhdelle nonolohkolle voi olla monta yhdistelmää, jotka täyttävät tämän lohkon ehdot. Kuitenkin yhdistelmiä suljetaan vähitellen pois, kun vertaillaan eri lohkojen kesken ja yritetään saada kaikkien lohkojen ehdot täyttämään. Tämä operaatio toistuu, kunnes jokaiselle lohkolle jää yksi tai nolla vaihtoehtoa. Jos lohkolla ei ole yhtään vaihtoeihtoa, jolla kaikki ehdot täytetään, päädymme hylkäävään lopputilaan, eli pelillä ei ole ratkaisua. Muuten näkyy pelistä muodatama kuvio.

## Vaikeuksia
Tämän viikon vaikein asia oli uuden algorimin käsittäminen ja soveltaminen projektiin. Algoritmin ymmärtäminen ei ollut haastavaa. Sen soveltamiseen kuitenkin käytin enemmän aikaa ja paljon kokeilua.

## Mitä teen seuraavaksi
Seuraavaksi aion suunnitella omia tietorakenteita, esim. ArrayList. Sovelluksen aikavaativuus ja käytettyjä algoritmeja tullaan jo riittävän selväksi, ja määrittelydokumentti saadaan vihdoinkin täydentämään. Vertaisarviointi käynnistyy ensi viikolla, niin olisi myös hyvä aika laatia käyttöohje tässä vaiheessa.

## Ajankäyttö
12 tuntia
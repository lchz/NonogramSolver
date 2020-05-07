# Testausdokumentti

## Yksikkötestit

Ohjelmassa on toteutettu JUnit-yksikkötesteillä. Jokaista luokkaa, pääluokkaa lukuun ottamatta, on tehty testausluokka, joka sisältää yksikkötestejä käyttötapauksiin riippuen. Pääluokka on jätetty testaamatta, eikä sitä huomioida testikattavuudessa.

Yksikkötestien ajaaminen toimii komennolla `./gradlew test`. Testikattavuusraportti voi generoida komennolla `./gradlew test jacocoTestReport`.

### Nonogrammin ratkaisijan yksikkötestit
Kaikki ratkaisijan koostuvat luokat, muun muuassa Nonoblock, Nonoreducer ja Nonosolver, sisältävät yksikkötestejä.

#### Nonoblock
Lohkon testauksessa varmistetaan, että lohkon generoivat ratkaisun ehdokkaat ovat oikeita ja niiden lukumäärät täsmäävät.

#### Nonoreducer
Tässä testausluokassa varmistetaan, että ylimääräisten ehdokkaiden karsinta toimii oikein. Jokaisella kerralla on karsittava oikea määrä ehdokkaita. Jos saadaan loppujen lopuksi tyhjä lista, on palautettava -1.

#### Nonosolver
Varsinaisen ratkaisijan testausluokassa testejä suoritetaan ratkaisun piirtämiselle, jos sellainen ratkaisu on olemassa. Muuten on tulostettava `No solution`.


### IO yksikkötestit
IO testauspaketissa on testattu FileReader luokkaa, jossa hoitetaan pelin tiedoston lukemista ja datan poimintoa. Testausluokassa on toteutettu testit pelin nimen poiminnolle sekä rivien ja sarakkeiden tietojen lukemiselle.


### Tietorakenteiden yksikkötestit
Tietorakenteille on toteutettu tesit niiden yleisesti käyttäytymiselle. ComListille on toteutettu lisäysten ja poistojen toimivuudelle, sekä iteraattorille, jonka kautta varmistetaan for-loopin toimivan oikein. ComIteratorille on varsinaisesti toteutettu testejä iteroivan listan poiston toimivuudelle.


## Suorituskykytestaus
Suorituskykytestauksen lähdekoodi sijaitsee kansiossa `src/main/java/test`. Suorituksia on käyty 100 kertaa jokaista peliä kohten. Suorituskykytestausta voidaan suorittaa komennolla `./gradlew -q -console plain runTester`. Tässä on listattuna pelien keskimääräiset suoritusajat. Sovellus ei kuitenkaan pysty ratkaisemaan liian monimutkaisia pelejä, jossa peli kooltaan on liian suuri. Olemassa olevien pelitiedostojen mukaan kahta peliä ei saada ratkaistua, joista toinen on kooltaan 40 x 40 ja toinen 30 x 55.

|Peli    | Koko (leveys x korkeus) | Suoritusaika, ka (s) |
|:---------------:|:-------:|:------------:|
|different.non.txt| 20x20 | 0.194824486 |
|blender.non.txt  | 30x25 | 0.107006566 |
|dog.non.txt      | 8x9   | 0.007496123 |
|gnome.non.txt    | 27x34 | 0.0172733783|
|goat.non.txt     | 25x34 | 0.244884989 |
|heart.non.txt    | 15x15 | 0.024796876 |
|horse.non.txt    | 16x21 | 0.046682994 |
|rabbit.non.txt   | 15x15 | 0.037845554 |
|spade.non.txt    | 23x23 | 0.033163153 |
|test5.non.txt    | 5x5   | 0.003757788 |
|test10.non.txt   | 10x10 | 0.016928362 |
|test15.non.txt   | 15x15 | 0.032875215 |
|test20.non.txt   | 20x20 | 0.084324367 |
|ubuntu.non.txt   | 35x35 | 1.612942403 |
|wikimedia.non.txt| 39x28 | 1.188770042 |
|guilty.non.txt   | 25x30 | 0.116933260 |
|halloween.non.txt| 25x25 | 4.741648634 |
|nomageddon.non.txt| 20x30| 0.841957307 |
|iron.non.txt| 30x55 | - |
|john.non.txt| 40x40 | - |


## Testien toistoa
Kaikki testit paitsi suorituskykytestaus ovat Junit-yksikkötestejä ja ne voi suorittaa ilman mitään erityistä dataa.
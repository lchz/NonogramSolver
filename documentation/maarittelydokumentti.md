#  Määrittelydokumentti

## Projektin kuvaus

Nonogrammi on japanilainen ristikko, jossa on tarkoituksena värittää ristikon ruuduista vihjeiden avulla ruutuja[[Lähde 1](https://github.com/lchz/NonogramSolver/blob/master/documentation/maarittelydokumentti.md#l%C3%A4hteet)]. Esimerkiksi vihjeellä "1 2 5" tarkoitetaan, että rivillä on yksi yhden, yksi kahden ja yksi viiden värillisen ruudun ruuturyhmä. Niitä erotetaan tyhjillä ruutuilla. Sovelluksessa värillisiä ruutuja merkataan rastilla `x` ja muita pisteellä `.`. Toisin sanoen, jos vihje on 11x11 ristikossa, sillä rivillä on neljä mahdollista järjestystä: `x..xx.xxxxx`, `x.xx..xxxxx`, `x.xx.xxxxx.` tai `.x.xx.xxxxx`.

Projektin aiheenani on nonogrammin ratkaisija, jonka avulla voi ratkaista nonogrammin pelejä, jolla on ainoa ratkaisu tai ei ole tarkaisua ollenkaan. Ratkaisijan pitäisi ensiksi generoida kaikki mahdollisia järjestyksiä riveille, ja sitten karsia pois niitä järjestyksiä, jotka ovat ristiriitaisia keskenään. Lopuksi ratkaisija palauttaa ratkaisun tai ilmoittaa `No solution`.


## Algoritmit ja tietorakenteet

Ohjelmassa käytetään ArrayList tietorakennetta tallentamaan pelien tiedot.
Algoritmeja käytetään AC-3[[Lähde 2](https://github.com/lchz/NonogramSolver/blob/master/documentation/maarittelydokumentti.md#l%C3%A4hteet)] algoritmia oikeiden tulosten löytämiseksi.


## Ohjelman syötteet ja tulokset

Ohjelman syötteenä on tiedosto, jossa on pelin nimi, pelin leveys ja korkeus sekä pelin rivien ja sarakkeiden vihjeet. Tulokseksi piirretään pelin ratkaisu näkyviin tai ilmoitetaan `No solution`, jos peli on ratkaisematon.


## Aika- ja tilavaativuudet

Tätä selvitetään työn edetessä.


## Lähteet
1. [Wikipedia](https://fi.wikipedia.org/wiki/Japanilainen_ristikko) (13.3.2020)
2. [AC-3 algoritmi](https://en.wikipedia.org/wiki/AC-3_algorithm) (03.04.2020)

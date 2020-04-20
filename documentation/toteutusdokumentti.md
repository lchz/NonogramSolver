# Toteutusdokumentti

## Ohjelman rakenne
Ohjelma koostuu 4 moduulista, jotka on jaettu niiden tehtävän mukaisesti. 

Sovelluksen pääohjelman sijaitsevan `app` moduulin tehtävänä on yhdistää eri muita moduulia ohjelman toteutttamiseksi. Pääohjelma käyttää `io` moduulia käyttäjän kommunikointiin ja pelitiedoston lukuun. Moduuli `io` sisältää kahdenlaisia luokkia: `IO` ja `FileReader`. Luokan `IO` kautta käyttäjä saa valita pelin ja lopussa nähdä pelin tulosta. Pelin valittua luokka `FileReader` ottaa tarvittavia tietoja talteen pelitiedostosta, muun muassa rivien ja sarakkeiden vihjeet.

Varsinaiset pelin ratkaisijan muodostavat luokat sijaitsevat moduulissa `domain`. Kyseiselle moduulille on syötteinä luokan `FileReader` tallennettavat tiedot. Moduulin `domain` tehtävinä on ratkaista pelin, ja siirtää lopputuloksen moduulin `io` luokalle `IO` tulostettavaksi.

Moduuli `domain` taas käyttää moduulia `util` toteuttaa tietorakenteita. Luokka `ComList` vastaa Javan ArrayList:a ja `ComIterator` Iterator:a.

![image](https://github.com/lchz/NonogramSolver/blob/master/documentation/packageDiagram.png "Package diagram")

## Tietorakenteiden aika- ja tilavaativuudet
NP-täydellisyyden takia nonogrammin ratkaisijan aikavaativuus on O(2^n)[Lähde 1](https://github.com/lchz/NonogramSolver/edit/master/documentation/toteutusdokumentti.md#lähteet). Tilavaatisuutta on kuitenkin haastava arvioida, koska sen riippuvuus pelin kokoon tai annettujen vihjeiden monimuatkaisuuteen ei ole toistaiseksi tiedossa.

### Luokan ComList metodien aikavaativuus
- `add`, O(1). Jos listan tila on loppunut, sitä laajennetaan ajassa O(n) kutsumalla metodia `doubleSizeArray`
- `addAll`, O(n)
- `remove`, O(n)
- `contains`, O(n)
- `isEmpty`, `get`, `size`, O(1)

### Luokan ComIterator metodien aikavaativuus
- `hasNext`, `next`, `remove`, O(1)

## Suorituskyky
Tässä on listattuna pelien keskimääräiset suoritusajat. Suorituksia on käyty 100 kertaa jokaista peliä kohden. Sovelluksella ei kuitenkaan pystydä ratkaisemaan liian monimutkaisia pelejä, jossa peli kooltaan on liian suuri. Olemassa olevien pelitiedostojen mukaan kahta peliä ei saada ratkaistua sovelluksella, joista toinen on kooltaan 40 x 40 ja toinen 30 x 55.


|Peli    | Koko (leveys x korkeus) | Suoritusaika, ka (s) |
|:---------------:|:-------:|:------------:|
|different.non.txt| 20x20 | 0.194824486 |
|blender.non.txt  | 30x25 | 0.107006566|
|dog.non.txt      | 8x9   | 0.009145199 |
|gnome.non.txt    | 27x34 | 0.0172733783 |
|goat.non.txt     | 25x34 | 0.244884989 |
|heart.non.txt    | 15x15 | 0.024796876 |
|horse.non.txt    | 16x21 | 0.046682994 |
|rabbit.non.txt   | 15x15 | 0.037845554 |
|spade.non.txt    | 23x23 | 0.033163153 |
|test5.non.txt    | 10x10 | 0.003220731 |
|test15.non.txt   | 15x15 | 0.032875215 |
|test20.non.txt   | 20x20 | 0.084324367 |
|ubuntu.non.txt   | 35x35 | 1.612942403 |
|wikimedia.non.txt| 39x28 | 1.188770042 |
|guilty.non.txt   | 25x30 | 0.116933260 |
|halloween.non.txt| 25x25 | 4.741648634 |
|nomageddon.non.txt| 20x30| 0.841957307 |
|iron.non.txt| 30x55 | - |
|john.non.txt| 40x40 | - |

## Puutteet ja parannusehdot
Sovelluksen isoin puute on sen ulkonäkö. Tässä JavaFX olisi hyvä työkalu toteuttaa sovelluksen graafista esitystä. Sovellus voidaan toki laajentaa siten, että ensiksi käyttäjä pystyy itse ratkaisemaan peliä. Pelin tulos voi tarvittaessa näkyä painiketta painaamalla.

## Lähteet
1. http://fse.studenttheses.ub.rug.nl/15287/1/Master_Educatie_2017_RAOosterman.pdf

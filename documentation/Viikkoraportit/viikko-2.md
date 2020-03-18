# Viikkoraportti 2

## Mitä olen tehnyt

Tällä viikolla laadin ratkaisun yksittäisille nonoblohkoille lohkon pituuden ja vihjeiden avulla. Olen laatinut myös testejä permutaatioiden generoinnille. Tämä metodi on perus elementti pelin ratkaisijalle.

Vaihdoin myös projektin mavenista gradleksi, koska minulle asetukset Jacocosta ja CircleCI:sta ovat tutumpia gradlessa kuin mavenissa.

## Mitä opin

Olen oppinut yksittäisen nonolohkon algoritmia, joka alkaa lohkon oikealta löytämään sopivia permutaatioita. Algoritmin alussa etsitään rekursiivisesti lohkon oikeanpuoleisimpia soluja nollille. Nollien täyttämä osalohko muodostaa niin sanotusti "hännän", jonka eteen liitetään ykkösiä ja nollia. Ykkösten lukumäärä luetaan listan ensimmäisen alkion mukaisesti ja nollien lukumäärä on määrätty metodin parametrissa. Näin taas muodostuu pitempi "häntä". Tämä prosessi toistuu kunnes kaikki rekursiot on käyty läpi. On kuitenkin kaksi poikkeustilannetta, joissa ratkaisuja ei ole olemassa. Toisessa tilanteessa alun perin vihjeistä muodostaman listan alkioiden summa on suurempi kuin lohkon pituus. Tämä tarkoittaa vihjeiden vaatimien solujen lukumäärä ylittyvän lohkon ulkopuolelle. Toisessa lohkon pituus taas ei riitä vihjeiden täyttämiseen.

## Vaikeuksia

Vaikka olen jo tutustunut CircleCI-ohjelmistoon aikaisemmin, törmäsin edelleenkin ongelmaan buildatessani projektia. Aluksi CircleCI väitti ettei löytänyt jotain symbolia koodissani, vaikka projektini toimi lokaalisti sujuvasti. Sitten kun käytin Javan tarjoaman metodin repeat() sijasta oman rakentamaa algoritmiani, on projekti buildattu onnistuneesti.

Lisäksi huomasin, että voi joskus olla haastava pyrkiä selittämään algorimia selkeästi pelkin sanoin. Toivottavasti edellinen kuvaus on jossain määrin riittävä ja ymmärrettävä.

## Mitä teen seuraavaksi

Seuraavaksi aion laajentaa projektia siten, että se pystyy sulkemaan pois ne ratkaisut, jotka eivät sovi yhteen, kun syötteenä on useampi lohkoja.

## Ajankäyttö

8 tuntia.
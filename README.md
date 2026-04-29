Java/Swing pankkiautomaatin mallinnus
AUTHORS: Niko Rantamäki, Frans Latikka

Kyseisen java-projektin ideana ollut mallintaa perinteistä pankkiautomaattia, sen grafiikkaa ja toiminnallisuutta. Projekti koostuu 12 java-luokasta ja yhdestä .txt-tiedostosta, joka toimii kyseisessä mallinnuksessa pankkikorttina.


12 java luokkaa:
ATMFrame.java 3KB
EtuSivuPaneeli.java 6KB
KiitosKaynnistaPaneeli.java 2KB
KirjauduPaneeli.java 7KB
KortinLukija.java 3KB
LopetaKayttoPaneeli.java 3KB
Main.java 1KB
NostoPaneeli.java 15KB
OtaKuitti.java 2KB
OtaMassitPaneeli.java 2KB
SaldoPaneeli.java 7KB
TapahtumatPaneeli.java 6KB

Erilliset tiedostot:
1234.txt

ATMFrame.java:
luokan idea on koota kaikki paneelit yhteen. Kyseisessä luokassa rakennetaan ja ohjataan kaikkia projektissa olevia paneeleja.

EtuSivuPaneeli.java:
luokka toimii etusivu paneelina automaatille. Kyseisestä luokasta pääsee navigoimaan kaikkiin muihin toimintoihin.

KiitosKaynnistaPaneeli.java
luokka on viimeisin paneeli, mitä käyttäjä näkee. Siinä on ajastin, joka sen päätyttä ohjaa käyttäjän automaattisesti takaisin kirjaudupaneeliin

KirjauduPaneeli.java
Luokka on ensimmäinen paneeli, mitä käyttäjä näkee. Luokkaan on sovitettu näppäinkenttä mallintamaan fyysistä automaatin näppäimistöä. Luokka autentikoi käyttäjän syötetyn pinkoodin ja txt-tiedoston perusteella

LopetaKayttoPaneeli.java
Luokan tarkoitus on kysyä käyttäjältä haluaako hän varmasti lopettaa käytön, vai palata takaisin etusivulle

Main.java
luokka ei näy käyttäjälle. Kyseinen luokka on vain käynnistämässä sovelluksen

NostoPaneeli.java
Luokka on nostotoiminnon paneeli. Luokassa pystyy nostamaan rahaa. Luokkaan on sovitettu näppäinkenttä mallintamaan fyysistä automaatin näppäimistöä, mikäli hän haluaa eri summan, kuin valmiiksi annetuissa valinnoissa on tarjolla.

OtaKuitti.java
Luokka on tapahtumapaneelin jälkeinen paneeli, mikäli käyttäjä valitsee nostaa kuitin tapahtumistaan

OtaMassitPaneeli.java
Luokka on nostotapahtuman jälkeinen paneeli, jossa käyttäjää kehotetaan ottamaan nostamansa rahat automaatista.

SaldoPaneeli.java
Luokka on tarkoitettu saldon tilin saldon tarkasteluun. Luokka lukee käyttäjän pankkikortin eli txt-tiedoston ja näyttää sen tiedot näytöllä

TapahtumatPaneeli.java
Luokka on tarkoitettu tapahtumien tarkasteluun. Mallinnuksessa ei voi tarkastella tapahtumia näytöltä, mutta kuitin voi nostaa.

Erilliset Tiedostot:

1234.txt
Toimii ns pankkikorttina. tiedoston nimi on pinkoodi. Ensimmäisellä rivillä on käyttäjän ns tilinumero, toisella rivillä saldo ja kolmannella nostoraja.







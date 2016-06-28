Lisädokumentaatio

-Ohjelma koostuu seuraavista vaiheista: Kartan pisteiden muodostaminen kartaksi, baarien välisten etäisyyksien laskeminen ja lopuksi kauppamatkustaja-tyyppisenä ongelmana parhaan reitin laskeminen. Ainoa näistä vaiheissa, joissa optimointi voi vaikuttaa on viimeinen kauppamatkustaja-vaihe. Tämä johtuu siitä, että kaikki etäisyydet baarien välillä on pakko laskea. Siinä ei siis voi säästää aikaa. 

- Ohjelma toimii parhaiten syötteillä, joissa paras reitti lasketaan alussa. Tällöin loppujen reittien laskenta lopetaan mahdollisimman ajoissa kun niistä tulee kalliimpia kuin paras reitti.

-Ohjelma toimii huonoiten syötteillä, jossa reitit lasketaan huonoimmasta parhaimpaan. Tällöin jokainen reitti on pakko laskea loppuun asti.

-Pseudokoodin ja todellisen koodin välillä ei ole suurta ongelmia.

- Optimointi-idea: Kauppamatkustaja-vaiheessa reittien muodostamisjärjestyksen muuttaminen. Esimerkiksi niin että aletaan laskemaan ensiksi niitä baareja jotka ovat lähellä avaussolmua. Tällöin kun käydään for loopilla paikkoja läpi, todennäköisimmin päästään käymään nopeammin parhaaseen reittiin koska aloituspaikasta on usein huono lähteä koordinaattiin joka on kaukana siitä. 

-Optimointi toimii parhaiten kun aloitus ja lopetuspaikka ovat kaukana toisistaan. Tällöin optimoidussa taulukossa alussa ovat ne baarit jotka ovat lähellä aloituspaikkaa ja lopussa ne jotka ovat lähellä lopetuspaikkaa, jolloin rekursiivisesti löydetään ensin "järkevämmät" reitit. Jolloin kun käydään lopussa hulluja reittejä läpi , niiden läpikäynti lopetetaan ajoissa kun huomataan että reitti ei voi olla nopein.

-Juomalista- ominaisuudessa baareilla on juomien hinnat. Tällöin paras reitti on halvimmat baarit, joista lasketaan nopein reitti. Tätä en ehtinyt koodata käyttöliittymään. 


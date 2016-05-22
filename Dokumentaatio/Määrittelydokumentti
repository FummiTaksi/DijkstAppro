DijkstAppro

-Laskee käyttäjälle parhaan reitin Approlla. Approreitti koostuu baareista, jotka ovat verkossa. Approreitti alkaa  aloituspisteestä ja loppuu jatkopaikkaan. 

-Baarit, aloituspiste ja jatkopaikka ovat kaikki koordinaatistossa.

-Ohjelma saa kartan, jossa on baarien, aloituspisteen ja jatkopaikan koordinaatit. Kartassa on teitä, jotka muodostetaan esteillä. Kehittyneemmässä versiossa myös baarien juomien hinnat.

- Baarien tiedot tallennetaan HashMappiin: Jos baarin koordinaatit ovat x= 3, y =7, niin Mapin avaimella 37 saa baarin tiedot: nimi, juomien tiedot listassa ja toki myös koordinaatit.


-Perustoiminnallisuus : Nopein reitti(Keskitytään vain baarien etäisyyksiin), esimerkiksi: nopein reitti aloituspaikasta jatkopaikkaan käymällä läpi 10 baaria. Edistyneempää toiminnnallisuutta: Halvin reitti (aluksi jokaisella baarilla vain yksi juoma.)

- Kehittyneempi toiminnallisuus : Nopein reitti jossa on tietty baari, reitin valinta tietyillä juomavalinnoilla (Lisätään baareihin erilaisia juomavalintoja.) , Nopeimman reitin muuttaminen halvemmaksi, nopeimman reitin löytäminen tietyllä budjetilla. 

- Aikavaativuus nopeimman reitin etsimiseen :n on baarien( mukaanlukien aloitus ja jatkopaikka) määrä. Aluksi lasketaan A*:llä jokaisen baarin etäisyys toiseensa(myös aloitus ja jatkopaikka) .Tähän kuluu aikaa n*n (Kaarien lukumäärä) . Tämän jälkeen etsitään paras reitti esim Floyd Warshalilla jonka aikavaativuus n*log n . Kokonais aikavaativuus siis  O (n*n +n log n).

-Tavoitteena 5 opintopisteen laajuinen harjoitustyö. 





-Koodaan Javalla

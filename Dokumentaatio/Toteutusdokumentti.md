Ohjelman yleisrakenne:
 
-Ohjelma laskee tekstitiedostossa olevasta kartasta nopeimman approreitin. Ensin ohjelma muodostaa kartasta verkon laskemalla A*-algoritmilla jokaisen baarin etaisyyden toisistaan. Taman jalkeen algoritmi ratkaisee kauppamatkustajan ongelman : Mika on lyhyin reitti laskemalla kaikki mahdolliset reitit.

- Aikavaativuus : A* algoritmin aikavaativuus on O(x*y) jossa x on kartan leveys ja y kartan korkeus. Tämä toistetaan (b ncR 2) kertaa , jossa b on baarien maara : eli kaikki kahden kombinaatiot jotka baareista saadaan. Eli kun verkko on muodostettu aikavaativuus on O ((b ncr 2) * x*y) Taman jalkeen ratkaistaan kauppamatkustajaongelmana lyhin reitti, jossa on b! vaihtoehtoa. Siis koko algoritmin aikavaativuus on O ( x*y* (b ncR 2) + b!)

- Tilavaativuus on sama kuin aikavaativuus.

- Mikali ehdin toteuttaa: Nopein reitti siten että käydän k:ssa baarissa (k < b) jossa b on baarien maara.

- Lahteet :  http://stackoverflow.com/questions/1715401/why-is-the-complexity-of-a-exponential-in-memory

https://en.wikipedia.org/wiki/A*_search_algorithm

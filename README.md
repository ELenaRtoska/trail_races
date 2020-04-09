# trail_races
Project web(Spring boot and React)

Елена Ртоска 171200

Семинарска по предметот Веб програмирање на ФИНКИ

Тема: 

"(Trail) races plan per year"

Опис:

Семинарската се однесува на годишен план на (треил) трки, со тоа што сите можни трки се понудени на еден сајт вклучувајќи и краток 
опис така што може да се направи регистрација на сите трки кои се одржуваат еднаш годишно. 

Организаторите можат да ги внесат трките на овој сајт со цел да нема поклопување на настани кога ги закажуваат, а тркачите
да си одберат кои трки би ги трчале во конкретната сезона  регистрирајќи ги.
Опфатен е описот на треил трките и треил трчањето, како и сите карактеристики кои може да ги има една треил трка.

Семинарската опфаќа backend изработен како Spring Boot апликација и frontend изработен во React, Hibernate база во која има 6 табели кои
се поврзани меѓу себе со неколку @ManyToOne и @ManyToMany врски. 

Вклучени се сите концепти кои се изучени по предметот HTML, слоевит дизајн, управување со состојби, persistence (JPA и Spring Data) и
Responsive Design.

Покрај концептите кои се изучени по предметот вклучени се и други функционалности, како што се: 
Интеграција на календар во апликацијата и библиотеката highcharts.js(една line-chart и една pie-chart).


Упатство за стартување на back-end и front-end апликациите:

Најпрво потребно е да се изврши апликацијата ( десен клик на TrailRacesProjectApplication -> Run "TrailRacesProjectApplication").

-Back-end се стартува на http://localhost:8080/

-Базата се стартува на http://localhost:8080/h2 и на таа адреса треба да се направат следните поставки:
1) Saved Settings: Generic H2 (Embedded)
2) Setting Name: Generic H2 (Embedded)
3) Driver Class: org.h2.Driver
4) JDBC URL: jdbc:h2:mem:testdb
5) User Name: sa
6) Полето за Password треба да е празно
Сега конектирајте се со базата -> Conect

-Front-end може да се стартува преку терминал (View -> Tool Windows -> Terminal или alt+F12). Во Terminal се пишуваат следните команди:
1) cd frontend
2) npm install
3) npm start
Со третиот чекор front-end апликацијата е стартувана на http://localhost:3000/






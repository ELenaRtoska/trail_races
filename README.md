## Елена Ртоска 171200
## Семинарска по предметот „Веб програмирање“ на ФИНКИ

### Тема: 
"(Trail) races plan per year"

### Опис:
Семинарската се однесува на годишен план на (треил) трки, со тоа што сите можни трки се понудени на еден сајт вклучувајќи и краток 
опис така што може да се направи регистрација на сите трки кои се одржуваат еднаш годишно. <br />
Организаторите можат да ги внесат трките на овој сајт со цел да нема поклопување на настани кога ги закажуваат, а тркачите
да си одберат кои трки би ги трчале во конкретната сезона  регистрирајќи ги. <br />
Опфатен е описот на треил трките и треил трчањето, како и сите карактеристики кои може да ги има една треил трка кои може да се едитираат или да се отстранат доколку веќе не припаѓаат на треил трките. <br />
Семинарската опфаќа backend изработен како Spring Boot апликација и frontend изработен во React, Hibernate база во која има 6 табели кои
се поврзани меѓу себе со неколку @ManyToOne и @ManyToMany врски. <br />
Вклучени се сите концепти кои се изучени по предметот: HTML, слоевит дизајн, управување со состојби, persistence (JPA и Spring Data) и
Responsive Design. <br />
Покрај концептите кои се изучени по предметот вклучени се и други функционалности, како што се: <br />
Интеграција на календар во апликацијата и библиотеката highcharts.js(една line-chart и една pie-chart).

### Упатство за стартување на back-end:
1) Отворете го проектот во IntelliJ IDEA
2) Импортирајте ги зависностите од pom.xml (Import changes)
3) За да ја извршите апликацијата отворете <br />
```src -> main -> java -> elena.rtoska.trail_races_project -> TrailRacesProjectApplication```
4) Десен клик на TrailRacesProjectApplication -> Run "TrailRacesProjectApplication"
5) Back-end се стартува на http://localhost:8080/

### Упатство за стартување на front-end:
1) Откако ја извршивте апликацијата, отворете терминал: <br />
```View -> Tool Windows -> Terminal``` или ```alt+F12```
2) Преку терминал влезете во папката frontend со командата: <br />
```cd frontend```
3) Инсталирајте ги потребните зависности со командата: <br />
```npm install```
4) Откако ќе се инсталираат потребните зависности, стартувајте ја апликацијата со командата: <br />
```npm start```
5) Front-end апликацијата е стартувана на http://localhost:3000/

### Упатство за стартување на базата:
-Базата се стартува на http://localhost:8080/h2 и на таа адреса треба да се направат следните поставки:

![tt](https://user-images.githubusercontent.com/48455819/79077178-c6152280-7cff-11ea-97c8-c765df887a36.png)

Сега конектирајте се со базата -> Conect

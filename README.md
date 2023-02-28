Before all:
Make two schemas in postgres database:
finology_car & db_car_mg2
then change user name and password of db in apllications.


My implementation consist of two stack:1-spring boot – 2-Quarkus



1-spring boot :

a-with inheritance:
api for challenge : http://localhost:8090/carinh/getByCarType/ELECTRICAL

b-without inheritance:
api for challenge : http://localhost:8090/car/v1/getByCarType/ELECTRICAL


Swagger : http://localhost:8090/swagger-ui/index.html#/


2-Quarkus:
Api for challeng(get cars by type) : http://localhost:8080/car/findByCarType/ELECTRICAL
Swagger(for test api) :  http://localhost:8080/q/swagger-ui/


Stacks:
Java 17-Spring boot 3-spring data-hibernate envers-lombok-mapstruct-swagger-junit-mockito
Quarkus-panache entity-swagger

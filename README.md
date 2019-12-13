# Oneflow Sample BE Project
 Sample Interview Project.

### Installation
Clone repository

Find the  folder where pom.xml located.
  ```sh
     $ cd oneflow
  ```

Steps to Test : 
```sh
$ mvn test
```
Steps to Run :
```sh
$ mvn spring-boot:run
```

### DB & Port

* For this sample project Embeded MongoDB was used
* For monitoring    
     dbname : test_1    
     dbport : 37000
* Application works at default localhost:8080
### Infrastructre

* Spring Boot, Java 8 based, Maven, MongoDB, Junit & Mockito , JaCoCo for coverege

### Swagger UI : 
  http://localhost:8080/swagger-ui.html     
  Application Endpoints documented via Swagger .
### Test Reports :

After running the test, you can find the test coverage reports which JaCoCo plugin provided by opening the file which is under target/site/jacoco/index.html

### Suggestion For Improvements :  
 - This is a sample project based on creation of product and ordering these product by one by. In real system, ordering mechanism should cover thread safe, async and concurrent implementation (like CompleteableFuture with suitable thread pool)
 - User auth mechanism shoul be implemented (using LDAP, security config and JWT).
 - Far way better coverege with A LOT OF TEST 
 - Real Mongo can be supported one of open source RDBMS, this relation can be seperated with using proper Facade Pattern and of course Profiles. 


 




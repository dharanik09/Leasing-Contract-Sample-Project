# amg_leasing_sample_project
Allane SE Project 

I will show you how to build a full-stack (Java 11 + Spring Boot version '2.7.4' + Angular 14) and MySQL as a database example with a Leasing Constract Code-Challenge
Application. The back-end server uses Spring Boot, JPA Data for REST APIs, front-end side is an Angular 14 App with HttpClient and Form Module. 

**Back-End Development 


import backend file of spring boot project in your tool (eclipse... or...)

![image](https://user-images.githubusercontent.com/9589710/200411523-a4ca3428-0c52-47c8-acac-d00510e783ba.png)

Run Spring Boot application
mvn spring-boot:run
The Spring Boot Server will export API at port 8083.


**Configure Spring Datasource, JPA, Hibernate** 

Change the data base password in the folder of src/main/resources folder, open application.properties and write these lines.

spring.datasource.url= jdbc:mysql://localhost:3306/testdb?useSSL=false
spring.datasource.username= root
spring.datasource.password= 


**Front-End Development**
Run ng serve for a dev server. Navigate to http://localhost:4200/. The app will automatically reload if you change any of the source files.

Run Angular Client
npm install
ng serve --port 4200



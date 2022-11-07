# amg_leasing_sample_project
Allane SE Project 

I will show you how to build a full-stack (Java 11 + Spring Boot version '2.7.4' + Angular 14) and MySQL as a database example with a Leasing Constract Code-Challenge
Application. The back-end server uses Spring Boot, JPA Data for REST APIs, front-end side is an Angular 14 App with HttpClient and Form Module. 

Please find the DB.sql, backend and frontend in respective branches. (main, backend-amg and frontend-amg)

**DB Development**

Step 1. Import amg DB.sql file into your mysql table. and i am not using docker.

![image](https://user-images.githubusercontent.com/9589710/200413769-d5ac9b24-9a36-4da0-86eb-9d892012aa9e.png)


**Back-End Development 


1. import backend file of spring boot project in your tool (eclipse... or...)

![image](https://user-images.githubusercontent.com/9589710/200411523-a4ca3428-0c52-47c8-acac-d00510e783ba.png)

2.


**Configure Spring Datasource, JPA, Hibernate** 

2. Change the data base password in the folder of src/main/resources folder, open application.properties and write these lines.

spring.datasource.url= jdbc:mysql://localhost:3306/testdb?useSSL=false
spring.datasource.username= root
spring.datasource.password= 

3. Run Spring Boot application
mvn spring-boot:run
The Spring Boot Server will export API at port 8083.

4. Overview
These are APIs that Spring Boot App will export:

Methods	Urls	Actions
POST	(http://localhost:8083/api/customer)	create new customer

![image](https://user-images.githubusercontent.com/9589710/200412541-18a1a5c0-7048-4b48-b826-175c18d89f16.png)

POST	(http://localhost:8083/api/vehicle)	create new vehicle

![image](https://user-images.githubusercontent.com/9589710/200412662-40d2233f-493e-4d66-9a9e-09a73d12d495.png)

Post (http://localhost:8083/api/leasingcontract)	create new leasing 

![image](https://user-images.githubusercontent.com/9589710/200412819-217b5fcf-5c74-4306-b160-4d5d6046c48e.png)

Get http://localhost:8083/api/getLeasingContratDetails Get All leasing Details.

![image](https://user-images.githubusercontent.com/9589710/200413093-a3506c55-4695-4da3-866c-128a7013772a.png)


**Front-End Development**
Step 1. import src folder of amg front end in angular 14 and i am not push node_module folder in git. 

Run ng serve for a dev server. Navigate to http://localhost:4200/. The app will automatically reload if you change any of the source files.

Run Angular Client
npm install
ng serve --port 4200



![image](https://user-images.githubusercontent.com/9589710/200413890-d205fd2e-f1aa-4526-9b3f-f7ccb71fb946.png)


![image](https://user-images.githubusercontent.com/9589710/200413962-52fd48df-72b6-4942-95b2-0547506a3750.png)

![image](https://user-images.githubusercontent.com/9589710/200414043-b1f44e66-f302-4f8e-b985-df33e185eb56.png)


![image](https://user-images.githubusercontent.com/9589710/200414142-18acb4b4-7fac-47d3-913a-1606b6885c9f.png)






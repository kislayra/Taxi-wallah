# **Taxi-Wallah:**
This project is a Taxi Booking System built using Spring Boot with Java and Jakarta API. The application includes various features like user authentication, car booking, and management. It employs MySQL for the database, Thymeleaf for the front-end, and runs on a Tomcat Server. 

## **Technologies Used**
### •	Spring Boot 
### •	Java 
### •	Hibernate
### •	Jakarta API
### •	MySQL
### •	Spring Tool Suite (STS) IDE
### •	Tomcat Server
### •	Thymeleaf
### •	Maven
### •	Spring Security


## **Running the Application**
1.	Start the MySQL server.
2.	Run the Spring Boot application from the folder src/main/java/com/example/Taxiwallah1Application.java
3.	Access the application through http://localhost:8080

## How to set up database:
Go MySQL Workbench.
Create database taxibooking.
set password of your MYSQL server into src/main/resources/application.properties this file.
Run this project on any IDE(eg. Intellij idea) 
all the tables will be created automatically

## How to run Application:
open and run this file in your project src/main/java/com/example/Taxiwallah1Application.java
this should start the frontend as well as the backend server.
your wewbsite should be accesible on this "http://localhost:8080/" link.

## How to fetch all data: Admin Section
you can fetch all data like contact details or booking details using the admin dashboard
endpoint for the admin dashboard is "http://localhost:8080/admin/dashboard"
you have to enter you admin username and password to access it.
By default 
#### username : admin 
#### password : admin123

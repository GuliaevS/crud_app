## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)

## General info
This is a simple CRUD application made to practice programming skills. 
The project works with clients and their roles.
	
## Technologies
Project is created with:
* Java 21
* Spring Boot 3.2.3
* PostgreSQL 14
* Liquibase 4.25.1
	
## Setup
To run this project, install it locally using ItelliJ IDEA and send requests using Postman
* To create client
```
http://localhost:{8080}/api/create
```
* To find cient with id
```
http://localhost:8080/api/find/{id}
```
* To find all cients from db
```
http://localhost:8080/api/findAll
```
* To update client
```
http://localhost:8080/api/update
```
* To delete client with id
```
http://localhost:8080/api/delete/{id}
```

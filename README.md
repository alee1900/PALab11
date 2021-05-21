# PALab11

## REST Services
Continue the application created at the previous lab integrating the following functionalities:

Create a database in order to store the persons and their social network relationships.
Implement REST services needed to comunicate with the database (CRUD).
The main specifications of the application are:

## Compulsory
- Create a Spring Boot project containing the REST services for comunicating with the database.
- Create the class Person.
- Create a REST controller containing methods for:

obtaining the list of the persons, via a HTTP GET request.

adding a new person in the database, via a HTTP POST request.

modifying the name of a person, via a HTTP PUT request.

deleting a person, via a HTTP DELETE request.
- Test your services using the browser and/or Postman.

I have solved everything in compulsory.

## Optional
- Create REST services for inserting and reading relationships.
- Create services for determining the first k most/least connected (popular) persons in the network.
- Integrate the services into your previous project, invoking them using the support offered by Spring Boot.
- Handle the exceptions using a RestControllerAdvice.

I have solved the first and last bullet points in optional.

## Bonus
- Write a service that determines in linear time all persons who are so important to the social network such that, if one of them were eliminated, the network would become disconnected.
- Document your services using Swagger or a similar tool.
- Secure your services using the HTTPS protocol and JSON Web Tokens

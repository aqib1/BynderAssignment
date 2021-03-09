# BynderAssignment
Assignment: Unsplash SDK for JAVA

### Prerequisite:
- Java JDK 15
- Docker (in the case you directly want to run application)

### Docker
The application contain docker file and run shell script as well so in the case if docker is running on your system. You just need to run dockerrun.sh file and boom application can be accessible on port 8080

### Testing
The application is made with the spring of TDD, and that is the reason it contains a lot of unit tests. Integration test are also added. Unit and integration tests both are added in seperate directories you can find.

### Technologies
- Java 15
- Spring boot & Rest
- Rest template
- Spring AOP
- Springfox  
- TDD & Integration testing
- Junit5
- Mockito And MockMVC
- Openpojo
- Apache commons
- Lombok
- Initialization On Demand Holder Pattern
- Builder Pattern
- Single Responsibilities
- Docker

### Clean And Build
mvn clean install

### Build And Test
mvn clean test

### Swagger URL
please see the link for detail of all APIs http://localhost:8080/swagger-ui/#/
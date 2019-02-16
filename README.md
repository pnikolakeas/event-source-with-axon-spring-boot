# Project Title

Implementing Event Sourcing with Axon and Spring Boot

### Installing

1. Clone the GIT Repository.

2. Build the Project.

3. Run the Application: The command: clean package spring-boot:run will do the trick.
 
4. Once starts up, visit http://localhost:8080/swagger-ui.html to test the REST apis.

5. Easily check data in h2-console. Visit: http://localhost:8080/h2-console JDBC URL Connect: jdbc:h2:mem:testdb
   Example query: SELECT PAYLOAD_TYPE, AGGREGATE_IDENTIFIER, SEQUENCE_NUMBER, PAYLOAD FROM DOMAIN_EVENT_ENTRY

## Deployment

A typical Spring Boot Application based on H2 in-memory database and AxonFramework [https://axoniq.io/]

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Contributing

Please read http://progressivecoder.com



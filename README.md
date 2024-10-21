<h1>Parcel-Handler Application </h1>

---
<h3>What does this Application do?</h3>

- stores predefined data in an H2 database _(regarding `Clients`, `Parcels` and `TrackingEvents`)_
- automatically populates the database when application starts
- offers a set of [Endpoints](#Endpoints) to retrieve this data
- responds with data in `JSON` format

---
<h3>Project Settings </h3>

- Language: Java 17
- Language level: 17 - Sealed types, always-strict floating-point semantics

---
<h3>Technologies & Tools </h3>

- Spring Boot (v3.3.4)
- H2 database
- Liquibase
- Mapstruct
- OpenApi (Swagger) (v3)


---
<h3>Building the Application </h3>

- To build the project, use Maven with this command: `mvn clean install`


---
<h3>Running the Application </h3>

- __Option_1__: use IntelliJ IDEA's Run Configuration
- ___[NOTE]___: _The application utilizes annotation processors (e.g., Lombok, MapStruct, Therapi), so annotation processing may need to be enabled in your IDE settings, depending on your version of IntelliJ IDEA._


- __Option_2__: 
  - [1] open a terminal and navigate to the project's root directory
  - [2] run the command: `java -jar target/parcel-handler-0.0.1-SNAPSHOT.jar`


- __Option_3__:
  - [1] after building the project, copy the `parcel-handler-0.0.1-SNAPSHOT.jar` file to a desired location  
  - [2] open a terminal and navigate to that folder
  - [3] run the command: `java -jar parcel-handler-0.0.1-SNAPSHOT.jar`


- Upon successful startup, the [Endpoints](#Endpoints) will be available on port `8081`.

---
<h3>Endpoints</h3>

- upon successful startup, you can access the built-in Swagger UI at: [http://localhost:8081/parcel-handler/swagger-ui.html](http://localhost:8081/parcel-handler/swagger-ui.html) 
- here you can explore all endpoints and their detailed explanations
- the Swagger UI also allows you to interactively test each endpoint
- feel free to explore and have fun! 😊
- __[H2 Console]__: During runtime, you can access the `H2-concole` here: [http://localhost:8081/parcel-handler/h2-console](http://localhost:8081/parcel-handler/h2-console) _(username: `user`, pass: `password`)_

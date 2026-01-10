## How does dependency injection work in Spring Boot internally?
In Spring boot, the dependency injection is handled by IoC container. 

When the application start spring scan for the classpath for components, creates bean defination, instantiates the require beans, resolve their dependencies, and inject them at the runtime using reflection. 

This allow objects to be loosly coupled and fully managed by the spring container.

# **Annotations**

@PrePersist is used to execute logic automatically before an entity is persisted into the database.

| **Annotation** | **When it Runs**                                |
| -------------- | ----------------------------------------------- |
| `@PrePersist`  | Before the entity is inserted into the database |
| `@PostPersist` | After the entity is inserted into the database  |
| `@PreUpdate`   | Before the entity is updated in the database    |
| `@PostUpdate`  | After the entity is updated in the database     |
| `@PreRemove`   | Before the entity is deleted from the database  |
| `@PostRemove`  | After the entity is deleted from the database   |



## Database connection

1️⃣ Add database *dependency (driver)*

2️⃣ Add *JPA / DB starter*

3️⃣ Configure *connection details*

4️⃣ Create *Entity class*

5️⃣ Create *Repository*

6️⃣ Run application 🚀


# ORM (Object Relational Mapping)

## JDBC 
Lowest level, Java API to talk directly to DB using SQL. Too much boilerplate. manual mapping error-pron, hard to maintain. 

And it's mostly used in legacy system. and for very complex queries and batch processing.

*Connection con = DriverManager.getConnection(...);*

*PreparedStatement ps = con.prepareStatement("SELECT * FROM users");*

*ResultSet rs = ps.executeQuery();*

## JPA and Hibernate
JPA is a specification(interface + rules) defines how ORM should work and Hibernate is the implementation, does actual DB work.

## Spring Data JPA 

Spring Data JPA is wrapper JPA + Hibernate 

**To avoid SQL Injection we use prepared statements in JDBC and in JPA/Hibernate preparedStatement internally use**


### How is SQL Injection avoided
We use Spring Data JPA with parameterized queries and prepared statements. Since query parameters are bound safely by JPA, user input is never directly concatenated into SQL, which prevents SQL injection attacks.


### Why JPA over JDBC
JPA reduces boilerplate code, provides ORM mapping, handles transactions, prevents SQL injection, and improves maintainability. JDBC requires manual SQL, result mapping and error handling, which is error-prone in large application. 


### N + 1 Problem
N+1 occurs when Hibernate executes one query for parent and multiple queries for child entities. It can be solved using join fetch, entity graph, or optimized queries.


## @Transactional 
Transactional annotations open DB transaction, commits if success and Rollbacks on exceptions.

Work only on public method and rollback only for runtime exception


# **API** 

API Stands for Application Programming Interface. It is a mechanisms that enables two software to communicate with each other. 

There are four different ways API can work

1. **SOAP APIs** : Simple Object Access Protocol. Client and server exchange messages using XML.
2. **RPC APIs** : Remote Procedure Calls. The client complete the function in server and then server send back the output to the client.
3. **WebSocket API** : A WebSocket API support two-way communication between client app and server. This happens based on events and very helpfull in applications like chats, live streaming. 

    Initial communication starts with http and then server handshake happens and it upgrade to websocket where the connection will always be connected until anyone disconnect it.
4. **Rest API** : The client sends requests to the server as data. The server uses this client input to start internal functions and returns output data back to the client.


# *Rest API*
## Best practice to write the REST API
using proper http methods like get, post, update, etc. using proper http status code, proper error handling. versioning the api. avoiding returning the huge list better to provide query parameters. securing the api by having authentication, authorization


## **Stages of API Lifecycle:**

Design: Define contracts using tools like OpenAPI (Swagger), including endpoints, methods, and response schemas.

Development: Implement the API while adhering to the defined spec, following version control and code reviews.

Testing: Perform integration and contract tests. Use mocks or stubs to decouple frontend/backend development.

Deployment: Deploy APIs in CI/CD pipelines with canary releases, blue-green deployments, or feature toggles.

Monitoring: Track metrics like latency, uptime, and error rate using tools like Prometheus, Grafana, or Postman Monitor.

Versioning/Maintenance: Introduce changes carefully while maintaining backward compatibility.

Deprecation: Gradually phase out old versions with client communication and support periods.


## *HTTP Status Codes*

### *1️⃣ 2xx — Success*

| Code                     | Meaning                               | When used                                  |
| ------------------------ | ------------------------------------- | ------------------------------------------ |
| *200 OK*         | Successful request                    | GET success, data fetched                  |
| *201 Created*    | Resource created                      | POST request created a new user/order/etc. |
| *202 Accepted*   | Request accepted but processing later | Async processing                           |
| *204 No Content* | No body returned                      | DELETE success, no response body           |

---

### *2️⃣ 3xx — Redirection*

| Code                            | Meaning                 | When used                    |
| ------------------------------- | ----------------------- | ---------------------------- |
| *301 Moved Permanently* | URL changed permanently | SEO redirects                |
| *302 Found*             | Temporary redirect      | Temporary page moved         |
| *304 Not Modified*      | Cached version valid    | Browser caching optimization |

---

### *3️⃣ 4xx — Client Errors*

| Code                                 | Meaning                      | Why it occurs                            |
| ------------------------------------ | ---------------------------- | ---------------------------------------- |
| *400 Bad Request*            | Invalid input                | Missing fields, malformed JSON           |
| *401 Unauthorized*           | No authentication            | Token/JWT missing                        |
| *403 Forbidden*              | Auth present but not allowed | Token valid but insufficient permissions |
| *404 Not Found*              | Resource doesn't exist       | User/product not found in DB             |
| *405 Method Not Allowed*     | Wrong HTTP method            | Using GET instead of POST                |
| *409 Conflict*               | Duplicate resource           | Trying to create existing user/email     |
| *415 Unsupported Media Type* | Wrong content type           | Sending XML instead of JSON              |
| *429 Too Many Requests*      | Rate limiting                | API throttling                           |

---

### *4️⃣ 5xx — Server Errors*

| Code                                | Meaning                              | Reason                                  |
| ----------------------------------- | ------------------------------------ | --------------------------------------- |
| *500 Internal Server Error* | Unexpected failure                   | NullPointerException, bugs              |
| *501 Not Implemented*       | Feature not implemented              | Endpoint exists but logic not developed |
| *502 Bad Gateway*           | Invalid response from another server | Microservice call failed                |
| *503 Service Unavailable*   | Server temporarily down              | Maintenance, overload                   |
| *504 Gateway Timeout*       | Upstream service didn't respond      | DB or microservice taking too long      |

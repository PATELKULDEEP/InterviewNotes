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


# *Rest API*
## Best practice to write the REST API
using proper http methods like get, post, update, etc. using proper http status code, proper error handling. versioning the api. avoiding returning the huge list better to provide query parameters. securing the api by having authentication, authorization

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

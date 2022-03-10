**Install**
- MySQL 5.7
- Java 11, Spring Boot 2.2.1
- IDE: IntelliJ
- Git
- Maven + Hibernate + Lombok

**Create DB**
```
spring.datasource.url = jdbc:mysql://localhost:3306/test-java?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false
spring.datasource.username = root
spring.datasource.password = 1234
```
| Field  |  Type | Null  | Key  | Extra  |
|---|---|---|---|---|
|  id |  bigint(20) | NO  |  PRI |  auto_increment |
|  post_code |  int(255) | YES  |   |   |
|  suburb_name | varchar(255) | YES  |   |   |

Query:
```
CREATE SCHEMA `test-java` ;

create table PostCode
(
id int auto_increment,
post_code int null,
suburb_name varchar(255) null,
);
```

**Exception**
- System has error

**Model**
- PostCodeEntity, PostCodeDto
- ResponseModel, PostCodeRequest

**Repository**
- Use JPA
- Provide method: save, update, find, findById,...

**Controller**
- API get All PostCode from database:
    - URL: .../api/all
    - Method: GET
    - Body: none
  
- API get All PostCode from database:
    - URL: .../api/postcode
    - Method: GET
    - Body:
      ```
      [
        "1", "2", "3"
       ]
      ```

- API create new PostCode from list:
    - URL: .../api/create-new
    - Method: POST
    - Body:
      ```
      "list_post_code": [
        {
        "post_code": 1,
        "suburb_name": A
        },
        
        {
        "post_code": 2,
        "suburb_name": B
        }
      ]
      ```

# Spring Cloud demo application with Docker and Kubernetes

## Ports for applications
- Frontend application: 8080
- Backend application: 8000
- Spring configuration server: 8888
- Salary service: no port
- Naming-server: 8761
- Api-gateway: 8765

## [Some service](#someService) (in this example it's name is "Some service")
- Must be initialized with git !!!
- Must contain <file_name>.properties file  
- It has only configuration file/s for [Spring configuration server](#springConfigurationServer)
- in properties file the value must starts with name of the application that wants to use this setting e.g. for frontend-server it is frontend-server.minimum a
- Example setting:
  - frontend-server.minimum=20000
  - frontend-server.maximum=99000

## <a name="springConfigurationServer">Spring configuration server</a> 
- This server provides setting for other services.
- Where to find configuration file is set in properties file - spring.cloud.config.server.git.uri
- Path in properties file is set to directory to <a name="someService">Some service</a>

## Naming server
- it uses Eureka to discover running servers and it's port
- application that has to show in Eureka server needs to have Eureka client and Actuator in pom.xml
- it also communicates with openfeign client that is in frontend server

## API Gateway
- It shows all urls by application name
- For example: http://localhost:8765/backend-server/api/v2/employees
  - http://localhost:8765/ - belongs to Api-gateway
  - backend-server is name of backend-server, must be CAPITALIZED or set to lower-case in properties file (is set in this project)
  - api/v2/employees - is url on backend-server
- http://localhost:8765/frontend-server/fluxAndWebclientAndFeign

## Used technology
### Open Feign
- It is similar to RestTemplate but it is used as interface with annotations then is used in controller to get data 
- Thanks to Eureka it gets all urls that application could connect to

### Resilience4j
- It retries messages for x number of times
- For example it retries 5 times every 5 seconds
- The fallback method (method that is run if no connection) must have same return type as method that calls it

## More information
- https://www.udemy.com/course/microservices-with-spring-boot-and-spring-cloud/

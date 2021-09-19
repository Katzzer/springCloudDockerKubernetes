# Spring Cloud demo application with Docker and Kubernetes

## Ports for applications
- Frontend application: 8080
- Backend application: 8000
- Spring configuration server: 8888
- Salary service: no port

## Salary service (or any other service)
- It has only configuration file/s for [Spring configuration server](#springConfigurationServer)

## <a name="springConfigurationServer">Spring configuration server</a> 
- This server provides setting for other services.
- Where to find configuration file is set in properties file - spring.cloud.config.server.git.uri

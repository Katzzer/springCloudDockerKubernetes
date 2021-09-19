# Spring Cloud demo application with Docker and Kubernetes

## Ports for applications
- Frontend application: 8080
- Backend application: 8000
- Spring configuration server: 8888
- Salary service: no port

## [Some service](#someSerive) (in this example it't name is "Some service")
- Must be initialized with git
- Must contain <file_name>.properties file  
- It has only configuration file/s for [Spring configuration server](#springConfigurationServer)
- in properties file the value must starts with name of the application that wants to use this setting e.g. for frontend-server it is frontend-server.minimum a

## <a name="springConfigurationServer">Spring configuration server</a> 
- This server provides setting for other services.
- Where to find configuration file is set in properties file - spring.cloud.config.server.git.uri
- Path is set directory <a name="someSerive">Some service</a>

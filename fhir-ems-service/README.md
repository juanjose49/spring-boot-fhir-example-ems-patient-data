# FHIR EMS Service
The contents of this directory is a Spring Boot Java application that was bootstrapped using the Spring Boot Initializer.

## Development
To work on this application you will have to install maven on your local machine. At present, there is no need to add any custom global/user settings. To run the application locally, please do the following: 

1. In root directory, run: 

```
sudo mvn dockerfile:build
```

2. Once that is complete, notice: 

```
[INFO] Image will be built as fhir-ems-service:0.0.1-SNAPSHOT
```

3. We can then run our container with the above image name: 

```
sudo docker run -it --name fhir -p 8080:8080 fhir-ems-service:0.0.1-SNAPSHOT 
```

TODO: Write a wrapper script to handle docker-compose, maven etc



OR

You can run outside of container by: 

1. mvn clean install
2. java -jar target/nameofjar.jar

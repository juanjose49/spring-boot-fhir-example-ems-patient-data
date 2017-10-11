FROM openjdk:jre

#ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/myservice/myservice.jar"]
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/myservice/fhir-ems-service-0.0.1-SNAPSHOT.jar"]


#ARG JAR_FILE
#ADD target/${JAR_FILE} /usr/share/myservice/myservice.jar
ADD target/fhir-ems-service-0.0.1-SNAPSHOT.jar /usr/share/myservice/fhir-ems-service-0.0.1-SNAPSHOT.jar

EXPOSE 8080

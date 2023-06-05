FROM openjdk:20-jdk
COPY target/users-1.0-SNAPSHOT.jar users-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/users-1.0-SNAPSHOT.jar"]
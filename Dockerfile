FROM adoptopenjdk/openjdk15
ADD target/BynderAssignment-1.0-SNAPSHOT.jar BynderAssignment-1.0-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "BynderAssignment-1.0-SNAPSHOT.jar"]
EXPOSE 8080
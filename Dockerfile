FROM openjdk:8
ADD target/hotel-service.jar hotel-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "hotel-service.jar"]

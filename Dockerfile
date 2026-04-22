FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/Bookfile.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
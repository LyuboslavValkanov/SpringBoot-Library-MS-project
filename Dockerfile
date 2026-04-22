FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN chmod +x mvnw

RUN ./mvnw clean package

ENTRYPOINT ["java", "-jar", "target/Bookfile.jar"]
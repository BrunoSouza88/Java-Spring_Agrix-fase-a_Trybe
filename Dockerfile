FROM maven:3-openjdk-17 AS build-image

WORKDIR /to-build-app

COPY pom.xml .
COPY src ./src

RUN mvn dependency:go-offline

RUN mvn package

FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY --from=build-image /to-build-app/target/nome-do-seu-arquivo.jar ./app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
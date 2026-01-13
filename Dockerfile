FROM gradle:jdk17 AS builder

WORKDIR /app
COPY . .

RUN gradle clean build -x test --no-daemon


FROM eclipse-temurin:17-jre-jammy
EXPOSE 8080
WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

RUN useradd -m spring
USER spring

ENTRYPOINT ["java", "-jar", "app.jar","--spring.profiles.active=prod"]
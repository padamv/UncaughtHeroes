FROM openjdk:17

WORKDIR /app

# Change the version accordingly
COPY build/libs/UncaughtHeroes-0.0.3.jar /app/UncaughtHeroes.jar

EXPOSE 8080

CMD ["java", "-jar", "UncaughtHeroes.jar"]

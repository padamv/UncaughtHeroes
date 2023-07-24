FROM openjdk:17

WORKDIR /app

COPY build/libs/UncaughtHeroes-0.0.3.jar /app/UncaughtHeroes-0.0.3.jar

EXPOSE 8080

# Change the version accordingly
CMD ["java", "-jar", "UncaughtHeroes-0.0.3.jar"]

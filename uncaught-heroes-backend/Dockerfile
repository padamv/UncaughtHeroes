FROM maven:3.9.5-amazoncorretto-17

RUN mkdir -p /app/uncaught-heroes-backend
WORKDIR /app

COPY pom.xml /app
COPY uncaught-heroes-backend/pom.xml /app/uncaught-heroes-backend
COPY uncaught-heroes-backend/src/ /app/uncaught-heroes-backend/src

EXPOSE 8080
EXPOSE 12345

ENV REBEL_HOME="/opt/jrebel"
ENV JAVA_OPTS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005 $JAVA_OPTS"
ENV JAVA_OPTS="-agentpath:$REBEL_HOME/lib/libjrebel64.so -Drebel.remoting_plugin=true -Drebel.remoting_port=12345 $JAVA_OPTS"

RUN mvn package spring-boot:repackage -pl uncaught-heroes-backend

CMD ["sh", "-c", "java $JAVA_OPTS -jar uncaught-heroes-backend/target/uncaught-heroes-backend.jar"]
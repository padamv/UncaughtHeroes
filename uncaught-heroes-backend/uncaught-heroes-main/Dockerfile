FROM maven:3.9.5-amazoncorretto-17

WORKDIR /app
COPY ./pom.xml /app/

WORKDIR /app/uncaught-heroes-main
COPY ./uncaught-heroes-backend/uncaught-heroes-main/pom.xml /app/uncaught-heroes-main/
COPY ./uncaught-heroes-backend/uncaught-heroes-main/src /app/uncaught-heroes-main/src


EXPOSE 8080
EXPOSE 12345
EXPOSE 5005

ENV REBEL_HOME="/opt/jrebel"
ENV JAVA_OPTS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005 $JAVA_OPTS"
ENV JAVA_OPTS="-agentpath:$REBEL_HOME/lib/libjrebel64.so -Drebel.remoting_plugin=true -Drebel.remoting_port=12345 $JAVA_OPTS"

RUN mvn package spring-boot:repackage

CMD ["sh", "-c", "java $JAVA_OPTS -jar target/uncaught-heroes-main.jar"]
FROM maven:3.9.5-amazoncorretto-17

WORKDIR /app
COPY ./pom.xml /app/

WORKDIR /app/uncaught-heroes-api-gateway
COPY ./uncaught-heroes-backend/uncaught-heroes-api-gateway/pom.xml /app/uncaught-heroes-api-gateway/
COPY ./uncaught-heroes-backend/uncaught-heroes-api-gateway/src /app/uncaught-heroes-api-gateway/src

EXPOSE 8080
EXPOSE 12346
EXPOSE 5006

ENV REBEL_HOME="/opt/jrebel"
ENV JAVA_OPTS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5006 $JAVA_OPTS"
ENV JAVA_OPTS="-agentpath:$REBEL_HOME/lib/libjrebel64.so -Drebel.remoting_plugin=true -Drebel.remoting_port=12346 $JAVA_OPTS"

RUN mvn package spring-boot:repackage

CMD ["sh", "-c", "java $JAVA_OPTS -jar target/uncaught-heroes-api-gateway.jar"]
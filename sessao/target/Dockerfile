FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY sessao-0.0.1-SNAPSHOT.jar app.jar
COPY trust.jks /tmp/trust.jks
ENTRYPOINT ["java","-Djavax.net.ssl.trustStore=/tmp/trust.jks", "-Djavax.net.ssl.trustStorePassword=changeit","-jar","/app.jar" ]
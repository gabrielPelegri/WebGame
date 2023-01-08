
FROM maven:3.6.3 AS maven
WORKDIR /usr/src/app
COPY . /usr/src/app
RUN mvn package

FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=Test-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
COPY --from=maven /usr/src/app/target/${JAR_FILE} /opt/app/
ENTRYPOINT ["java","-jar","Test-0.0.1-SNAPSHOT.jar"]
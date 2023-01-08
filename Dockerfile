
FROM maven:3.6.3 AS maven
WORKDIR /usr/src/app
COPY . /usr/src/app
RUN mvn package

FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=mads-todolist-1.0.0.jar
WORKDIR /opt/app
COPY --from=maven /usr/src/app/target/${JAR_FILE} /opt/app/
ENTRYPOINT ["java","-jar","mads-todolist-1.0.0.jar"]
#
# Build stage
#
FROM maven:3.6.0-jdk-8-slim AS build
WORKDIR /home/app
COPY pom.xml .
RUN mvn dependency:resolve

COPY src /home/app/src/
RUN mvn -DEMPRESTIMO_DB_HOST=host -DEMPRESTIMO_DB_PORT=27017 -DUSUARIO_SERVICE_HOST=host -DUSUARIO_SERVICE_PORT=8085 package

#
# Package stage
#
FROM openjdk:8-jdk-alpine
COPY --from=build /home/app/target/*.jar /usr/local/lib/emprestimo.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/usr/local/lib/emprestimo.jar"]
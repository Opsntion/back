FROM openjdk:17-temurin
ARG JAR_FILE=build/libs/option.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar", "--spring.profiles.active=prod"]

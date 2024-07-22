FROM openjdk:11-jre-slim
ARG JAR_FILE=target/opsntion.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar", "--spring.profiles.active=prod"]
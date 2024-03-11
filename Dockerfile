FROM openjdk:17-alpine
ARG JAR_FILE=target/inGame365-v3.jar
WORKDIR /opt/app
COPY ${JAR_FILE} inGame365-v3.jar

ENTRYPOINT ["java","-jar","inGame365-v3.jar"]
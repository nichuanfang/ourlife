FROM openjdk:8-jdk-alpine
ADD target/*.jar jaychou.jar
ENTRYPOINT ["java","-jar","jaychou.jar"]

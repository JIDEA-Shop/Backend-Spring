FROM openjdk:17

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} spring-ecommerce.jar

ENTRYPOINT ["java","-jar","/spring-ecommerce.jar"]

EXPOSE 5000
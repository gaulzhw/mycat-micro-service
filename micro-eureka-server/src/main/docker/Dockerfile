FROM openjdk:8-jdk

ADD micro-eureka.jar /app.jar
#EXPOSE 8001
ENTRYPOINT ["java","-Djave.security.egd=file:/dev/./urandom","-jar","/app.jar"]

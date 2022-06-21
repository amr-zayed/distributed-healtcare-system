FROM openjdk:11.0.9
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} patient-data.jar
CMD ["java","-jar","patient-data.jar"]

#1- build (clean, test, package)
#2- build: docker build -t habibahmedmagdy/microservice:emr .
#3- push: docker push habibahmedmagdy/microservice:emr
#4- run: docker run –p8010:8010 habibahmedmagdy/microservice:eureka


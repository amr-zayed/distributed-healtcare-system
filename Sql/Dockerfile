FROM openjdk:17.0.2
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} patient.jar
CMD ["java","-jar","patient.jar"]

#1- build (clean, test, package)
#2- build: docker build -t amrzayed/distributed-emr:patients .
#3- push: docker push amrzayed/distributed-emr:patients
#4- run: docker-compose


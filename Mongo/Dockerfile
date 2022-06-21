FROM openjdk:17.0.2
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} patient-data.jar
CMD ["java","-jar","patient-data.jar"]

#1- build (clean, test, package)
#2- build: docker build -t amrzayed/distributed-emr:patient-documents .
#3- push: docker push amrzayed/distributed-emr:patient-documents
#4- run: docker-compose


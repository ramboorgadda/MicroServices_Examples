#Start with Base Image containing Java Runtime
FROM openjdk:17-jdk-slim
# INFORMATION about who maintanis the Image
MAINTAINER eazybites.com

#Add the application Jar to the Image
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar
# Execute the application
ENTRYPOINT ["java","-jar","accounts-0.0.1-SNAPSHOT.jar"]
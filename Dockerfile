FROM openjdk:17-oracle
EXPOSE 8080
COPY target/p5.jar p5-docker.jar
ENTRYPOINT ["java","-jar","/p5-docker.jar"]
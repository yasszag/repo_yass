FROM frolvlad/alpine-oraclejdk8:slim
WORKDIR /app
COPY target/gs-spring-boot-docker-0.1.0.jar /app
EXPOSE 8080
CMD ["java","-jar","gs-spring-boot-docker-0.1.0.jar"]


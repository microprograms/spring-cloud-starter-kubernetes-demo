FROM adoptopenjdk:8-jre-openj9
COPY target/spring-cloud-starter-kubernetes-demo-1.0.1.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"] 
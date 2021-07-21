FROM adoptopenjdk:8-jre-openj9
COPY target/spring-cloud-starter-kubernetes-demo-2.0.10.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"] 
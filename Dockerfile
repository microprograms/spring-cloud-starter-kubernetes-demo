# java -version
# openjdk version "1.8.0_292"
# OpenJDK Runtime Environment (build 1.8.0_292-b10)
# Eclipse OpenJ9 VM (build openj9-0.26.0, JRE 1.8.0 Linux amd64-64-Bit Compressed References 20210421_1000 (JIT enabled, AOT enabled)
# OpenJ9   - b4cc246d9
# OMR      - 162e6f729
# JCL      - 2a5e268814 based on jdk8u292-b10)
FROM adoptopenjdk:8-jre-openj9

COPY target/spring-cloud-starter-kubernetes-demo-2.2.7.jar spring-cloud-starter-kubernetes-demo-2.2.7.jar

EXPOSE 8080

ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=80.0 -XX:InitialRAMPercentage=75.0"

ENTRYPOINT java ${JAVA_OPTS} -jar spring-cloud-starter-kubernetes-demo-2.2.7.jar
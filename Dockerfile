FROM eclipse-temurin:17-jdk
COPY target/aws-apigateway-example.jar aws-apigateway-example.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/aws-apigateway-example.jar"]
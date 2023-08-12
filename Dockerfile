FROM eclipse-temurin:17-jdk
COPY target/aws-apigateway-example.jar aws-apigateway-example.jar

ENTRYPOINT ["java", "-jar", "/aws-apigateway-example.jar"]
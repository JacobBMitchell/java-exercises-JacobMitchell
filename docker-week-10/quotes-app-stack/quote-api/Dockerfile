FROM eclipse-temurin:17-jdk-alpine as builder
RUN apk update
RUN apk add maven
WORKDIR /home/app
COPY . .
RUN mvn package -DskipTests -f pom.xml

FROM eclipse-temurin:17-jre-alpine

EXPOSE 8080/tcp
WORKDIR /home/app
# CHANGE: Copy the correct jar.
COPY --from=builder /home/app/target/quote-api-1.0.jar app.jar
CMD ["java", "-jar", "./app.jar"]
# 1. Alpine is a lightweight base image, use Eclipse Temurin 17.
FROM eclipse-temurin:17-alpine
# 2. Create the directory and navigate to it.
WORKDIR /home/app
# 3. Copy our packaged jar to the working directory and rename.
COPY ./target/hello-mvc-0.0.1.jar app.jar
# 4. Run the jar.
CMD ["java", "-jar", "./app.jar"]
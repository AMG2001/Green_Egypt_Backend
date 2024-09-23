# Use java 21 image .
FROM openjdk:21
# download maven image .
FROM maven

# Set the working directory
WORKDIR /app

# Copy the project files
COPY . .

# Build the application
RUN mvn clean package -DskipTests

EXPOSE 8761

# Set the command to run the application
CMD ["java", "-jar", "target/eurekaServer-0.0.1-SNAPSHOT.jar"]
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
CMD sh -c 'java -jar $(ls target/*.jar)'

# Command to run the image : docker run -p port_on_host_machine:port_on_container -it id_of_image
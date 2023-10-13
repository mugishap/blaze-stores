# Use the official Quarkus base image with a native image build
FROM registry.access.redhat.com/ubi8/openjdk-17:1.16

# Set the working directory
WORKDIR /usr/src/app

# Copy the application files
COPY . .

# Build the Quarkus native executable
RUN ./mvnw clean package -Pnative -Dquarkus.native.container-build=true

# Set the working directory in the minimal base image
WORKDIR /work/

# Copy the native executable from the build stage to the minimal base image
COPY --from=build /usr/src/app/target/*-runner /work/application

# Set the necessary permissions to run the application
RUN chmod 775 /work

# Specify the command to run the application
CMD ["./application", "-Dquarkus.http.host=0.0.0.0"]

# Expose the port the application will listen on
EXPOSE 8084

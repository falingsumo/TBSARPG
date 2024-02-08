# Setting base docker image
FROM eclipse-temurin:21 as builder
# Setting workplace directory
WORKDIR /opt/dev

# Because the docker image only contains the OS and the JDK, we need to copy the maven wrapper
COPY maven-wrapper/.mvn ./.mvn
# Because the maven wrapper needs the pom.xml file we copy it to the docker image
COPY maven-wrapper/mvnw pom.xml ./
# We want to run this command because it will download all our dependencies and docker will cache the result of this command in the docker image
RUN ./mvnw dependency:go-offline

# We want to copy our src folder so we can build the projet
COPY src ./src

# We want to run mvn clean install to build our application
#RUN ./mvnw clean install

# Set new layer for running the app
#FROM eclipse-temurin:17-alpine as runner

# Set working directory different then building directory
#WORKDIR /opt/app

# Copy
#COPY --from=builder /opt/dev/target/*.jar /opt/app/*.jar

# We set the default command of the docker image to run the spring-boot
CMD ["./mvnw", "spring-boot:run"]
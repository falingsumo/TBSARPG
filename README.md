# TBSARPG
## Welcome to my Turn Base Strategy Action Rôle Playing Game
### Java details:
Here is a list of specifications related to Java for this project:
* The project was initialized using https://start.spring.io
* OpenJDK 21
* The project uses a maven wrapper
* To clean and install the project use:
```cmd
./maven-wrapper/mvnw clean install
```
* To build and package the application use:
```cmd
./maven-wrapper/mvnw package
```
* To run the project use:
```cmd 
java -jar target/lab-sebastien-0.0.1-SNAPSHOT.jar
```

### Docker details:
Here is a list of specifications related to Docker for this project:
* The base image is
```cmd 
eclipse-temurin:21
```
* The working directory is
```cmd 
/opt/dev/game-server
```
* To build the docker image use:
```cmd 
docker build -t TBSARPG/server .
```
* To run the docker image use:
```cmd 
docker run -p 8080:8080 -t TBSARPG/server
```
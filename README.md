# Steps to run the application
## Prerequisite
1. Install jdk 17
2. Install maven
3. Running `mvn --version` should yield below

```shell
 mvn --version
Apache Maven 3.9.6 (bc0240f3c744dd6b6ec2920b3cd08dcc295161ae)
Maven home: /opt/maven
Java version: 17.0.9, vendor: Private Build, runtime: /usr/lib/jvm/java-17-openjdk-amd64
Default locale: en_IN, platform encoding: UTF-8
OS name: "linux", version: "6.2.0-39-generic", arch: "amd64", family: "unix"

```
## Steps
1. Install docker
2. Clone the repo
3. Run `mvn clean install`
3. goto docker folder
4. Run command `docker compose up`


# Steps to build image
## Method 1
1. Login to docker from command line
2. Add configuration in pom.xml
   
```shell
docker login
mvn clean build 
mvn spring-boot:build-image -DskipTests
```


### Add below in pom.xml
```xml
	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<image>
						<name>fsl4faisal/pb-${project.artifactId}:${project.version}</name>
					</image>
					<pullPolicy>IF_NOT_PRESENT</pullPolicy>
				</configuration>
			</plugin>
		</plugins>
	</build>
```

### Issue 1
when I named the image as `fsl4faisal/${project.artifactId}:${project.version}` it wasn't working i.e. `mvn spring-boot:build-image -DskipTests` 
step was not moving forward
Upon renaming it to `fsl4faisal/pb-${project.artifactId}:${project.version}` it worked.

### Issue 2
Also for the step `mvn spring-boot:build-image -DskipTests` I had to change the network from wifi to hotstop (internally running the wifi though) as I 
was getting below issue

```
dial tcp: lookup github.com: no such host
```
It worked in the first attempt but didn't work in the second attempt 


## Method 2
Create `Dockerfile` in the base path of the project
```shell
mvn clean install
```

The above command will create the target directory which we will use in the Dockerfile

#### Dockerfile
```dockerfile
FROM eclipse-temurin:17-jdk-alpine
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```
<br>

#### docker-compose.yml
```dockerfile
version: '3.7'

services:
  phonebook:
    mem_limit: 700m
    container_name: phonebook
    build:
      context: ..
      dockerfile: Dockerfile
      no_cache: true
    ports:
      - "8080:8080"

```
#### Troubleshooting
At first I had the dockerfile and docker-compose.yml both in the docker directory it didn't work, it could not find the target folder from there. Then I had to move the Dockerfile to the base directory from there it was able to find


# Verdit
The method1 is unreliable but it pushes the image to docker repo which is nice. 
Method 2 is independent of the docker image push to repo and it builds the image everytime we run the docker compose 

# Steps to build image 
1. Login to docker from command line
2. Add configuration in pom.xml
3. 
   
```shell
docker login
mvn clean build 
mvn spring-boot:build-image -DskipTests
```


pom.xml config
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



## Troubleshooting 
when I named the image as `fsl4faisal/${project.artifactId}:${project.version}` it wasn't working i.e. `mvn spring-boot:build-image -DskipTests` 
step was not moving forward
Upon renaming it to `fsl4faisal/pb-${project.artifactId}:${project.version}` it worked.


Also for the step `mvn spring-boot:build-image -DskipTests` I had to change the network from wifi to hotstop (internally running the wifi though) as I 
was getting below issue

```
dial tcp: lookup github.com: no such host
```

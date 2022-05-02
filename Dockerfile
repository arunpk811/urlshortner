FROM openjdk:11
VOLUME /tmp
COPY target/demo-0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar
CMD [“java”,”-Djava.security.egd=file:/dev/./urandom”,”-jar”,”/demo-0.0.1-SNAPSHOT.jar”]

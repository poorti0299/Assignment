FROM java:8-jdk
RUN mkdir /app
WORKDIR /app
COPY target/LibraryManagementApp2-0.0.1-SNAPSHOT.jar /app
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "LibraryManagementApp2-0.0.1-SNAPSHOT.jar"]
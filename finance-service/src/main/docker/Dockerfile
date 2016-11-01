FROM nhs-bsa/nhs-base-docker
VOLUME /tmp
ADD finance-service-1.0-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

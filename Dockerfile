# Use the base image
FROM openjdk:8u151-jdk-alpine

WORKDIR /app

RUN apk add --no-cache maven

COPY pom.xml /app
RUN ["mvn", "install"]

COPY . /app

RUN ["mvn", "clean", "package"]

FROM openjdk:8u151-jre-alpine

WORKDIR /app

COPY --from=0 /app/target/test.jar /app/test.jar

# Install necessary packages
RUN apk add -U tzdata && \
    apk add --update ttf-dejavu && \
    apk --no-cache add msttcorefonts-installer fontconfig && \
    rm -rf /var/cache/apk/*


# Set the timezone
RUN cp /usr/share/zoneinfo/America/Sao_Paulo /etc/localtime && \
    apk del -U tzdata

# Set the entry point
CMD ["java", "-Dspring.profiles.active=prod", "-Duser.timezone=GMT-03:00", "-Dspring.config.location=classpath:/application.yml,file:/app/config/application.yml", "-jar", "test.jar"]

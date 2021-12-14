FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ADD build/libs/Player-0.1.0.jar Player-0.1.0.jar
ENTRYPOINT ["java","-jar","Player-0.1.0.jar"]
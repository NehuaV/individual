FROM openjdk:11
EXPOSE 8080
ADD build/libs/Player-0.1.0.jar Player-0.1.0.jar
ENTRYPOINT ["java","-jar","Player-0.1.0.jar"]

#FROM openjdk:11
#WORKDIR . .
#COPY . .
#RUN gradle clean build
#CMD gradle bootRun


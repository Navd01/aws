FROM openjdk:8
VOLUME /tmp
EXPOSE 8081
ADD target/*.jar company-service.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT [ "java","-jar","/company-service.jar" ]
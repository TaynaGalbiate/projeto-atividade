FROM openjdk:17
EXPOSE 8081
ADD target/app-tarefas.jar app-tarefas.jar
ENTRYPOINT ["java","-jar","app-tarefas.jar"]
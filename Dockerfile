FROM ibmjava
MAINTAINER  <609035997@qq.com>
EXPOSE 8081

ADD demo-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT [ "java", "-jar", "app.jar" ]

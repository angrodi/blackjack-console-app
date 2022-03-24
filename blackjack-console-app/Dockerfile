FROM adoptopenjdk/openjdk11:alpine-jre
WORKDIR /workspace

ENV host="mysqlserver"
ENV port="3306"
ENV database="blackjack"
ENV username="root"
ENV password="toor"

COPY target/blackjack*.jar app.jar
ENTRYPOINT exec java -jar /workspace/app.jar

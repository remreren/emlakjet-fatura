FROM openjdk:11
COPY ./target/ /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "fatura.jar"]
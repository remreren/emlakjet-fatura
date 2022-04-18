FROM openjdk:11
COPY ./target/ /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "Fatura"]
FROM openjdk:11
COPY ./out/com/emlakjet/fatura/ /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "FaturaApplication"]
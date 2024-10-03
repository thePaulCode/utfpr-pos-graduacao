#!/bin/sh
mvn clean package && docker build -t com.mycompany/Aula4Pratica3Web .
docker rm -f Aula4Pratica3Web || true && docker run -d -p 9080:9080 -p 9443:9443 --name Aula4Pratica3Web com.mycompany/Aula4Pratica3Web
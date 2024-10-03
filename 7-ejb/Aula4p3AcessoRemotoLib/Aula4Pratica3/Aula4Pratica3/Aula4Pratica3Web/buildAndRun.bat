@echo off
call mvn clean package
call docker build -t com.mycompany/Aula4Pratica3Web .
call docker rm -f Aula4Pratica3Web
call docker run -d -p 9080:9080 -p 9443:9443 --name Aula4Pratica3Web com.mycompany/Aula4Pratica3Web
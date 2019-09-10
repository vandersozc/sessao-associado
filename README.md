## Swagger
http://localhost:9001/swagger-ui.html#/

## Mutation Test
./gradlew pitest
reports/jacoco/test/html/index.html

## Jacoco Coverage Test
./gradlew build jacocoTestReport

reports/jacoco/test/html/index.html

## SonarCloud Metrics
https://sonarcloud.io/dashboard?id=sessao-associado
./gradlew sonarqube -Dsonar.projectKey=sessao-associado -Dsonar.organization=vandersozc-github -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=43943874b1f042489b850331363553f0607c40eb

## Travis CI
https://travis-ci.com/vandersozc/sessao-associado

## RabbitMQ
Download Imagem docker: 
https://hub.docker.com/_/rabbitmq
ou 
docker pull rabbitmq

Criar container com RabbitMq: sudo docker-compose up
Remover Container: sudo docker-compose rm

Interface Rabbitmq Management: 
http://localhost:15672/#/queues
Queue: PautaQueue
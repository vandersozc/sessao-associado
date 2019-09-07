## Swagger
http://localhost:9001/swagger-ui.html#/

## Mutation Test
gradle pitest
reports/jacoco/test/html/index.html

## Jacoco Coverage Test
gradle build jacocoTestReport

reports/jacoco/test/html/index.html

## SonarCloud Metrics
https://sonarcloud.io/dashboard?id=sessao-associado
./gradlew sonarqube -Dsonar.projectKey=sessao-associado -Dsonar.organization=vandersozc-github -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=43943874b1f042489b850331363553f0607c40eb

## Travis CI
https://travis-ci.com/vandersozc/sessao-associado
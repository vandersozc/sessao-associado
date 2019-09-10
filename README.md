# sessao-associado

[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=sessao-associado&metric=coverage)](https://sonarcloud.io/dashboard?id=sessao-associado)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=sessao-associado&metric=code_smells)](https://sonarcloud.io/dashboard?id=sessao-associado)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=sessao-associado&metric=bugs)](https://sonarcloud.io/dashboard?id=sessao-associado)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=sessao-associado&metric=alert_status)](https://sonarcloud.io/dashboard?id=sessao-associado)

- Projeto criado utilizando o framework Spring Boot e desenvolvido em Java, foi utilizado Spring Data para acesso ao banco. 
- O banco de dados utilizado foi o H2 por ser de fácil utilização para execução do serviço, não é necessesário nenhuma instalação adicional somente a dependência do projeto e sua gravação é em disco.
- As entidades da aplicação não foram expostam, para isso foram utilizadas classes de Request e Response
- Foram utilizadas classes como Service e Repository para facilitar o desenvolvimento e centralizar as regras.

## Estrutura do projeto
O projeto possui esta dividido por cada feature de negócio e possui a seguite estrutura:
- **api:** Camada responsável pelo contrato da API, expôem os endpoints para a camada REST (Objetos de request e response, controllers e arquivos de configuração). Possui versionaento através de packages do tipo 'V1', 'V2', V3 caso o contrato venha a mudar é possível versionar a api.
- **exception:** Camada responsável por capturar as exceções da api, e retornar os erros de forma amigável ao usuário. Possui uma classe genérica que é chamada para tratar a exceções de negócio e ExceptionHandlers que capturam outros tipos de exceção e tratam as memas
- **domain:** Camada responsável por conter as regras de neçócio da api, classes de persistência dos dados, classes para mapeamento de objetos.
- **integration:** Camada responsável por conter classes que acessam e se integram com serviços externos.
- **queue:** Camada responsável por conter a configuração da fila do RabbitMQ, classe para agendamento de execução e envio da mensagem.

## Documentação da Api
A ferramenta utilizada para a documentação da Api foi o [Swagger](https://swagger.io), para visualizar execute a aplicação local e acesse através do endereço:

http://localhost:9001/swagger-ui.html#/

## Execução do Projeto
O projeto utiliza Java 11 com Gradle para build e gerenciamento das dependências.
Execute o comando abaixo na pasta raiz do projeto para fazer download das dependências e gerar os artefatos necessários:
O serviço será executado na porta 9001.
```
./gradlew clean build --refresh-dependencies
```

## Testes automatizados e cobertura de testes
Utiliza [JUnit 5](https://junit.org/junit5/) como framework de testes, foi utilizado pois é o mais difundido e em sua última versão trouxe melhorias e tornou os teste e asserts mais simplificados devido ao uso de expressões lambdas. Para os testes unitários foi utilizado o Framework [Mockito](https://site.mockito.org/) para criação de objetos em escopo de teste.
Pode-se executar o comando abaixo para verificar a cobertura de testes e o resultado será visualizado no path do projeto: reports/jacoco/test/html/index.html
```
./gradlew build jacocoTestReport
```
Foi incluído também testes de mutação de código para verificar se realmente os testes são efetivos. O framework utilizado foi o [Pitest](http://pitest.org/). Para visualizar o resultado execute o comando abaixo e o resultado será visualizado no path do projeto: reports/jacoco/test/html/index.html

```
./gradlew pitest
```

## Build, análise e métricas de código
- O build do projeto, execução dos testes, e geração de relatórios de cobertura pode ser visualizado remotamente através do [Travis CI](https://travis-ci.com/vandersozc/sessao-associado). O build é gerado através da integração contínua com os commits no repositório do GIT

- Para análise e métricas de código estático foi utilizado o SonarCloud.
Para análise de código estático e relatório de cobertura de testes foi utilizado o [SonarCloud](https://sonarcloud.io) e pode ser visualizada em: [sessao-associado](https://sonarcloud.io/dashboard?id=sessao-associado).

## Mensageria com RabbitMQ
Foi utilizado o [RabbitMQ](https://www.rabbitmq.com/) para geração da fila de mensageria, foi escolhido devido a fácil configurção e uso com [Docker](https://www.docker.com/) e por que também cumpre muito bem o papel de message broker.

Para executar o RabbitMQ é necessário já ter configurado na máquina ou utilizar com Docker, no projeto há um arquivo de configuração para subir o container Docker (docker-compose.yml).

Imgem Docker: 
https://hub.docker.com/_/rabbitmq ou  docker pull rabbitmq

Subir container com RabbitMQ: 
```
sudo docker-compose up
```
Remover Container: 
```
sudo docker-compose rm
```
### Interface Rabbitmq Management para visualização da fila: 

http://localhost:15672/#/queues

Fila Configurada: 
Queue: PautaQueue

## Serviços

Serviços disponíveis para utilização da API.

Criar uma pauta: 
```json
Request:
POST: http://localhost:9001/sessao-associado/v1/pauta
{
	"assunto": "Assunto da Pauta"
}
```

Criar a sessão de uma pauta: 
```json
Request: 
POST: http://localhost:9001/sessao-associado/v1/pauta/1/sessao
{
	"duracao": "1",
	"dataHoraAbertura": "2019-09-10T00:11:00.341Z"
}
```

Computar voto na sessão escolhida: 
```json
Request: 
POST: http://localhost:9001/sessao-associado/v1/pauta/1/sessao/1/voto-sessao
{
	"cpfAssociado": "04755292948",
	"voto": "true"
}
```

Visualizar a pauta com os votos computados: 
```json
Response:
GET: http://localhost:9001/sessao-associado/v1/pauta/1
{
  "id": 1,
  "assunto": "Assunto da Pauta",
  "dataCadastro": "2019-09-10",
  "totalVotosFavor": 5,
  "totalVotosContra": 3
}
```

# Catalogo de Filmes

![Badge versão do Java](http://img.shields.io/static/v1?label=JAVA&message=17.0.6LTS&color=blue&style=for-the-badge&logo=openJDK)
![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=lightgray&style=for-the-badge)

## Descrição do projeto
<p>Projeto elaborado a partir da imersão java da alura e consiste em consumir uma API de filmes e usar da imaginação para exibição e armazenamento dos dados.</p>

## Funcionalidades
- Consumir API de filmes
- Exibir Todos filmes
- Pesquisar por filmes;

## Pré-requisitos
- [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [MAVEN](https://maven.apache.org/download.cgi?.)

<p>Atente-se a inclusão das variáveis de ambiente JAVA_HOME e MAVEN_HOME em seu SO.</p>

## Como executar a aplicação
<p>Clone o projeto através do endereço:</p>

```
git clone https://github.com/
```

<p>Execute o comando abaixo na pasta raiz do projeto para empacotar a aplicação:</p>

```
package -f pom.xml
```

<p>Execute os testes manualmente (o comando anterior executa os testes automaticamente) através do comando abaixo:</p>

```
test -f pom.xml
```

<p>Acesse o diretório /target contido na raiz do projeto e execute o comando:</p>

```
java -jar catalogo-filmes-1.0-SNAPSHOT.jar
```

Projeto de demonstração de uma API para cadastro de Clientes e Produtos.

Uso de Spring Security para liberação de rotas de acordo com a ROLE do usuário.

Tools:
* Intellij
* Java 8
* Maven

Database:
* H2 (banco de dados em memória - já está configurado no projeto)
* Caso necessário utilizar o console, após subir o projeto acesse:
    * http://localhost:8080/h2-console
        * driver class -> org.h2.Driver
        * jdbc url -> jdbc:h2:mem:testdb
        * username -> sa
        * password -> password

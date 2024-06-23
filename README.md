Documentação Sistema de Arquivos Distribuídos com Spring Boot

Este projeto implementa um Sistema de Arquivos Distribuídos utilizando Spring Boot, Java 21 e Maven 3.9.6+.

Equipe

    Brian Friedrich dos Santos Schultz

Estrutura do Projeto

O projeto está dividido em cinco módulos principais:

    demo-eureka-server: Servidor Eureka para descoberta de serviços.
    dfs-app-a: Aplicação mestre responsável pela coordenação do armazenamento de arquivos.
    dfs-app-b: Aplicação nó para armazenamento de arquivos.
    dfs-app-c: Aplicação nó para armazenamento de arquivos.
    profile-app: Aplicação de perfil com endpoints REST para interação com o sistema de arquivos distribuídos.

Como Executar o Projeto
Requisitos

    Java 21
    Maven 3.9.6+
    Docker (opcional, para execução com containers)

Passos para Execução

Clonar o repositório:

    git clone https://github.com/seu-usuario/nome-do-repositorio.git

Compilar o projeto:

    mvn clean install

Executar o servidor Eureka (demo-eureka-server):


    cd demo-eureka-server
    mvn spring-boot:run

Executar as aplicações dfs-app-a, dfs-app-b e dfs-app-c com Docker:

Para facilitar a execução das aplicações em Docker, cada módulo do projeto pode ser empacotado em um container Docker separado.

    Construir a imagem Docker para cada módulo:

cd dfs-app-a
docker build -t dfs-app-a .

Repita o comando acima para dfs-app-b e dfs-app-c, substituindo o nome do diretório e da imagem Docker conforme necessário.

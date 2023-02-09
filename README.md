# Sistema Financeiro API (Application Programming Interface)

### Inicializar o projeto

> * Instalar o Git local [Git Download Here](https://git-scm.com/downloads)
> * Escolher se sistema operacial - Windows ou Linux
> * Fazer o clone do
    repositório [Git Clone Sistema Financeiro](https://github.com/soudevjava/sistema-financeiro-faculdade)
> * Fazer a o download do Apache Maven - [Apache Maven 3.9.0](https://maven.apache.org/download.cgi)
> * Documentação do [Maven Install](https://maven.apache.org/install.html)
> * Tutorial de instação
    do [Maven no Linux](https://www.digitalocean.com/community/tutorials/install-maven-linux-ubuntu)
> * Download do [MySQL Download Here](https://www.mysql.com/downloads/)

### Configuração do Maven

> * Descompactar o arquivo Maven zip
> * Criar um novo diretório na raiz
> * Windows: `:C\Maven`
> * Linux:  `/opt/Maven`

### Comandos básico do git

> * `git clone <https-repo>`
> * `cd microservico-financeiro`
> * `git checkout desenvolvimento` mudar de branch
> * `git pull origin desenvolvimento` puxar alterações em dev
> * `git add .` adicionar todos arquivos no commit
> * `git commit -m 'financeiro: <comentário>'` fazer o commit
> * `git push origin desenvolvimento` publicar em dev


> Abrir o projeto com seu o seu Editor de
> código [Intellij Download Here](https://www.jetbrains.com/idea/download/#section=linux)

## Estrutura base

```bash
├── mvnw
├── mvnw.cmd
├── pom.xml
├── README.md
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── api
│   │   │           └── financeiro
│   │   │               ├── configs
│   │   │               │   └── DataConfig.java
│   │   │               ├── controllers
│   │   │               │   ├── DespesasController.java
│   │   │               │   └── PagamentoMatriculaController.java
│   │   │               ├── dtos
│   │   │               │   ├── DespesasDto.java
│   │   │               │   ├── PagamentoMatriculaDto.java
│   │   │               │   └── ResponseGeneralDto.java
│   │   │               ├── entities
│   │   │               │   ├── DespesasEntity.java
│   │   │               │   └── PagamentoMatriculaEntity.java
│   │   │               ├── enums
│   │   │               │   ├── DespesasTiposEnum.java
│   │   │               │   └── GeneralMessages.java
│   │   │               ├── FinanceiroApplication.java
│   │   │               ├── repositories
│   │   │               │   ├── DespesasRepository.java
│   │   │               │   └── PagamentoMatriculaRepository.java
│   │   │               ├── services
│   │   │               │   ├── DespesasService.java
│   │   │               │   └── PagamentoMatriculaService.java
│   │   │               └── utils
│   │   │                   └── UtilDate.java
│   │   └── resources
│   │       └── application.properties
│   └── test
│       └── java
│           └── com
│               └── api
│                   └── financeiro
│                       └── FinanceiroApplicationTests.java
├── target
│   ├── classes
│   │   ├── application.properties
│   │   └── com
│   │       └── api
│   │           └── financeiro
│   │               ├── configs
│   │               │   └── DataConfig.class
│   │               ├── controllers
│   │               │   ├── DespesasController.class
│   │               │   └── PagamentoMatriculaController.class
│   │               ├── dtos
│   │               │   ├── DespesasDto.class
│   │               │   ├── PagamentoMatriculaDto.class
│   │               │   └── ResponseGeneralDto.class
│   │               ├── entities
│   │               │   ├── DespesasEntity.class
│   │               │   └── PagamentoMatriculaEntity.class
│   │               ├── enums
│   │               │   ├── DespesasTiposEnum.class
│   │               │   └── GeneralMessages.class
│   │               ├── FinanceiroApplication.class
│   │               ├── repositories
│   │               │   ├── DespesasRepository.class
│   │               │   └── PagamentoMatriculaRepository.class
│   │               ├── services
│   │               │   ├── DespesasService.class
│   │               │   └── PagamentoMatriculaService.class
│   │               └── utils
│   │                   └── UtilDate.class
│   └── generated-sources
│       └── annotations

```
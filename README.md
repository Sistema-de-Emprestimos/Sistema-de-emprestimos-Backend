[JAVA__BADGE]: https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[SPRINGBOOT__BADGE]: https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white
[MYSQL__BADGE]: https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white
[DOCKER__BADGE]: https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white
[FULLSTACK__URL]: https://github.com/sistema-de-ingressos/Fullstack-TicketFlow
[FRONTEND__URL]: https://github.com/sistema-de-ingressos/Front-End-Sistema-de-Ingressos

<h1 align="center">Sistema de Empréstimos - Back-End</h1>

<div align="center" style="padding-bottom: 6px">

![java][JAVA__BADGE]
![springboot][SPRINGBOOT__BADGE]
![mysql][MYSQL__BADGE]
![docker][DOCKER__BADGE]
</div>

## 💬 Sobre

O **Projeto-Emprestimo-TDE** é uma aplicação web desenvolvida para o gerenciamento de empréstimos de equipamentos. Utilizamos Spring Boot para o back-end, integrando design, desenvolvimento e gestão de dados.

## 📌 Funcionalidades

- Gerenciamento de empréstimos de equipamentos.
- Segurança robusta para proteção de dados.
- API RESTful para comunicação com o front-end.

## 📍Endpoints da API

Lista de todas as rotas presentes na API

### Equipamentos
| Método | Endpoint                          | Descrição                               |
|--------|-----------------------------------|-----------------------------------------|
| POST   | `/equipamentos`                        | Salva o equipamento no sistema               |
| GET    | `/equipamentos`                   | Retorna todos os equipamentos               |
| GET    | `/equipamentos/{id}`                   | Retorna detalhe do equipamento              |
| PUT    | `/equipamentos/{id}`                   | Atualiza o equipamento no sistema              |
| DELETE | `/equipamentos/{id}`                   | Deleta o equipamento do sistema              |
| GET    | `/equipamentos/{id}/historico-manutencao`               | Lista o histórico de manutenção do equipamento   |

### Empréstimos
| Método | Endpoint                        | Descrição                           |
|--------|---------------------------------|-------------------------------------|
| GET    | `/emprestimos`                    | Retorna todos os empréstimos         |
| GET    | `/emprestimos/{id}`        | Retorna o empréstimo pelo ID |
| POST   | `/emprestimos`                    | Cria um novo empréstimo         |
| PUT    | `/emprestimos/{id}/retorno`        | Devolve um empréstimo |
| GET    | `/emprestimos/nao-concluidos`        | Retorna os empréstimos não concluídos |

### Funcionários
| Método | Endpoint                          | Descrição                               |
|--------|-----------------------------------|-----------------------------------------|
| POST   | `/funcionarios`                        | Salva o funcionário no sistema               |
| GET    | `/funcionarios`                   | Retorna todos os funcionários               |
| GET    | `/funcionarios/{id}`                   | Retorna detalhe do funcionário              |
| PUT    | `/funcionarios/{id}`                   | Atualiza o funcionário no sistema              |
| DELETE | `/funcionarios/{id}`                   | Deleta o funcionário do sistema              |

## 💻 Como rodar o projeto

Para rodar o projeto, siga os passos abaixo:

1. Clone o repositório:
   ```sh
   git clone https://github.com/seu-usuario/Projeto-Emprestimo-TDE.git
    ```
2. Navegue até o diretório do projeto:
   ```sh
   cd Projeto-Emprestimo-TDE
   ```
3. Configure o banco de dados no arquivo application-prod.properties:
   ```sh
   spring.datasource.url=${DATASOURCE_URL}
   spring.datasource.username=${DATASOURCE_USERNAME}
   spring.datasource.password=${DATASOURCE_PASSWORD}
   ``` 
4. Execute o projeto com o Maven:
   ```sh
   mvn spring-boot:run
   ```
   
## 🙎🏻‍ Autor do Back-End

- João Arthur Britto / [GitHub](https://www.github.com/j0aoarthur) - [LinkedIn](https://www.linkedin.com/in/joao-arthur-britto)

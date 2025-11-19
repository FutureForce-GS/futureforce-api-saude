# 🚀 FutureForce API - Global Solution 2025

> **O Futuro do Trabalho: Monitoramento de Saúde Mental e Bem-estar**

Este projeto é uma API RESTful desenvolvida como parte da avaliação "Global Solution" da FIAP. O objetivo é fornecer uma solução tecnológica para o monitoramento de saúde mental, alinhado com os desafios das profissões do futuro e o ODS 3 (Saúde e Bem-estar).

---

## 👥 Integrantes do Grupo (Future Force)

| Nome | RM | Função |
|------|----|--------|
| **João Victor Soave** | RM557595 | Desenvolvedor Backend / Lead |
| **Guilherme Araujo de Carvalho** | RM558926 | Documentação / Testes |
| **Maria Alice Freitas Araújo** | RM557516 | Frontend / Design |

---

## 🛠 Tecnologias Utilizadas

*   **Linguagem:** Java 21
*   **Framework:** Spring Boot 3.5.7
*   **Banco de Dados:** H2 Database (em memória)
*   **Persistência:** Spring Data JPA
*   **Validação:** Bean Validation (Hibernate Validator)
*   **Testes:** Postman

---

## ⚙️ Como Executar o Projeto

### Pré-requisitos
*   Java JDK 21+ instalado.
*   Maven instalado (ou use o wrapper `./mvnw` incluso).

### Passo a Passo
1.  **Clone o repositório:**
    ```
    git clone https://github.com/SUA-ORGANIZACAO/futureforce-api-saude.git
    ```
2.  **Entre na pasta:**
    ```
    cd futureforce-api-saude
    ```
3.  **Execute a aplicação:**
    *   No Windows:
        ```
        ./mvnw.cmd spring-boot:run
        ```
    *   No Linux/Mac:
        ```
        ./mvnw spring-boot:run
        ```

A API estará rodando em: `http://localhost:8080`

---

## 🧪 Como Testar (Postman)

O projeto já inclui uma **Collection do Postman** configurada para facilitar os testes.

1.  Localize o arquivo `FutureForce.postman_collection.json` na raiz deste projeto.
2.  Abra o Postman e clique em **Import**.
3.  Selecione o arquivo.
4.  Execute as requisições na ordem sugerida.

### 📂 Dados Iniciais (Seeds)
Ao iniciar a aplicação, o sistema carrega automaticamente os seguintes dados para teste:

*   **Pacientes:**
    *   ID 1: João Silva
    *   ID 2: Maria Alice
*   **Registros Diários:**
    *   ID 1: Nível Ansiedade 3 (Vinculado ao João)
    *   ID 2: Nível Ansiedade 8 (Vinculado ao João)

> **Dica:** Utilize o endpoint `GET /registros-diarios` logo após iniciar para ver esses dados.

---

## 🔗 Endpoints da API

### 🏥 Pacientes (`/pacientes`)
| Método | Rota | Descrição |
|--------|------|-----------|
| `GET` | `/pacientes` | Lista todos os pacientes. |
| `GET` | `/pacientes/{id}` | Busca um paciente por ID. |
| `POST` | `/pacientes` | Cadastra um novo paciente. |
| `PUT` | `/pacientes/{id}` | Atualiza dados de um paciente. |
| `DELETE`| `/pacientes/{id}` | Remove um paciente. |

### 📝 Registros Diários (`/registros-diarios`)
| Método | Rota | Descrição |
|--------|------|-----------|
| `GET` | `/registros-diarios` | Lista todos os registros. |
| `GET` | `/registros-diarios/{id}`| Busca registro por ID. |
| `POST` | `/registros-diarios` | Cria novo registro (Requer `pacienteId`). |
| `PUT` | `/registros-diarios/{id}`| Atualiza um registro. |
| `DELETE`| `/registros-diarios/{id}`| Remove um registro. |

---

## 🗄️ Banco de Dados (H2 Console)

Você pode visualizar as tabelas e dados diretamente no navegador:

1.  Acesse: `http://localhost:8080/h2-console`
2.  **JDBC URL:** `jdbc:h2:mem:futureforce_db`
3.  **User:** `sa`
4.  **Password:** (deixe em branco)
5.  Clique em **Connect**.

---

## 📋 Estrutura do Projeto (Camadas)

O projeto segue rigorosamente a arquitetura em camadas exigida:

*   `controller`: Camada REST (Endpoints).
*   `service`: Regras de negócio e validações.
*   `repository`: Interfaces Spring Data JPA.
*   `model`: Entidades JPA (`@Entity`).
*   `dto`: Objetos de transferência de dados (`record`).
*   `exception`: Tratamento global de erros.

---

Desenvolvido com 💙 pela equipe **Future Force**.

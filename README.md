# 🏥 Sistema de Triagem de Pronto Socorro

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://openjdk.java.net/projects/jdk/17/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-3.6+-blue.svg)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

## 📋 Descrição

Sistema backend desenvolvido em Java para gerenciamento de triagem de pacientes em pronto socorro. O sistema implementa uma API RESTful completa que permite cadastrar pacientes, médicos, realizar triagens e gerenciar atendimentos seguindo critérios de prioridade e gravidade.

### 🎯 Funcionalidades Principais

- ✅ **Triagem de Pacientes**: Cadastro com prioridade (Vermelha, Amarela, Verde) e gravidade (Leve, Moderada, Grave)
- ✅ **Gestão de Médicos**: Cadastro de médicos com especialidade e CRM
- ✅ **Controle de Plantão**: Atualização de status de plantão dos médicos
- ✅ **Fila de Atendimento**: Sistema inteligente que prioriza pacientes por urgência
- ✅ **API RESTful**: Endpoints completos para todas as operações
- ✅ **Documentação**: Swagger UI integrado para testes da API

## 🚀 Tecnologias Utilizadas

- **Java 17** - Linguagem principal
- **Spring Boot 3.2.0** - Framework backend
- **Spring Data JPA** - Persistência de dados
- **H2 Database** - Banco de dados em memória
- **Maven** - Gerenciador de dependências
- **OpenAPI/Swagger** - Documentação da API
- **Spring Validation** - Validação de dados

## 📋 Pré-requisitos

- Java 17 ou superior
- Maven 3.6+
- IDE (IntelliJ IDEA, Eclipse, VS Code)

## ⚙️ Instalação e Execução

### 1. Clone o repositório
```bash
git clone https://github.com/Reryck/Sistema-de-Triagem-de-Pronto-Socorro.git
cd Sistema-de-Triagem-de-Pronto-Socorro
```

### 2. Execute o projeto
```bash
mvn spring-boot:run
```

### 3. Acesse a aplicação
- **API Base**: http://localhost:8080
- **Swagger UI**: http://localhost:8080/swagger-ui
- **H2 Console**: http://localhost:8080/h2-console
  - Username: `sa`
  - Password: `password`
  - JDBC URL: `jdbc:h2:mem:testdb`

## 📚 Endpoints da API

### Health Check
- `GET /health` - Verifica status da aplicação

### Triagem
- `POST /api/triagem` - Realiza triagem de paciente
- `GET /api/pacientes/{id}` - Busca paciente por ID

### Médicos
- `POST /api/medicos` - Cadastra novo médico
- `PUT /api/medicos/{id}/plantao` - Atualiza status de plantão

### Atendimento
- `GET /api/atendimento/proximo` - Retorna próximo paciente para atendimento

## 💡 Exemplos de Uso

### Realizar Triagem
```bash
curl -X POST http://localhost:8080/api/triagem \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "João Silva",
    "idade": 30,
    "sintomas": "Dor no peito e falta de ar",
    "prioridade": "VERMELHA",
    "gravidade": "GRAVE"
  }'
```

### Cadastrar Médico
```bash
curl -X POST http://localhost:8080/api/medicos \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Dr. Maria Santos",
    "especialidade": "Cardiologia",
    "crm": "12345-SP"
  }'
```

### Atualizar Status de Plantão
```bash
curl -X PUT http://localhost:8080/api/medicos/1/plantao \
  -H "Content-Type: application/json" \
  -d '{
    "emPlantao": true
  }'
```

### Buscar Próximo Paciente
```bash
curl -X GET http://localhost:8080/api/atendimento/proximo
```

## 🏗️ Arquitetura do Projeto

```
src/main/java/com/triagem/
├── config/           # Configurações da aplicação
├── controller/       # Camada de apresentação (REST APIs)
├── dto/             # Objetos de transferência de dados
├── model/           # Entidades JPA
│   └── enums/       # Enumerações (Prioridade, Gravidade)
├── repository/      # Camada de acesso a dados
├── service/         # Lógica de negócio
└── TriagemApplication.java
```

### Modelos de Dados

#### Paciente
- `id`: Identificador único
- `nome`: Nome do paciente
- `idade`: Idade do paciente
- `sintomas`: Descrição dos sintomas
- `prioridade`: VERMELHA, AMARELA, VERDE
- `gravidade`: LEVE, MODERADA, GRAVE
- `dataTriagem`: Data/hora da triagem
- `emAtendimento`: Status de atendimento

#### Médico
- `id`: Identificador único
- `nome`: Nome do médico
- `especialidade`: Especialidade médica
- `crm`: Número do CRM
- `emPlantao`: Status de plantão

## 🎯 Critérios de Priorização

O sistema utiliza um algoritmo inteligente para determinar a ordem de atendimento:

1. **Prioridade da Triagem**: Vermelha > Amarela > Verde
2. **Gravidade do Caso**: Grave > Moderada > Leve
3. **Tempo de Espera**: Pacientes que aguardam há mais tempo
4. **Disponibilidade de Médicos**: Apenas pacientes com médicos em plantão

## 🧪 Testes

Para executar os testes:
```bash
mvn test
```

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 👨‍💻 Autor

**Reryck** - [GitHub](https://github.com/Reryck)

---

⭐ Se este projeto foi útil para você, considere dar uma estrela no repositório! 
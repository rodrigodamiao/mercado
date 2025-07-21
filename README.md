# Sistema de Gestão de Vendas (Mercado)

Este projeto é uma API REST para gerenciamento de um sistema de vendas, desenvolvido com **Java**, **Spring Boot** e **JPA (Hibernate)**. A aplicação simula um sistema de mercado com funcionalidades como cadastro de usuários, registro de vendas, controle de estoque e gerenciamento de produtos.

---

## 🧱 Tecnologias Utilizadas

- Java 17+
- Spring Boot 3+
- Spring Web
- Spring Data JPA
- Hibernate
- Bean Validation (Jakarta)
- Banco de Dados: H2 (pode ser adaptado para MySQL ou PostgreSQL)
- Lombok
- Postman (para testes manuais)

---

## 🧩 Funcionalidades

### Usuários (com `Cargo`)
- Cadastro de usuário
- Listagem de todos os usuários
- Buscar usuário por ID
- Atualização de usuário
- Exclusão de usuário

### Produtos
- Cadastro de produto
- Listagem de produtos
- Busca por ID
- Atualização e exclusão
- Controle de estoque (estoque decrementado a cada venda)

### Vendas
- Registro de venda com múltiplos itens (`ItemVenda`)
- Cálculo automático do preço total da venda
- Associação de venda ao usuário que realizou
- Atualização do estoque do produto automaticamente

---

## 🔐 Validações
- Utilização do Bean Validation (`@NotNull`, `@NotBlank`, `@Positive`, `@Min`, etc)
- Validação no nível de DTOs para separar regras de negócio e persistência

---

## 📁 Estrutura de Pastas

```
src/main/java/com/damzik/mercado
│
├── controllers           # Controllers REST
├── dtos                  # DTOs de request e response
├── entities              # Entidades JPA
├── repositories          # Interfaces de acesso a dados
├── services              # Regras de negócio
└── enums                 # Enumerações (ex: Cargo, CategoriaProduto)
```

---

## ✅ Exemplos de JSON

### Criar Produto
```json
{
  "nome": "Arroz",
  "categoriaProduto": "ALIMENTO",
  "preco": 15.90,
  "quantidadeEstoque": 100
}
```

### Criar Usuário
```json
{
  "nome": "João da Silva",
  "email": "joao@email.com",
  "senha": "123456",
  "cargo": "FUNCIONARIO"
}
```

### Criar Venda
```json
{
  "usuarioId": 1,
  "produtos": [
    {
      "produtoId": 1,
      "quantidade": 3
    },
    {
      "produtoId": 2,
      "quantidade": 2
    }
  ]
}
```

---

## 🚀 Como Rodar

1. Clone o projeto
2. Execute o projeto no IntelliJ ou via terminal com `mvn spring-boot:run`
3. Acesse: `http://localhost:8080`
4. Teste os endpoints com Postman

---

## 🔒 Segurança

Este projeto ainda **não** utiliza Spring Security, mas está preparado para futura implementação de autenticação e autorização com base em `cargo` de usuário (`GERENTE`, `FUNCIONARIO`).

---

## 🧠 Possíveis Melhorias Futuras

- Implementação de autenticação com Spring Security e JWT
- Filtros por data ou nome de produto/usuário
- Relatórios mensais de vendas
- Controle de usuários com diferentes permissões
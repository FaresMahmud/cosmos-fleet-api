# Cosmos Fleet API

Projeto em Java com Spring Boot para representar uma frota de naves espaciais e simular regras basicas de consumo de combustivel.

## Sobre o projeto

A aplicacao modela naves espaciais usando heranca e classes especializadas:

- `NaveEspacial`: classe base com identificador, combustivel, velocidade e regra de viagem.
- `NaveCargueiro`: nave voltada para transporte de carga, com consumo influenciado pelo peso carregado.
- `NaveCombate`: nave voltada para combate, com consumo influenciado pelo uso do escudo.

Tambem foram criadas excecoes especificas para tratar combustivel invalido e combustivel insuficiente durante uma viagem.

## Tecnologias

- Java 17
- Spring Boot
- Maven
- JUnit

## Como executar

No Windows:

```bash
.\mvnw.cmd spring-boot:run
```

Em Linux ou macOS:

```bash
./mvnw spring-boot:run
```

## Como testar

No Windows:

```bash
.\mvnw.cmd test
```

Em Linux ou macOS:

```bash
./mvnw test
```

## Estrutura principal

```text
src/main/java/com/cosmos/fleet
├── exception
├── model
└── CosmosFleetApiApplication.java
```

## Status

Projeto em desenvolvimento, com foco inicial na criacao das classes de dominio da frota espacial.

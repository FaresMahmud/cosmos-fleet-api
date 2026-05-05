# Cosmos Fleet API

Projeto em Java com Spring Boot para gerenciar uma frota de naves espaciais, simular viagens, controlar combustivel e visualizar as naves por uma interface web com modelos 3D.

## Demo

https://youtu.be/vyP8EKZkhj4

## Sobre o projeto

A aplicacao modela naves espaciais usando heranca e classes especializadas:

- `NaveEspacial`: classe base com identificador, combustivel, velocidade e regra de viagem.
- `NaveCargueiro`: nave voltada para transporte de carga, com consumo influenciado pelo peso carregado.
- `NaveCombate`: nave voltada para combate, com consumo influenciado pelo uso do escudo.
- `NaveExploracao`: nave voltada para exploracao, com consumo influenciado por sensores avancados.

Tambem foram criadas excecoes especificas para tratar combustivel invalido e combustivel insuficiente durante uma viagem.

O projeto conta com rotas REST para listar, buscar, criar, remover, abastecer e consultar o historico de viagens das naves.

A interface web tambem possui uma visualizacao 3D das naves usando Three.js.

## Tecnologias

- Java 17
- Spring Boot
- Maven
- JUnit
- Three.js

## Como executar

No Windows:

```bash
.\mvnw.cmd spring-boot:run
```

Em Linux ou macOS:

```bash
./mvnw spring-boot:run
```

Depois de iniciar a aplicacao, acesse:

```text
http://localhost:8080
```

Na interface e possivel visualizar a frota, criar novas naves, abastecer, realizar viagens, remover naves e abrir a visualizacao 3D de cada modelo.

## Rotas principais

```text
GET    /naves
GET    /naves/{identificador}
POST   /naves
DELETE /naves/{identificador}
POST   /naves/{identificador}/viajar?distancia=100
PATCH  /naves/{identificador}/abastecer?quantidade=200
GET    /naves/historico
GET    /naves/{identificador}/historico
```

Exemplo de JSON para criar uma nave:

```json
{
  "identificador": "Explorer II",
  "tipo": "exploracao",
  "combustivelMaximo": 700,
  "velocidadeBase": 95,
  "possuiSensoresAvancados": true
}
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
|-- controller
|-- exception
|-- model
|-- service
`-- CosmosFleetApiApplication.java
```

## Status

Projeto em desenvolvimento, com classes de dominio, camada de servico, rotas REST, historico de viagens e interface web com visualizacao 3D para controle da frota.

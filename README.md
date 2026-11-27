# Aureus

A backend-focused digital banking and payments platform designed to explore financial correctness, transactional consistency, concurrency control, and maintainable software architecture.

Aureus is a simulated banking system. It does not process real money or integrate with regulated financial institutions.

## Engineering Objectives

- Financial correctness through double-entry accounting.
- Atomic and idempotent financial transactions.
- Safe concurrent access to account balances.
- Explicit and enforceable architectural boundaries.
- Immutable financial records and reconciliation.
- Automated verification against real PostgreSQL instances.

## Technology Stack

| Technology | Responsibility |
|---|---|
| Java 25 | Programming language |
| Spring Boot | Application framework |
| Spring Data JPA | Entity persistence |
| Spring JDBC | Financial persistence |
| PostgreSQL 17 | Relational database |
| Flyway | Database migrations |
| Docker Compose | Local infrastructure |
| Testcontainers | Integration testing |
| ArchUnit | Architecture verification |
| GitHub Actions | Continuous integration |
| Maven | Build and dependency management |

## Architecture

Aureus follows a modular monolith architecture, organizing business capabilities into independent modules with explicit boundaries.

Each module follows hexagonal architecture principles, separating business logic from infrastructure concerns.

See [Architecture](docs/architecture.md) for further details.

## Getting Started

### Prerequisites

- Java 25
- Docker
- Docker Compose

### Start the database

```bash
cp .env.example .env
```

Configure the database password in `.env`.

```bash
docker compose up -d
```

### Run the application

```bash
set -a
source .env
set +a

./mvnw spring-boot:run
```

### Verify application health

```bash
curl http://localhost:8080/actuator/health
```

### Run automated tests

```bash
./mvnw clean verify
```

Integration tests provision their own PostgreSQL instance through Testcontainers.

## Development Roadmap

- [x] Engineering foundation
- [ ] Identity and account management
- [ ] Double-entry ledger
- [ ] Internal transfers and concurrency control
- [ ] Transaction history and reconciliation
- [ ] Security hardening
- [ ] Observability and performance
- [ ] Deployment

## Documentation

- [System architecture](docs/architecture.md)
- [Financial invariants](docs/financial-invariants.md)
- [Architecture Decision Records](docs/adr/)

## Disclaimer

Aureus is an educational software engineering project and is not intended for real-world financial operations.
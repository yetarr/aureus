# System Architecture

## Architectural Style

Aureus is designed as a modular monolith with hexagonal architecture principles applied within individual business modules.

The application is deployed as a single process and uses a shared PostgreSQL database. Business modules communicate through explicit contracts rather than accessing each other's internal implementations.

## Business Modules

| Module | Responsibility |
|---|---|
| Identity | User identity, authentication and authorization |
| Accounts | Account ownership, lifecycle and metadata |
| Transfers | Transfer orchestration and idempotency |
| Ledger | Journal entries, postings and balance projections |
| Audit | Security and business audit records |
| Reconciliation | Financial consistency verification |

## Module Structure

Modules may contain the following packages as their functionality develops:

- `domain`: Business entities, value objects and invariants.
- `application`: Use cases, orchestration and ports.
- `infrastructure`: Persistence adapters and framework integrations.
- `api`: HTTP controllers and transport-specific models.

Public inter-module contracts are exposed through the module's base package.

## Dependency Rules

- Domain models must remain independent of Spring and persistence frameworks.
- Application services coordinate domain operations.
- Infrastructure adapters implement application or domain ports.
- Modules must not access another module's internal implementation.
- Circular dependencies between modules are prohibited.

## Persistence

Spring Data JPA is used for conventional entity persistence.

Spring JDBC is used for ledger operations requiring explicit SQL, deterministic locking and precise transactional behavior.

Both persistence mechanisms use the same PostgreSQL database and must participate in a shared transaction when required by a business operation.

Flyway is the sole authority for database schema changes.

## Transaction Management

Financial operations must execute within explicit transaction boundaries.

A successful internal transfer must atomically persist its transfer record, journal entries, balance changes and idempotency outcome.

Partial financial updates must never become externally visible.

## Architecture Verification

ArchUnit is used to verify architectural constraints during automated builds. Additional rules will be introduced as business modules are implemented.
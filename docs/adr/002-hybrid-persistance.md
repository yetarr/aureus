# ADR-0002: Adopt Hybrid Persistence

**Status:** Accepted

## Context

Aureus requires both conventional entity persistence and financial operations involving explicit SQL, concurrency control and deterministic locking.

## Decision

Use Spring Data JPA for conventional entity persistence and Spring JDBC for financial ledger operations.

Both mechanisms will use the same PostgreSQL database and participate in compatible Spring-managed transactions.

## Alternatives Considered

- JPA exclusively.
- JDBC exclusively.
- jOOQ.

## Consequences

- Reduced boilerplate for conventional entities.
- Explicit control over financial SQL.
- Increased flexibility for performance optimization.
- Developers must understand both persistence models.
- Transaction participation and persistence-context consistency require careful verification.
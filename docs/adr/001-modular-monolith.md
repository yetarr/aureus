# ADR-0001: Adopt a Modular Monolith

**Status:** Accepted

## Context

Aureus requires multiple business capabilities with strong transactional consistency and clear ownership boundaries.

Introducing distributed services prematurely would increase operational complexity and complicate financial transactions.

## Decision

Adopt a modular monolith organized around business capabilities, with hexagonal architecture principles within modules.

## Alternatives Considered

- Traditional layered monolith.
- Microservices architecture.

## Consequences

- Simpler deployment and operational management.
- Local database transactions across business operations.
- Reduced distributed systems complexity.
- Independent module evolution through explicit contracts.
- Architectural boundaries require active enforcement.
- Modules cannot be deployed or scaled independently.
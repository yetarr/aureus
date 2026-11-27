# ADR-0003: Adopt Double-Entry Accounting

**Status:** Accepted

## Context

Financial operations require traceability, consistency verification and reliable historical records.

A mutable account balance alone cannot provide sufficient accounting guarantees.

## Decision

Represent financial operations using immutable double-entry journal entries and postings.

The ledger is the authoritative source of financial balances. Account balance projections are maintained transactionally for efficient access.

Corrections are represented through compensating journal entries.

## Alternatives Considered

- Mutable account balances with transaction history.
- Single-entry transaction records.

## Consequences

- Financial operations become independently verifiable.
- Historical accounting records are preserved.
- Reconciliation becomes possible.
- Additional storage and implementation complexity.
- Balance projections must remain consistent with the ledger.
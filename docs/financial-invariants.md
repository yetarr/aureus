# Financial Invariants

This document defines the financial correctness requirements of Aureus. These requirements must be enforced through domain logic, database constraints, transactional boundaries and automated tests.

## INV-001 — Balanced Journals

Every posted journal must contain at least two postings.

For each currency, the sum of debit amounts must equal the sum of credit amounts.

## INV-002 — Positive Posting Amounts

Every ledger posting must have a strictly positive monetary amount. Its accounting direction is represented separately as debit or credit.

## INV-003 — Ledger Immutability

Committed journal entries and postings must not be updated or deleted.

Corrections must be represented through compensating journal entries.

## INV-004 — Monetary Precision

Monetary amounts must be represented as integer minor units.

Floating-point arithmetic must not be used for monetary calculations.

Arithmetic overflow must be detected and rejected.

## INV-005 — Atomicity

A financial operation must either commit all its required state changes or commit none of them.

## INV-006 — Idempotency

Repeated requests using the same idempotency key within the same requester and operation scope must not produce additional financial effects.

Reusing a key with a different request payload must be rejected.

## INV-007 — Insufficient Funds

Customer accounts must not acquire negative available balances through withdrawals or outgoing transfers.

Overdraft functionality is outside the initial project scope.

## INV-008 — Balance Consistency

An account's stored balance projection must equal the balance derived from its committed ledger postings, according to its accounting classification.

## INV-009 — Currency Consistency

Internal transfers must operate between accounts using the same currency.

The initial system supports EUR exclusively.

## INV-010 — Concurrency Safety

Concurrent financial operations must preserve all financial invariants.

Concurrent requests must not allow funds to be spent more than once.

## INV-011 — Traceability

Every posted financial operation must be traceable to its originating business operation.

## INV-012 — Conservation of Funds

Internal transfers must not create or destroy customer funds.

Simulated funding operations must have corresponding offsetting ledger postings.

## Verification Strategy

Each invariant must eventually have corresponding automated tests. Database-dependent guarantees must be verified against PostgreSQL rather than an in-memory substitute.
# ADR-0004: Represent Money Using Integer Minor Units

**Status:** Accepted

## Context

Financial calculations require exact monetary representation and predictable arithmetic.

Floating-point representations introduce rounding errors that are unacceptable for ledger operations.

## Decision

Represent monetary amounts using signed 64-bit integers containing currency minor units.

Use Java `long` and PostgreSQL `BIGINT`.

Currency is represented explicitly. The initial system supports EUR, where one euro equals one hundred minor units.

Arithmetic operations must detect overflow.

## Alternatives Considered

- Java BigDecimal with PostgreSQL NUMERIC.
- Floating-point monetary representation.

## Consequences

- Exact representation of supported monetary amounts.
- Efficient arithmetic and database storage.
- Explicit conversion at API boundaries.
- Maximum representable monetary amounts are bounded.
- Fractional minor units and future currency-specific precision requirements need explicit handling.
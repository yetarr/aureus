CREATE TABLE schema_metadata (
    id SMALLINT PRIMARY KEY,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),

    CONSTRAINT chk_schema_metadata_id CHECK (id = 1)
);

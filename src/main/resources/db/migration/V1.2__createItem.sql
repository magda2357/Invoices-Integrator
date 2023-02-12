CREATE TABLE TestDB.Invoices.item
(
    id              BIGINT PRIMARY KEY,
    vat_rate        FLOAT NOT NULL,
    quantity        INTEGER NOT NULL,
    unit_price      DECIMAL NOT NULL,
    full_name       VARCHAR(255) NOT NULL,
    unit            VARCHAR(10),
    vat_rate_type   VARCHAR(3) NOT NULL,
    invoice_id      BIGINT,
    FOREIGN KEY (invoice_id) REFERENCES TestDB.Invoices.invoice (id)
);
CREATE TABLE TestDB.Invoices.client
(
    id          BIGINT PRIMARY KEY,
    number      VARCHAR(30)  NOT NULL,
    buyer_nip   VARCHAR(13),
    name        VARCHAR(100) NOT NULL,
    nip         VARCHAR(13),
    street      VARCHAR(100),
    postal_code VARCHAR(6),
    city        VARCHAR(100),
    invoice_id  BIGINT,
    FOREIGN KEY (invoice_id) REFERENCES TestDB.Invoices.invoice (id)
);
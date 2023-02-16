CREATE TABLE TestDB.Invoices.invoice
(
    id                             BIGINT PRIMARY KEY,
    payment                        DECIMAL NOT NULL ,
    payment_on_document            DECIMAL NOT NULL ,
    tax_base                       VARCHAR(3) NOT NULL ,
    banking_account_number         VARCHAR(28),
    issue_date                     DATE NOT NULL,
    issue_place                    VARCHAR(50),
    sale_date_format               VARCHAR(3) NOT NULL,
    payment_date                   DATE NOT NULL,
    sale_date                      DATE NOT NULL,
    payment_type                   VARCHAR(3) NOT NULL,
    numbering_series_name          VARCHAR(30),
    template_name                  VARCHAR(50),
    receiver_signature_type        VARCHAR(3) NOT NULL,
    comments                       VARCHAR(255),
    visible_gios_number_bdo_number INTEGER,
    number                         VARCHAR(30) NOT NULL
);
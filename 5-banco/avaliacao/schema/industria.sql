-- CREATE SCHEMA industria;
use industria;

CREATE TABLE cargo(
	cod_cargo INTEGER NOT NULL AUTO_INCREMENT,
	cargo VARCHAR(50),
    CONSTRAINT cargo_pkey PRIMARY KEY (cod_cargo)    
);
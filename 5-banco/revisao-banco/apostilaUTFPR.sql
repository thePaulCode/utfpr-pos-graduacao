CREATE SCHEMA apostilaUTFPR;
USE apostilaUTFPR;

CREATE TABLE especialidades (
	cod_especialidade integer NOT NULL AUTO_INCREMENT,
    nome_especialidade VARCHAR(50),
    PRIMARY KEY (cod_especialidade)
);

SELECT * FROM apostilautfpr.especialidades WHERE nome_especialidade = 'Ortopedia';

CREATE TABLE medico (
	cod_medico integer NOT NULL AUTO_INCREMENT,
    nome_medico VARCHAR(50),
    crm VARCHAR(10),
    cod_especialidade INT,
    PRIMARY KEY (cod_medico),
    FOREIGN KEY (cod_especialidade) REFERENCES especialidades(cod_especialidade)
);

SELECT * FROM apostilautfpr.medico;

INSERT INTO especialidades (cod_especialidade, nome_especialidade)
VALUES (1, 'Cardiologia');

UPDATE especialidades
SET nome_especialidade = 'Ortopedia'
WHERE cod_especialidade = 1;

DELETE FROM especialidades 
WHERE cod_especialidade = 1;

ALTER TABLE apostilautfpr.medico 
ADD salario DOUBLE NOT NULL;

INSERT INTO medico (cod_medico, nome_medico, crm, cod_especialidade, salario) 
VALUES (4, 'Isaac', '2060', 1, 19000.0);

UPDATE medico
SET nome_medico = 'Ana'
WHERE cod_medico = 3;

SELECT nome_medico
FROM medico
WHERE salario > 50000.0;

SELECT SUM(salario) AS 'Total_Salarios'
FROM medico;

SELECT MIN(salario) AS 'Menor_Salario'
FROM medico;

SELECT  MAX(salario) AS 'Maior_Salario'
FROM medico;

SELECT COUNT(*) AS 'Total_Medicos'
FROM medico;

SELECT AVG(salario) AS 'Media_Salarial'
FROM medico;
CREATE SCHEMA empresa;
USE empresa;

CREATE TABLE departamento(
	cod_depto INTEGER NOT NULL AUTO_INCREMENT,
    nome_depto CHARACTER VARYING(50),
    CONSTRAINT departamento_pkey PRIMARY KEY (cod_depto)
);

CREATE TABLE funcionario(
	cod_funcionario INTEGER NOT NULL AUTO_INCREMENT,
    cod_depto INTEGER NOT NULL,
    nome_funcionario CHARACTER VARYING(50),
    qtde_dependentes INT(11),
    salario FLOAT4(7,2),
    cargo CHARACTER VARYING(50),    
    CONSTRAINT funcionario_pkey PRIMARY KEY (cod_funcionario),
    CONSTRAINT funcionario_cod_depto_fkey FOREIGN KEY (cod_depto) REFERENCES departamento(cod_depto)
);

INSERT INTO departamento (nome_depto) VALUES
('Recursos Humanos'),
('Tecnologia da Informacao'),
('Financas'),
('Vendas'),
('Marketing');

INSERT INTO funcionario(nome_funcionario, qtde_dependentes, salario, cargo, cod_depto) VALUES 
('Paulo San', 1, 3999.90, 'Engenheiro de Software', 2),
('Bruno Turing', 0, 5500.00, 'Desenvolvedor', 2),
('Carlos Pereira', 1, 4800.75, 'Contador', 3),
('Daniela Costa', 3, 4200.40, 'Coordenadora de Marketing', 4),
('Eduardo Lima', 0, 6000.00, 'Gerente de Vendas', 5),
('Fernanda Alves', 2, 3700.25, 'Assistente de RH', 1),
('Gustavo Lima', 1, 9300.80, 'Diretor de Engenharia', 2),
('Helen Roche', 0, 4600.60, 'Assistente Financeiro', 3),
('Isabela Rocha', 1, 4500.20, 'Diretora de Marketing', 4),
('João do Pulo', 2, 6200.00, 'Executivo de Vendas', 5);

# Respostas

# Item 4.a
CREATE VIEW departamento_num_funcionarios AS
SELECT d.nome_depto AS departamento, num_funcionarios
FROM departamento d, (SELECT f.cod_depto AS codDep, COUNT(f.cod_funcionario) AS num_funcionarios
					FROM funcionario f
					GROUP BY f.cod_depto) AS s
WHERE d.cod_depto = codDep
HAVING num_funcionarios = (SELECT MAX(num_funcionarios) AS num_max
						FROM (SELECT f.cod_depto, COUNT(f.cod_funcionario) AS num_funcionarios
						FROM funcionario f
						GROUP BY f.cod_depto) AS r);

# Item 4.b
CREATE VIEW  departamento_menor_qtde_func_dependentes AS
SELECT d.nome_depto AS departamento, num_funcionarios
FROM (SELECT f.cod_depto AS codDep, COUNT(f.cod_funcionario) AS num_funcionarios
	FROM funcionario f
	WHERE f.qtde_dependentes = 0
	GROUP BY f.cod_depto) AS r
JOIN departamento d ON d.cod_depto = codDep;

# Item 4.c
CREATE VIEW departamento_cargo_dir AS
SELECT d.nome_depto AS departamento, nome
FROM (SELECT f.cod_depto AS codDep, f.nome_funcionario AS nome
	FROM funcionario f
	WHERE f.cargo LIKE 'Dir%') AS r
JOIN departamento d ON d.cod_depto = codDep;

# Item 4.d 
CREATE VIEW funcionario_maior_salario AS
SELECT r.nome, d.nome_depto AS departamento
FROM (SELECT f.nome_funcionario AS nome, f.cod_depto AS codDep
				FROM funcionario f
				WHERE f.salario = (SELECT MAX(f.salario) as max_salario
								FROM funcionario f)) AS r
JOIN departamento d ON d.cod_depto = codDep;

# Item 4.e 
CREATE VIEW departamento_funcionario_gerente  AS
SELECT d.nome_depto AS departamento, r.nome_funcionario AS nome
FROM (SELECT f.cod_depto AS codDep, f.nome_funcionario AS nome_funcionario
	FROM funcionario f
	WHERE f.cargo LIKE 'Gerente%'
	GROUP BY f.cod_depto, f.nome_funcionario) AS r
JOIN departamento d ON d.cod_depto = codDep;

CREATE USER 'gerente'@'localhost' IDENTIFIED BY '90Wg!dev';
GRANT ALL PRIVILEGES ON * . * TO 'gerente'@'localhost';

CREATE USER 'funcionario'@'localhost' IDENTIFIED BY 'userDB!';
GRANT CREATE, SELECT ON * . * TO 'funcionario'@'localhost';

FLUSH PRIVILEGES;


USE empresa;

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


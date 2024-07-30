use empresa;

SELECT f.nome_funcionario, d.nome_depto
FROM funcionario f
join departamento d ON f.cod_depto = d.cod_depto and d.cod_depto = 5;

SELECT MAX(f.salario) FROM funcionario f
GROUP BY f.nome_funcionario, f.salario;

SELECT * 
FROM funcionario f
ORDER BY f.salario DESC;

SELECT * FROM departamento;

SELECT f.nome_funcionario 
FROM funcionario f
where qtde_dependentes = 0
ORDER BY f.nome_funcionario ASC;

select * 
from funcionario f where f.salario > 4000;

SELECT * 
FROM funcionario f
WHERE f.nome_funcionario LIKE '%Lima%';

SELECT * 
FROM departamento;

SELECT f.nome_funcionario AS nome, d.nome_depto AS departamento
FROM funcionario f
JOIN departamento d ON d.cod_depto = f.cod_depto AND d.cod_depto = 5;

# STORED PROCEDURES - atividade 05 Banco de Dados
 # Implementar a chamada de uma stored procedure criada no banco de dados, que
# aumenta o salário de todos os funcionários em X porcento, onde X é um número inteiro.

DELIMITER $$
CREATE PROCEDURE proc_aumentar_salario(IN in_valor INT)
BEGIN
	UPDATE funcionario f
    SET f.salario = f.salario * (1 + (in_valor/100)); 
END$$

DELIMITER ;

# DROP PROCEDURE proc_aumentar_salario;
CALL proc_aumentar_salario(10);

# 5-1 

select r.nome_funcionario, r.nome_depto
from (SELECT f.nome_funcionario AS nome, f.cod_depto as codDepto
FROM funcionario f 
WHERE f.qtde_dependentes =0) as r
left join departamento d ON d.cod_depto =  codDepto;

SELECT * from departamento;

SELECT r.nome, d.nome_depto 
from (SELECT f.nome_funcionario as nome, f.cod_depto as codDepto
		FROM funcionario f 
		WHERE f.qtde_dependentes =0) as r
join departamento d ON d.cod_depto = codDepto AND d.nome_depto LIKE 'Financas';

SELECT f.nome_funcionario, d.nome_depto 
from funcionario f
join departamento d ON d.cod_depto = f.cod_depto
WHERE f.qtde_dependentes = 0 AND d.nome_depto LIKE 'Financas';

# 5-3
use empresa;
SELECT * 
from departamento d;

SELECT f.nome_funcionario, d.nome_depto
from funcionario f
JOIN departamento d On f.cod_depto = d.cod_depto;

UPDATE funcionario
set cod_depto = (
	SELECT e.cod_depto 
	FROM departamento e
	WHERE e.nome_depto LIKE 'Tecnologia da Informacao'                                  
)
WHERE cod_depto IN (
	SELECT d.cod_depto 
	FROM departamento d
	WHERE d.nome_depto LIKE 'Recursos Humanos'
);

SELECT d.cod_depto 
FROM departamento d
WHERE d.nome_depto LIKE 'Financas';

# 5-4 delete que exclui todos os funcionários de um determinado 
# departamento utilizando a anotação @Modifying. 
SELECT * from departamento;
SELECT * from funcionario;

DELETE from funcionario f
WHERE cod_depto in (SELECT d.cod_depto 
	FROM departamento d 
	WHERE d.nome_depto LIKE 'Recursos Humanoss');

# 5-5
select *
from funcionario f;

SELECT f.cod_depto, f.nome_funcionario
FROM funcionario f 
WHERE f.qtde_dependentes =0;

# STORED PROCEDURES
use dml;

SELECT * from gravacao;
SELECT * from musica;

DELIMITER $$
CREATE PROCEDURE proc_adiciona_tempo(IN in_valor INT)
BEGIN
	UPDATE musica m
    SET duracao = duracao + in_valor
    WHERE m.cod_musica = 1;
END$$

DELIMITER ;

DELIMITER $$
CREATE PROCEDURE proc_subtrai_tempo(IN in_valor INT)
BEGIN
	UPDATE musica m
    SET duracao = duracao - in_valor
    WHERE m.cod_musica = 1;
END$$
DELIMITER ;

SHOW PROCEDURE STATUS;
DROP PROCEDURE proc_adiciona_tempo;
DROP PROCEDURE proc_subtrai_tempo;

CALL proc_adiciona_tempo(1000);
CALL proc_subtrai_tempo(1000);

SELECT m.duracao 
from musica m
WHERE m.cod_musica = 1;



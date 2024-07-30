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
('Gustavo Lima', 1, 5300.80, 'Analista de Sistemas', 2),
('Helen Roche', 0, 4600.60, 'Assistente Financeiro', 3),
('Isabela Rocha', 1, 4500.20, 'Analista de Marketing', 4),
('João do Pulo', 2, 6200.00, 'Executivo de Vendas', 5);


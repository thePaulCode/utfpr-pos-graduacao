CREATE TABLE Cidades (
 codCidade INT NOT NULL,
 nomeCidade CHAR(50),
 estadoUf CHAR(2)
);

ALTER TABLE Cidades ADD CONSTRAINT PK_Cidades PRIMARY KEY (codCidade);


CREATE TABLE Turmas (
 codTurma INT NOT NULL,
 turno CHAR(10)
);

ALTER TABLE Turmas ADD CONSTRAINT PK_Turmas PRIMARY KEY (codTurma);


CREATE TABLE Alunos (
 codAluno INT NOT NULL,
 nomeAluno CHAR(50),
 codTurma INT,
 codCidade INT
);

ALTER TABLE Alunos ADD CONSTRAINT PK_Alunos PRIMARY KEY (codAluno);


ALTER TABLE Alunos ADD CONSTRAINT FK_Alunos_0 FOREIGN KEY (codTurma) REFERENCES Turmas (codTurma);
ALTER TABLE Alunos ADD CONSTRAINT FK_Alunos_1 FOREIGN KEY (codCidade) REFERENCES Cidades (codCidade);



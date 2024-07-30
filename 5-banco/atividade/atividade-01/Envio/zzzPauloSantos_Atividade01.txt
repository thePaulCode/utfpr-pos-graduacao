USE dml;
# Respostas

# Questao 01
SELECT c.nome_cantor, gr.num_gravacoes
FROM cantor c, (SELECT g.cod_cantor AS codCantor, COUNT(g.cod_cantor) AS num_gravacoes
				FROM gravacao g
				GROUP BY cod_cantor) AS gr 
WHERE c.cod_cantor = codCantor
HAVING gr.num_gravacoes = (SELECT MIN(r.num_gravacoes) AS min_gravacoes
						FROM (SELECT g.cod_cantor, COUNT(g.cod_cantor) AS num_gravacoes
						FROM gravacao g
						GROUP BY cod_cantor) AS r);
                        
# Questao 02			
SELECT c.nome_cantor, r.num_gravadoras
FROM cantor c, (SELECT c.cod_cantor AS codCantor, COUNT(DISTINCT g.cod_gravadora) AS num_gravadoras
				FROM cantor c
				JOIN gravacao g ON c.cod_cantor = g.cod_cantor
				GROUP BY c.cod_cantor) AS r
WHERE c.cod_cantor = codCantor
HAVING r.num_gravadoras = (SELECT MAX(r.num_gravadoras) AS max_gravadoras
							FROM (SELECT c.cod_cantor, COUNT(DISTINCT g.cod_gravadora) AS num_gravadoras
							FROM cantor c
							JOIN gravacao g ON c.cod_cantor = g.cod_cantor
							GROUP BY c.cod_cantor) AS r)
ORDER BY c.nome_cantor ASC;
                            
# Questao 03
SELECT c.nome_cantor, res.media_duracao
FROM cantor c, (SELECT g.cod_cantor AS codCantor, AVG(m.duracao) AS media_duracao
				FROM gravacao g
				JOIN musica m ON g.cod_musica = m.cod_musica
				GROUP BY g.cod_cantor) AS res
WHERE c.cod_cantor = codCantor
HAVING res.media_duracao = (SELECT MAX(r.media_duracao) AS max_media
					 FROM (SELECT g.cod_cantor, AVG(m.duracao) AS media_duracao
					 FROM gravacao g
					 JOIN musica m ON g.cod_musica = m.cod_musica
					 GROUP BY g.cod_cantor) AS r);

# Questao 04
SELECT c.nome_cantor
FROM cantor c
WHERE c.cod_cantor NOT IN (
	SELECT g.cod_cantor
	FROM gravacao g
	WHERE g.cod_gravadora = 1)
GROUP BY c.nome_cantor;

# Questao 05
SELECT c.nome_cantor AS cantor, m.titulo AS musica, dt.datas AS data_gravacao
FROM (SELECT g.cod_cantor AS codCantor, g.cod_musica AS codMusica, g.data_gravacao AS datas
	  FROM gravacao g
	  WHERE g.data_gravacao LIKE '2004%') AS dt
JOIN cantor c ON c.cod_cantor = codCantor 
JOIN musica m ON m.cod_musica = codMusica;

# Questao 06
SELECT c.nome_cantor, MAX(g.data_gravacao) AS data_ultima_gravacao
FROM cantor c
LEFT JOIN gravacao g ON c.cod_cantor = g.cod_cantor
GROUP BY c.nome_cantor 
ORDER BY data_ultima_gravacao DESC;

# Questao 07
SELECT p.nome_pessoa,
	   fr.numero AS fone_residencial,
       fc.numero AS fone_comercial,
       fl.numero AS ceular
FROM pessoa p
JOIN fone fr ON p.cod_pessoa = fr.cod_pessoa  AND fr.tipo = "R"
JOIN fone fc ON p.cod_pessoa = fc.cod_pessoa  AND fc.tipo = "C"
JOIN fone fl ON p.cod_pessoa = fl.cod_pessoa  AND fl.tipo = "L";












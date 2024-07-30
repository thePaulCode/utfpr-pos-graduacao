USE world;

SELECT c.Name, COUNT(*) AS Cidades_Parana
FROM country c, city ct
WHERE c.Code = ct.Countrycode
GROUP BY c.Name;

SELECT * FROM country
WHERE country.Code = 'BRA';

SELECT * FROM city;


 CREATE VIEW populacao_brazil AS
SELECT ct.ID, ct.Name AS Cidades, ct.Population AS Populacao
FROM country c, city ct
WHERE c.Code = ct.CountryCode
AND c.Name = 'Brazil'
AND ct.Population = (SELECT MIN(ct.Population) AS Maior_Populacao
					FROM country c2, city ct2
					WHERE c2.Code = ct2.CountryCode
					AND c2.Name = 'Brazil'
					);
                    
                    
		
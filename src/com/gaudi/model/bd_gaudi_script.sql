/**
 * Author:  Javier Vergara Lee
 * Created: 29-06-2018
 */
 
 CREATE DATABASE bd_gaudi;
 -- DROP DATABASE bd_gaudi;
 USE bd_gaudi;

CREATE TABLE tecnica(
    id INT AUTO_INCREMENT PRIMARY KEY,
    tecnica VARCHAR(100)
); -- DROP TABLE tecnica;

CREATE TABLE genero(
    id INT AUTO_INCREMENT PRIMARY KEY,
    genero VARCHAR(100)
); -- DROP TABLE genero;

CREATE TABLE encargado(
    rut VARCHAR(100) UNIQUE PRIMARY KEY,
    nombre VARCHAR(100),
    profesion VARCHAR(100),
    anioIngreso DATE
); -- DROP TABLE encargado;

CREATE TABLE sala(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombreSala VARCHAR(100),
    lamparas INT,
    temperatura FLOAT,
    cierreCentralizado BOOLEAN,
    alarmaIncendio BOOLEAN,
    fk_encargado VARCHAR(100) REFERENCES encargado(rut)
); -- DROP TABLE sala;

CREATE TABLE autor(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombreAutor VARCHAR(100)
); -- DROP TABLE autor;

CREATE TABLE obra(
    codigo INT PRIMARY KEY,
    nombreObra VARCHAR(100),
    anio INT,
    alto FLOAT,
    ancho FLOAT,
    fk_tecnica INT REFERENCES tecnica(id),
    fk_genero INT REFERENCES genero(id),
    fk_autor INT REFERENCES autor(id),
    fk_sala INT REFERENCES sala(id)
); -- DROP TABLE obra;

CREATE TABLE usuario(
	id INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(20),
    pass VARCHAR(10)
); -- DROP TABLE usuario;

CREATE VIEW viewObra AS
SELECT
	obra.codigo,
    obra.nombreObra,
    obra.anio,
    obra.alto,
    obra.ancho,
    tecnica.tecnica,
    genero.genero,
    autor.nombreAutor,
    sala.nombreSala
FROM
	obra
JOIN tecnica ON obra.fk_tecnica = tecnica.id
JOIN genero ON obra.fk_genero = genero.id
JOIN autor ON obra.fk_autor = autor.id
JOIN sala ON obra.fk_sala = sala.id;
-- DROP VIEW viewObra;

DELIMITER //
CREATE PROCEDURE crearObra(codigo INT, nombreObra VARCHAR(100), anio INT, alto FLOAT, ancho FLOAT, nombreTecnica VARCHAR(100), nombreGenero VARCHAR(100), autor VARCHAR(100), sala VARCHAR(100))
BEGIN
	DECLARE idTecnica INT;
    DECLARE idGenero INT;
    DECLARE idAutor INT;
    DECLARE idSala INT;
    
    SET idTecnica = (SELECT id FROM tecnica WHERE tecnica = nombreTecnica);
	SET idGenero = (SELECT id FROM genero WHERE genero = nombreGenero);
	SET idAutor = (SELECT id FROM autor WHERE nombreAutor = autor);
	SET idSala = (SELECT id FROM sala WHERE nombreSala = sala);
    
    INSERT INTO obra VALUES(codigo, nombreObra, anio, alto, ancho, idTecnica, idGenero, idAutor, idSala);
END //
DELIMITER ; 
-- DROP PROCEDURE crearObra;

/*USUARIOS*/
INSERT INTO usuario VALUES(NULL, 'admin', 'admin');
-- SELECT * FROM usuario;

/*TECNICAS*/
INSERT INTO tecnica VALUES(NULL, 'Óleo');
INSERT INTO tecnica VALUES(NULL, 'Cera');
INSERT INTO tecnica VALUES(NULL, 'Acuarela');
INSERT INTO tecnica VALUES(NULL, 'Témpera');
INSERT INTO tecnica VALUES(NULL, 'Acrílico');
INSERT INTO tecnica VALUES(NULL, 'Pastel');
INSERT INTO tecnica VALUES(NULL, 'Temple');
INSERT INTO tecnica VALUES(NULL, 'Tinta');
INSERT INTO tecnica VALUES(NULL, 'Fresco');
INSERT INTO tecnica VALUES(NULL, 'Grisalla');
INSERT INTO tecnica VALUES(NULL, 'Puntillismo');
INSERT INTO tecnica VALUES(NULL, 'Dripping');
INSERT INTO tecnica VALUES(NULL, 'Grafiti');
INSERT INTO tecnica VALUES(NULL, 'Mixta');
-- SELECT * FROM tecnica;

/*GÉNEROS*/
INSERT INTO genero VALUES(NULL, 'Histórica');
INSERT INTO genero VALUES(NULL, 'Retrato');
INSERT INTO genero VALUES(NULL, 'De Género');
INSERT INTO genero VALUES(NULL, 'Paisaje');
INSERT INTO genero VALUES(NULL, 'Naturaleza Muerta');
INSERT INTO genero VALUES(NULL, 'Desnudo');
INSERT INTO genero VALUES(NULL, 'Surrealismo');
-- SELECT * FROM genero;

/*AUTORES*/
INSERT INTO autor VALUES(NULL, 'Vincent Van Gogh');
INSERT INTO autor VALUES(NULL, 'Claude Monet');
INSERT INTO autor VALUES(NULL, 'Pablo Picasso');
INSERT INTO autor VALUES(NULL, 'Leonardo da Vinci');
INSERT INTO autor VALUES(NULL, 'Rembrandt');
INSERT INTO autor VALUES(NULL, 'Michelangelo');
INSERT INTO autor VALUES(NULL, 'Pierre-Auguste Renoir');
INSERT INTO autor VALUES(NULL, 'Johannes Vermeer');
INSERT INTO autor VALUES(NULL, 'Salvador Dalí');
-- SELECT * FROM autor;

/*ENCARGADOS*/
INSERT INTO encargado VALUES('11234253-2', 'Manuel Fuensalida', 'Profesor de Arte', '2018-01-01');
INSERT INTO encargado VALUES('16019515-0', 'Josefina Pérez', 'Crítico de Arte', '2010-05-03');
-- SELECT * FROM encargado;

/*SALAS*/
INSERT INTO sala VALUES(NULL, 'Picasso', 10, 19.5, true, true, '11234253-2');
INSERT INTO sala VALUES(NULL, 'Gaudí', 15, 21.0, true, true, '16019515-0');
-- SELECT * FROM sala;

/*OBRA*/
INSERT INTO obra VALUES(2759, 'La Persistencia de la Memoria', 1931, 24, 33, 1, 7, 9, 1);
-- SELECT * FROM obra;

-- CALL crearObra(1458, 'El Test', 1934, 10, 10, 'Pastel', 'Paisaje', 'Vincent Van Gogh', 'Picasso');
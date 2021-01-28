
/* Questões SQL Teste Técnico - Luby Software */
/* Questão 2.1 */

SELECT pessoa.nome, evento.evento
FROM tabela_pessoa AS pessoa JOIN tabela_evento AS evento 
ON pessoa.id = evento.pessoa_id;

/* Questão 2.2 */

SELECT * FROM tabela_pessoa
WHERE nome LIKE '%Doe%';

/* Questão 2.3 */

INSERT INTO tabela_evento (evento, pessoa_id) VALUES ('Evento E', 
		(SELECT id FROM tabela_pessoa WHERE nome = 'Lisa Romero'));


/* Questão 2.4 */

UPDATE tabela_evento
SET pessoa_id = (SELECT id FROM tabela_pessoa WHERE nome = 'John Doe')
WHERE evento = 'Evento D';

/* Questão 2.5 */

DELETE FROM tabela_evento
WHERE evento = 'Evento B';

/* Questão 2.6 */

DELETE FROM tabela_pessoa
WHERE id NOT IN (SELECT DISTINCT pessoa.id FROM tabela_pessoa AS pessoa JOIN tabela_evento AS evento
					ON pessoa.id = evento.pessoa_id);

/* Questão 2.7 */

ALTER TABLE tabela_pessoa
ADD COLUMN idade INTEGER;

/* Questão 2.8 */

CREATE TABLE tabela_telefone (
	id INTEGER,
	telefone VARCHAR(200),
	pessoa_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY (pessoa_id) REFERENCES tabela_pessoa (id)
);

/* Questão 2.9 */

ALTER TABLE tabela_telefone
ADD CONSTRAINT unico UNIQUE (telefone);

/* Questão 2.10 */

DROP TABLE tabela_telefone;

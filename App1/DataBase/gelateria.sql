CREATE TABLE IF NOT EXISTS prenotante
(
    id INT NOT NULL PRIMARY KEY,
    nome VARCHAR(25)
);

CREATE TABLE IF NOT EXISTS gelato
(
    id INT NOT NULL PRIMARY KEY,
    nome VARCHAR(55),
    descrizione TEXT
);

CREATE TABLE IF NOT EXISTS prenotazione
(
    id_prenotante INT NOT NULL,
    id_gelato INT NOT NULL,
    PRIMARY KEY (id_prenotante, id_gelato),
    CONSTRAINT prenotazione_id_prenotante_fk
    FOREIGN KEY(id_prenotante) REFERENCES prenotante(id),
    CONSTRAINT prenotazione_id_gelato_fk
    FOREIGN KEY(id_gelato) REFERENCES gelato(id)
);

INSERT INTO prenotante
    (id, nome)
VALUES
    (1, 'Chiara'),
    (2, 'Francesco'),
    (3, 'Vincenzo'),
    (4, 'Leonardo'),
    (5, 'Gaetano'),
    (6, 'Giovanni');

INSERT INTO gelato
    (id, nome, descrizione)
VALUES
    (1, 'cioccolato', 'cioccolato fatto con le nostre mani'),
    (2, 'pistacchio', 'pistacchio di bronte'),
    (3, 'nocciola', 'nocciola buonissima');

INSERT INTO prenotazione
    (id_prenotante, id_gelato)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);

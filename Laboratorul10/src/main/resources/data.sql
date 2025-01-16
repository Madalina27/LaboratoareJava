DROP TABLE IF EXISTS carte;

CREATE TABLE carte
(
    ISBN  INT PRIMARY KEY AUTO_INCREMENT,
    titlu VARCHAR(50) NOT NULL,
    autor VARCHAR(50) NOT NULL
);

INSERT INTO carte (autor, titlu)
VALUES ("Gabriel Garcia Marquez", "Un veac de singurătate");
INSERT INTO carte (autor, titlu)
VALUES ("George Orwell", "1984");
INSERT INTO carte (autor, titlu)
VALUES ("Jane Austen", "Mândrie și prejudecată");

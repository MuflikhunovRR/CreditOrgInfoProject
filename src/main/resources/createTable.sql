SELECT * FROM biclist;

INSERT INTO biclist (id, bic, rc, nm, rb, rn, intcode) VALUES (2,2,'1','1','1','1','1');

DELETE from biclist where id >= 1;

DROP TABLE biclist;

CREATE TABLE bicList(
  id serial PRIMARY KEY,
bic VARCHAR (50) UNIQUE NOT NULL,
rc VARCHAR (50) NOT NULL,
nm VARCHAR (50) NOT NULL,
rb VARCHAR (50) NOT NULL,
rn VARCHAR (50) NOT NULL,
intCode VARCHAR (50) NOT NULL
);
CREATE TABLE BOOK (
  sid INT(11) NOT NULL AUTO_INCREMENT,
  id VARCHAR(25) NOT NULL,
  name VARCHAR(255) NULL DEFAULT NULL,
  description TEXT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE book_author (
  id INT(11) NOT NULL AUTO_INCREMENT,
  book_id VARCHAR(25) NULL DEFAULT NULL,
  author_id VARCHAR(25) NULL DEFAULT NULL,
  PRIMARY KEY (id),
  INDEX FK_book_author_book (book_id),
  INDEX FK_book_author_author (author_id),
  CONSTRAINT FK_book_author_author FOREIGN KEY (author_id) REFERENCES author (id),
  CONSTRAINT FK_book_author_book FOREIGN KEY (book_id) REFERENCES book (id)
);

CREATE TABLE book_genre (
  id INT(11) NOT NULL AUTO_INCREMENT,
  book_id VARCHAR(25) NULL DEFAULT NULL,
  genre_id VARCHAR(25) NULL DEFAULT NULL,
  PRIMARY KEY (id),
  INDEX FK_book_genre_book (book_id),
  INDEX FK_book_genre_genre (genre_id),
  CONSTRAINT FK_book_genre_book FOREIGN KEY (book_id) REFERENCES book (id),
  CONSTRAINT FK_book_genre_genre FOREIGN KEY (genre_id) REFERENCES genre (id)
);

CREATE TABLE genre (
  sid INT(11) NOT NULL AUTO_INCREMENT,
  id VARCHAR(25) NULL,
  name VARCHAR(255) NULL DEFAULT NULL,
  description TEXT NULL,
  PRIMARY KEY (sid)
);

CREATE TABLE author (
  sid INT(11) NOT NULL AUTO_INCREMENT,
  id VARCHAR(25) NULL,
  name VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (sid)
);
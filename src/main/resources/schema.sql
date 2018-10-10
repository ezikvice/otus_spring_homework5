DROP TABLE IF EXISTS book_author;
DROP TABLE IF EXISTS book_genre;
-- DROP TABLE IF EXISTS book_comment;
DROP TABLE IF EXISTS genre;
DROP TABLE IF EXISTS author;
DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS book;

CREATE TABLE genre(
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255),
  `description` TEXT,
  PRIMARY KEY (`id`)
);

CREATE TABLE author(
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255),
  PRIMARY KEY (`id`)
);

CREATE TABLE book (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255),
  `description` TEXT,
  PRIMARY KEY (`id`)
);

CREATE TABLE comment(
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `book_id` INT(11) NULL DEFAULT NULL,
  `text` TEXT,
  PRIMARY KEY (`id`),
  INDEX `FK_comments_book` (`book_id`),
  CONSTRAINT `FK_book_comment_book` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`)
);

CREATE TABLE `book_author` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `book_id` INT(11) NULL DEFAULT NULL,
  `author_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_book_author_book` (`book_id`),
  INDEX `FK_book_author_author` (`author_id`),
  CONSTRAINT `FK_book_author_book` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `FK_book_author_author` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`)
);

CREATE TABLE `book_genre` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `book_id` INT(11) NULL DEFAULT NULL,
  `genre_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_book_genre_book` (`book_id`),
  INDEX `FK_book_genre_genre` (`genre_id`),
  CONSTRAINT `FK_book_genre_book` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `FK_book_genre_genre` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`)
);

-- CREATE TABLE `book_comment` (
--   `id` INT(11) NOT NULL AUTO_INCREMENT,
--   `book_id` INT(11) NULL DEFAULT NULL,
--   `comment_id` INT(11) NULL DEFAULT NULL,
--   PRIMARY KEY (`id`),
--   INDEX `FK_book_comments_book` (`book_id`),
--   CONSTRAINT `FK_book_comment_book` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
--   CONSTRAINT `FK_book_comment_comment` FOREIGN KEY (`comment_id`) REFERENCES `comment` (`id`)
-- );


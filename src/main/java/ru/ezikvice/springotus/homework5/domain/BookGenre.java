package ru.ezikvice.springotus.homework5.domain;

public class BookGenre {
    private int id;

    private int bookId;

    private int genreId;

    public BookGenre(int id, int bookId, int genreId) {
        this.id = id;
        this.bookId = bookId;
        this.genreId = genreId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }
}

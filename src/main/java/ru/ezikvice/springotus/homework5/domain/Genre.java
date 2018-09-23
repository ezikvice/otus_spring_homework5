package ru.ezikvice.springotus.homework5.domain;

public class Genre {
    private int id;
    private String name;
    private String description;

    public Genre(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Genre(int id, String name, String description) {
        this(name, description);
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Genre genre = (Genre) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(getId(), genre.getId())
                .append(getName(), genre.getName())
                .append(getDescription(), genre.getDescription())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(getId())
                .append(getName())
                .append(getDescription())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

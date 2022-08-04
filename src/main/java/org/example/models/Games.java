package org.example.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table
public class Games {
    @Id
    @GeneratedValue
    private int id;

    private String title;

    private String genre;

    private String platform;

    private Integer price;

    private LocalDate created_at;

    private LocalDate updated_at;

    @OneToMany(mappedBy = "games")
    private List<Reviews> reviews = new ArrayList<Reviews>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public LocalDate getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDate updated_at) {
        this.updated_at = updated_at;
    }

    public List<Reviews> getReviews() {
        return reviews;
    }

    public void addReview(Reviews review){
        this.reviews.add(review);
    }

}

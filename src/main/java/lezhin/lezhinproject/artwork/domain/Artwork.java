package lezhin.lezhinproject.artwork.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "artworks")
public class Artwork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private Double price;

    @Column(name = "service_date")
    private String serviceDate;

    @Column(name = "is_adult")
    private boolean isAdult;

    @Builder
    public Artwork(String title, String author, Double price, String serviceDate, boolean isAdult) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.serviceDate = serviceDate;
        this.isAdult = isAdult;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
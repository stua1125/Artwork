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
    private Price price;

    @Column(name = "service_date")
    private String serviceDate;

    @Column(name = "is_adult")
    private boolean isAdult;

    // 생성자에 대한 빌더 패턴 적용
    // 생성자의 파라미터가 많아지면 생성자 오버로딩이 많아지는데, 이를 해결하기 위해 빌더 패턴을 적용
    // private 생성자를 사용하여 객체 생성을 제한하고, 객체 생성을 위한 빌더 메서드를 제공
    // 빌더 패턴을 사용하면 객체 생성 시점에 필요한 파라미터만 설정할 수 있고, 불변 객체로 만들 수 있음
    @Builder
    public Artwork(String title, String author, Price price, String serviceDate, boolean isAdult) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.serviceDate = serviceDate;
        this.isAdult = isAdult;
    }

    public void updatePrice(Double price) {

        this.price = Price.of(price);
    }
}
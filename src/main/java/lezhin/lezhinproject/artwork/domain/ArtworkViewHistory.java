package lezhin.lezhinproject.artwork.domain;

import jakarta.persistence.*;
import lezhin.lezhinproject.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@Builder
@Table(name = "artwork_view_histories")
public class ArtworkViewHistory {
    // id (INT, PK, AUTO_INCREMENT): 조회 이력의 고유 식별자
    // artwork_id (INT, FK to artworks.id): 조회된 작품의 ID
    // user_id (INT, FK to users.id): 조회한 사용자의 ID
    // view_date (DATETIME): 조회 일시

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artwork_id")
    private Artwork artwork;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDate viewDate;

    public ArtworkViewHistory(Long id, Artwork artwork, User user, LocalDate viewDate) {
        this.id = id;
        this.artwork = artwork;
        this.user = user;
        this.viewDate = viewDate;
    }
}

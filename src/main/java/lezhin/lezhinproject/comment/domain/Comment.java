package lezhin.lezhinproject.comment.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lezhin.lezhinproject.artwork.domain.Artwork;
import lezhin.lezhinproject.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@Table(name = "comments")
public class Comment {
// id (INT, PK, AUTO_INCREMENT): 평가의 고유 식별자
// artwork_id (INT, FK to artworks.id): 평가된 작품의 ID
// user_id (INT, FK to users.id): 평가한 사용자의 ID
// good (Long): 좋아요
// dislike (Long): 싫어요
// comment (TEXT, NULLABLE): 댓글 (특수문자 불가)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artwork_id")
    private Artwork artwork;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    private Long good;
    private Long dislike;
    @Pattern(regexp = "^[A-Za-z0-9\\s]+$", message = "특수문자는 사용할 수 없습니다.")
    private String comment;

    public Comment(Long id, Artwork artwork, User user, Long good, Long dislike, String comment) {
        this.id = id;
        this.artwork = artwork;
        this.user = user;
        this.good = good;
        this.dislike = dislike;
        this.comment = comment;
    }

}

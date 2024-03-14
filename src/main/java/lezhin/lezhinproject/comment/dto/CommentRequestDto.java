package lezhin.lezhinproject.comment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentRequestDto {
    private Long artworkId;
    private Long userId;
    private Long good;
    private Long dislike;
    private String comment;

    public CommentRequestDto(Long artworkId, Long userId, Long good, Long dislike, String comment) {
        this.artworkId = artworkId;
        this.userId = userId;
        this.good = good;
        this.dislike = dislike;
        this.comment = comment;
    }
}

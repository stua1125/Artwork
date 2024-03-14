package lezhin.lezhinproject.comment.dto;

import lezhin.lezhinproject.comment.domain.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentResponseDto {
    private Long id;
    private Long artworkId;
    private Long userId;
    private Long good;
    private Long dislike;
    private String comment;

    public CommentResponseDto(Long id, Long artworkId, Long userId, Long good, Long dislike, String comment) {
        this.id = id;
        this.artworkId = artworkId;
        this.userId = userId;
        this.good = good;
        this.dislike = dislike;
        this.comment = comment;
    }

    public static CommentResponseDto from(Comment comment) {
        return new CommentResponseDto(
                comment.getId(),
                comment.getArtwork() != null ? comment.getArtwork().getId() : null, // Artwork 엔티티의 ID
                comment.getUser() != null ? comment.getUser().getId() : null, // User 엔티티의 ID
                comment.getGood(),
                comment.getDislike(),
                comment.getComment()
        );
    }
}
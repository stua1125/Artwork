package lezhin.lezhinproject.comment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentSummaryDto {
    private Long artworkId;
    private String title;
    private String author;
    private long count;
    private String type; // "good" or "dislike"

    public CommentSummaryDto(Long artworkId, String title, String author, long count, String type) {
        this.artworkId = artworkId;
        this.title = title;
        this.author = author;
        this.count = count;
        this.type = type;
    }
}
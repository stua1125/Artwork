package lezhin.lezhinproject.comment.api;

import jakarta.validation.Valid;
import lezhin.lezhinproject.comment.application.CommentService;
import lezhin.lezhinproject.comment.domain.Comment;
import lezhin.lezhinproject.comment.dto.CommentRequestDto;
import lezhin.lezhinproject.comment.dto.CommentResponseDto;
import lezhin.lezhinproject.comment.dto.CommentSummaryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public CommentResponseDto createOrUpdateComment(@Valid @RequestBody CommentRequestDto requestDto) {
        Comment comment = commentService.createOrUpdateComment(requestDto);
        return CommentResponseDto.from(comment);
    }

    @GetMapping("/top-liked")
    public ResponseEntity<List<CommentSummaryDto>> getTopLikedArtworks() {
        return ResponseEntity.ok(commentService.findTopLikedArtworks());
    }

    @GetMapping("/top-disliked")
    public ResponseEntity<List<CommentSummaryDto>> getTopDislikedArtworks() {
        return ResponseEntity.ok(commentService.findTopDislikedArtworks());
    }
}

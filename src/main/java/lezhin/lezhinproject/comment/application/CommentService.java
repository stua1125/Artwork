package lezhin.lezhinproject.comment.application;

import jakarta.persistence.EntityNotFoundException;
import lezhin.lezhinproject.artwork.domain.Artwork;
import lezhin.lezhinproject.artwork.repository.ArtworkRepository;
import lezhin.lezhinproject.comment.domain.Comment;
import lezhin.lezhinproject.comment.dto.CommentRequestDto;
import lezhin.lezhinproject.comment.dto.CommentSummaryDto;
import lezhin.lezhinproject.comment.repository.CommentRepository;
import lezhin.lezhinproject.user.domain.User;
import lezhin.lezhinproject.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final ArtworkRepository artworkRepository;
    private final UserRepository userRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, ArtworkRepository artworkRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.artworkRepository = artworkRepository;
        this.userRepository = userRepository;
    }

    public Comment createOrUpdateComment(CommentRequestDto requestDto) {
        Artwork artwork = artworkRepository.findById(requestDto.getArtworkId())
                .orElseThrow(() -> new EntityNotFoundException("Artwork not found"));
        User user = userRepository.findById(requestDto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Optional<Comment> existingComment = commentRepository.findByUserIdAndArtworkId(user.getId(), artwork.getId());
        if (existingComment.isPresent()) {
            // 업데이트
            Comment comment = existingComment.get();
            comment.setGood(requestDto.getGood());
            comment.setDislike(requestDto.getDislike());
            comment.setComment(requestDto.getComment());
            return commentRepository.save(comment);
        } else {
            // 추가
            Comment comment = new Comment();
            comment.setArtwork(artwork);
            comment.setUser(user);
            comment.setGood(requestDto.getGood());
            comment.setDislike(requestDto.getDislike());
            comment.setComment(requestDto.getComment());
            return commentRepository.save(comment);
        }
    }

    public List<CommentSummaryDto> findTopLikedArtworks() {
        return commentRepository.findTopLikedArtworks(PageRequest.of(0, 3)).stream()
                .map(objects -> new CommentSummaryDto(
                        ((Artwork) objects[0]).getId(),
                        ((Artwork) objects[0]).getTitle(),
                        ((Artwork) objects[0]).getAuthor(),
                        (Long) objects[1],
                        "like"
                ))
                .collect(Collectors.toList());
    }

    public List<CommentSummaryDto> findTopDislikedArtworks() {
        return commentRepository.findTopDislikedArtworks(PageRequest.of(0, 3)).stream()
                .map(objects -> new CommentSummaryDto(
                        ((Artwork) objects[0]).getId(),
                        ((Artwork) objects[0]).getTitle(),
                        ((Artwork) objects[0]).getAuthor(),
                        (Long) objects[1],
                        "dislike"
                ))
                .collect(Collectors.toList());
    }
}

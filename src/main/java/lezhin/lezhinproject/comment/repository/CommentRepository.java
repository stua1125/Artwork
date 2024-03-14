package lezhin.lezhinproject.comment.repository;

import lezhin.lezhinproject.comment.domain.Comment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    Optional<Comment> findByUserIdAndArtworkId(Long userId, Long artworkId);

    @Query("SELECT c.artwork, SUM(case when c.good = 1 then 1 else 0 end) AS totalLikes " +
            "FROM Comment c " +
            "GROUP BY c.artwork " +
            "ORDER BY totalLikes DESC")
    List<Object[]> findTopLikedArtworks(Pageable pageable);

    @Query("SELECT c.artwork, SUM(case when c.dislike = 1 then 1 else 0 end) AS totalDislikes " +
            "FROM Comment c " +
            "GROUP BY c.artwork " +
            "ORDER BY totalDislikes DESC")
    List<Object[]> findTopDislikedArtworks(Pageable pageable);
}

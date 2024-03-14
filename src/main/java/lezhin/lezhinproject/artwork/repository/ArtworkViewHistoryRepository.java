package lezhin.lezhinproject.artwork.repository;

import lezhin.lezhinproject.artwork.domain.ArtworkViewHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ArtworkViewHistoryRepository extends JpaRepository<ArtworkViewHistory, Long> {
    List<ArtworkViewHistory> findByArtworkId(Long artworkId);

    @Query("SELECT vh.user.id as userId, COUNT(vh) as viewCount " +
            "FROM ArtworkViewHistory vh " +
            "WHERE vh.artwork.isAdult = true " +
            "AND vh.viewDate > :since " +
            "GROUP BY vh.user.id " +
            "ORDER BY viewCount DESC")
    List<Object[]> findFrequentAdultArtworkViewersSince(LocalDate since);
}
package lezhin.lezhinproject.artwork.repository;

import lezhin.lezhinproject.artwork.domain.Artwork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtworkRepository extends JpaRepository<Artwork, Long> {

}

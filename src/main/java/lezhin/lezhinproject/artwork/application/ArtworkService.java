package lezhin.lezhinproject.artwork.application;

import jakarta.persistence.EntityNotFoundException;
import lezhin.lezhinproject.artwork.domain.Artwork;
import lezhin.lezhinproject.artwork.repository.ArtworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtworkService {

    private final ArtworkRepository artworkRepository;

    @Autowired
    public ArtworkService(ArtworkRepository artworkRepository) {
        this.artworkRepository = artworkRepository;
    }

    public Artwork changeArtworkPrice(Long id, Double newPrice) {
        return artworkRepository.findById(id).map(artwork -> {
            if (newPrice == 0 || newPrice >= 100 && newPrice <= 500) {
                artwork.setPrice(newPrice);
                artworkRepository.save(artwork);
            } else {
                throw new IllegalArgumentException("Price must be between 100 and 500 or Price must be 0.");
            }
            return artwork;
        }).orElseThrow(() -> new EntityNotFoundException("Artwork not found with id " + id));
    }
}

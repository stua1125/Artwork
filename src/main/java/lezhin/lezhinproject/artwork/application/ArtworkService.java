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

    public Artwork changeArtworkPrice(Long id, Double newPrice) throws EntityNotFoundException, IllegalArgumentException {
       /* 기존 코드
       return artworkRepository.findById(id).map(artwork -> {
            if (newPrice == 0 || newPrice >= 100 && newPrice <= 500) {
                artwork.setPrice(newPrice);
                artworkRepository.save(artwork);
            } else {
                throw new IllegalArgumentException("Price must be between 100 and 500 or Price must be 0.");
            }
            return artwork;
        }).orElseThrow(() -> new EntityNotFoundException("Artwork not found with id " + id));
        */

        // refactored code
        // 도메인의 비즈니스 로직을 도메인 객체에 위임하고, 서비스 계층에서는 도메인 객체의 메서드를 호출하는 방식으로 변경
        Artwork artwork = artworkRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Artwork not found with id " + id));

        artwork.updatePrice(newPrice);

        return artworkRepository.save(artwork);
    }
}

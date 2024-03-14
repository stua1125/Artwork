package lezhin.lezhinproject.artwork.api;

import lezhin.lezhinproject.artwork.application.ArtworkService;
import lezhin.lezhinproject.artwork.domain.Artwork;
import lezhin.lezhinproject.artwork.dto.PriceUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/artworks")
public class ArtworkController {

    private final ArtworkService artworkService;

    @Autowired
    public ArtworkController(ArtworkService artworkService) {
        this.artworkService = artworkService;
    }

    @PostMapping("/{id}/change-price")
    public Artwork changeArtworkPrice(@PathVariable Long id, @RequestBody PriceUpdateRequest request) {
        return artworkService.changeArtworkPrice(id, request.getNewPrice());
    }
}

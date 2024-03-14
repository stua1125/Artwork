package lezhin.lezhinproject.artwork.api;

import lezhin.lezhinproject.artwork.application.ArtworkViewHistoryService;
import lezhin.lezhinproject.artwork.dto.ArtworkViewHistoryResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/artwork-view-histories")
public class ArtwortViewHistoryController {

    private final ArtworkViewHistoryService viewHistoryService;

    @Autowired
    public ArtwortViewHistoryController(ArtworkViewHistoryService viewHistoryService) {
        this.viewHistoryService = viewHistoryService;
    }

    @GetMapping("/{artworkId}")
    public List<ArtworkViewHistoryResponseDto> getViewHistoryByArtwork(@PathVariable Long artworkId) {
        return viewHistoryService.findViewHistoryByArtwork(artworkId);
    }

    @GetMapping("/frequent-adult-viewers")
    public List<ArtworkViewHistoryResponseDto> getFrequentAdultArtworkViewersInLastWeek() {
        return viewHistoryService.findFrequentAdultArtworkViewersInLastWeek();
    }
}

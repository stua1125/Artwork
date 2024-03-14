package lezhin.lezhinproject.artwork.application;

import lezhin.lezhinproject.artwork.dto.ArtworkViewHistoryResponseDto;
import lezhin.lezhinproject.artwork.repository.ArtworkViewHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtworkViewHistoryService {

    private final ArtworkViewHistoryRepository viewHistoryRepository;

    @Autowired
    public ArtworkViewHistoryService(ArtworkViewHistoryRepository viewHistoryRepository) {
        this.viewHistoryRepository = viewHistoryRepository;
    }

    public List<ArtworkViewHistoryResponseDto> findViewHistoryByArtwork(Long artworkId) {
        return viewHistoryRepository.findByArtworkId(artworkId)
                .stream()
                .map(history -> new ArtworkViewHistoryResponseDto(
                        history.getId(),
                        history.getArtwork().getId(),
                        history.getUser().getId(),
                        history.getViewDate()))
                .collect(Collectors.toList());
    }

    public List<ArtworkViewHistoryResponseDto> findFrequentAdultArtworkViewersInLastWeek() {
        LocalDate oneWeekAgo = LocalDate.now().minusWeeks(1);
        return viewHistoryRepository.findFrequentAdultArtworkViewersSince(oneWeekAgo).stream()
                .map(result -> new ArtworkViewHistoryResponseDto(
                        (Long) result[0], // userId
                        null,
                        (Long) result[1], // viewCount
                        null))
                .collect(Collectors.toList());
    }
}

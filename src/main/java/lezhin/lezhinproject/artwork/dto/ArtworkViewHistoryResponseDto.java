package lezhin.lezhinproject.artwork.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class ArtworkViewHistoryResponseDto {
    private Long id;
    private Long artworkId;
    private Long userId;
    private LocalDate viewDate;

    public ArtworkViewHistoryResponseDto(Long id, Long artworkId, Long userId, LocalDate viewDate) {
        this.id = id;
        this.artworkId = artworkId;
        this.userId = userId;
        this.viewDate = viewDate;
    }
}
package lezhin.lezhinproject.artwork.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ArtworkViewHistoryRequestDto {
    private Long artworkId;
    private Long userId;
}

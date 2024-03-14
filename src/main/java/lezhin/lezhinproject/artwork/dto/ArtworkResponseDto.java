package lezhin.lezhinproject.artwork.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ArtworkResponseDto {
    private Long id;
    private String title;
    private String author;
    private Double price;
    private String serviceDate;
    private boolean isAdult;
}

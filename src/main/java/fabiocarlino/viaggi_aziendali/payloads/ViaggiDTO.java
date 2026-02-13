package fabiocarlino.viaggi_aziendali.payloads;

import fabiocarlino.viaggi_aziendali.entities.StatoViaggio;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record ViaggiDTO(
        @NotBlank(message = "Il campo \"destinazione\" non può essere vuoto.")
        String destinazione,
        
        LocalDate data,
        StatoViaggio statoViaggio
) {
}

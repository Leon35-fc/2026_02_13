package fabiocarlino.viaggi_aziendali.payloads;

import fabiocarlino.viaggi_aziendali.entities.StatoViaggio;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ViaggiDTO(
        @NotBlank(message = "Il campo \"destinazione\" non può essere vuoto.")
        @Size(min = 3, max = 30, message = "Il nome della destinazione deve essere compreso tra 3-30 caratteri.")
        String destinazione,

        @NotBlank(message = "Il campo \"data\" non può essere vuoto.")
        @Size(min = 10, max = 10, message = "La data deve avere il formato YYYY-MM-DD.")
        LocalDate data,
        @NotBlank(message = "Il campo \"stato del viaggio\" deve essere IN_PROGRAMMA, IN_CORSO o COMPLETATO.")
        StatoViaggio statoViaggio
) {
}

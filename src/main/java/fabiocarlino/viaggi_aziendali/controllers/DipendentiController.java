package fabiocarlino.viaggi_aziendali.controllers;

import fabiocarlino.viaggi_aziendali.entities.Dipendente;
import fabiocarlino.viaggi_aziendali.payloads.DipendenteDTO;
import fabiocarlino.viaggi_aziendali.services.DipendentiService;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dipendenti")
public class DipendentiController {
    private final DipendentiService dipendentiService;

    @Autowired
    public DipendentiController(DipendentiService dipendentiService) {
        this.dipendentiService = dipendentiService;
    }

    //POST su http://localhost:3001/dipendenti + payload
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Dipendente creaDipendente(@RequestBody @Validated DipendenteDTO dipendenteDTO, BindingResult validationResult) {

        //CONTROLLO DEGLI ERRORI
        if (validationResult.hasErrors()) {
            List<String> errorsList = validationResult.getFieldErrors()
                    .stream()
                    .map(fieldError -> fieldError.getDefaultMessage())
                    .toList();

            throw new ValidationException((Throwable) errorsList);
        } else {
            return this.dipendentiService.save(dipendenteDTO);
        }

    }
}

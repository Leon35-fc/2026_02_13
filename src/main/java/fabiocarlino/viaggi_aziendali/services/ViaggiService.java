package fabiocarlino.viaggi_aziendali.services;

import fabiocarlino.viaggi_aziendali.entities.Viaggio;
import fabiocarlino.viaggi_aziendali.payloads.ViaggiDTO;
import fabiocarlino.viaggi_aziendali.repositories.ViaggiRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class ViaggiService {
    private final ViaggiRepo viaggiRepo;

    @Autowired

    public ViaggiService(ViaggiRepo viaggiRepo) {
        this.viaggiRepo = viaggiRepo;
    }

    public Viaggio save(ViaggiDTO viaggioDTO) {
        Viaggio viaggio = new Viaggio();
        viaggio.setDestinazione(viaggioDTO.destinazione());
        viaggio.setData(viaggioDTO.data());
        viaggio.setStatoViaggio(viaggioDTO.statoViaggio());

        Viaggio savedViaggio = viaggiRepo.save(viaggio);
        System.out.println("l viaggio con id: " + savedViaggio.getId() + " è stato salvato correttamente!");
        return savedViaggio;
    }
}

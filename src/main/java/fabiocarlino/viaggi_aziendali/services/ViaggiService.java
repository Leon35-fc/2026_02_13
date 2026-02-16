package fabiocarlino.viaggi_aziendali.services;

import fabiocarlino.viaggi_aziendali.entities.Viaggio;
import fabiocarlino.viaggi_aziendali.payloads.ViaggiDTO;
import fabiocarlino.viaggi_aziendali.repositories.DipendentiRepo;
import fabiocarlino.viaggi_aziendali.repositories.ViaggiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViaggiService {
    private final ViaggiRepo viaggiRepo;
    private final DipendentiRepo dipendentiRepo;

    @Autowired

    public ViaggiService(ViaggiRepo viaggiRepo, DipendentiRepo dipendentiRepo) {
        this.viaggiRepo = viaggiRepo;
        this.dipendentiRepo = dipendentiRepo;
    }

    public Viaggio save(ViaggiDTO viaggioDTO) {
        Viaggio viaggio = new Viaggio();
        viaggio.setDestinazione(viaggioDTO.destinazione());
        viaggio.setData(viaggioDTO.data());
        viaggio.setStatoViaggio(viaggioDTO.statoViaggio());

//        if (viaggiRepo.findByData(viaggio.getData()) && ){
//
//        }

        Viaggio savedViaggio = viaggiRepo.save(viaggio);
        System.out.println("Il viaggio con id: " + savedViaggio.getId() + " è stato salvato correttamente!");
        return savedViaggio;
    }
}

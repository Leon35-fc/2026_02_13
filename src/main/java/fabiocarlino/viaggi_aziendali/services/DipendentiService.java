package fabiocarlino.viaggi_aziendali.services;

import com.cloudinary.Cloudinary;
import fabiocarlino.viaggi_aziendali.entities.Dipendente;
import fabiocarlino.viaggi_aziendali.exceptions.BadRequestException;
import fabiocarlino.viaggi_aziendali.payloads.DipendenteDTO;
import fabiocarlino.viaggi_aziendali.repositories.DipendentiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DipendentiService {
    private final DipendentiRepo dipendentiRepo;
    private final Cloudinary cloudinaryUploader;

    @Autowired
    public DipendentiService(DipendentiRepo dipendentiRepo, Cloudinary cloudinaryUploader) {
        this.dipendentiRepo = dipendentiRepo;
        this.cloudinaryUploader = cloudinaryUploader;
    }

    public Dipendente save(DipendenteDTO dipendenteDTO) {

        //CONTROLLO SULL'E-MAIL
        this.dipendentiRepo.findByEmail(dipendenteDTO.email()).ifPresent(dipendente -> {
            throw new BadRequestException("L'e-mail " + dipendenteDTO.email() + "è già in uso");
        });

        //CREO UN NUOVO DIPENDENTE E GLI AGGIUNGO UN'IMMAGINE DI DEFAULT
        Dipendente newDipendente = new Dipendente(
                dipendenteDTO.nome(),
                dipendenteDTO.cognome(),
                dipendenteDTO.username(),
                dipendenteDTO.email());
        newDipendente.setAvatar("https://ui-avatars.com/api?name=" + dipendenteDTO.nome() + "+" + dipendenteDTO.cognome());

        //SALVO E RITORNO IL DIPENDENTE
        Dipendente dipendenteSalvato = this.dipendentiRepo.save(newDipendente);
        System.out.println("Il dipendente con id \"" + dipendenteSalvato.getId() + "\" è stato salvato.");
        return dipendenteSalvato;
    }

}

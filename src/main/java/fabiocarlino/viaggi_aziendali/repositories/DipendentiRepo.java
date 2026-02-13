package fabiocarlino.viaggi_aziendali.repositories;

import fabiocarlino.viaggi_aziendali.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DipendentiRepo extends JpaRepository<Dipendente, UUID> {

    Optional<Dipendente> findByEmail(String email);

    Optional<Dipendente> findById(UUID id);
}

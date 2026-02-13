package fabiocarlino.viaggi_aziendali.repositories;

import fabiocarlino.viaggi_aziendali.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ViaggiRepo extends JpaRepository<Viaggio, UUID> {
    Optional<Viaggio> findById(UUID id);
}

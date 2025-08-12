package cz.kuba.sas.sag.core.data.repositories;

import cz.kuba.sas.sag.core.data.models.entities.SasService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ServiceRepository extends JpaRepository<SasService, UUID> {

    SasService findByPrefix(String prefix);
}

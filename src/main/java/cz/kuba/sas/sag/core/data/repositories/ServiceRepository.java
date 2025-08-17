package cz.kuba.sas.sag.core.data.repositories;

import cz.kuba.sas.sag.core.data.models.entities.SasService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ServiceRepository extends JpaRepository<SasService, UUID> {

    @Query("SELECT s FROM SasService s")
    List<SasService> findAllPaged(Pageable pageable);

    SasService findByPrefix(String prefix);
}

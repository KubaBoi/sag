package cz.kuba.sas.sag.core.data.repositories;

import cz.kuba.sas.sag.core.data.models.entities.SasAccount;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<SasAccount, UUID> {

    @Query("SELECT a FROM SasAccount a")
    List<SasAccount> findAllPaged(Pageable pageable);

    SasAccount findByUserName(String username);
}

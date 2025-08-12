package cz.kuba.sas.sag.data.repositories;

import cz.kuba.sas.sag.data.models.entities.SasAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<SasAccount, UUID> {

    SasAccount findByUserName(String username);
}

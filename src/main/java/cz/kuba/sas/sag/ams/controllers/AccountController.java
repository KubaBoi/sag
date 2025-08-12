package cz.kuba.sas.sag.ams.controllers;

import cz.kuba.sas.sag.core.data.models.dtos.accounts.AccountDTO;
import cz.kuba.sas.sag.core.data.models.dtos.accounts.CreateAccountDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/accounts")
public class AccountController {

    @GetMapping
    @RequestMapping("/public")
    public ResponseEntity<List<AccountDTO>> getPublicAccounts() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @GetMapping
    @RequestMapping("/{accountId}/public")
    public ResponseEntity<AccountDTO> getPublicAccount(UUID accountId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @GetMapping
    public ResponseEntity<List<AccountDTO>> listAccounts() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ResponseEntity createAccount(@Validated @RequestBody CreateAccountDTO accountDTO) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

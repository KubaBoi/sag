package cz.kuba.sas.sag.ams.controllers;

import cz.kuba.sas.sag.core.data.models.dtos.accounts.AccountDTO;
import cz.kuba.sas.sag.core.data.models.dtos.accounts.CreateAccountDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/accounts")
public class AccountController {

    @GetMapping
    public ResponseEntity<List<AccountDTO>> getAccounts(
            @RequestParam(defaultValue = "0") @Min(0) Integer page,
            @RequestParam @Min(1) Integer pageSize
    ) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @GetMapping
    public ResponseEntity<AccountDTO> createAccount(
            @Valid @RequestBody CreateAccountDTO accountDTO
    ) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountDTO> getAccount(
            @PathVariable UUID accountId
    ) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @PatchMapping("/{accountId}")
    public ResponseEntity<AccountDTO> updateAccount(
            @PathVariable UUID accountId
    ) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<Void> deleteAccount(
            @PathVariable UUID accountId
    ) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

package cz.kuba.sas.sag.ams.controllers;

import cz.kuba.sas.sag.ams.services.AccountService;
import cz.kuba.sas.sag.core.Routes;
import cz.kuba.sas.sag.core.data.models.dtos.accounts.AccountDTO;
import cz.kuba.sas.sag.core.data.models.dtos.accounts.CreateAccountDTO;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(Routes.Accounts.ACCOUNTS)
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public ResponseEntity<List<AccountDTO>> getAccounts(
            @RequestParam(defaultValue = "0") @Min(0) Integer page,
            @RequestParam @Min(1) @Nullable Integer pageSize
    ) {
        log.info("getAccounts page={}, pageSize={}", page, pageSize);
        var accounts = accountService.getAccounts(page, pageSize);
        log.info("getAccounts found {} accounts", accounts.size());
        return ResponseEntity.ok(accounts);
    }

    @PostMapping
    public ResponseEntity<AccountDTO> createAccount(
            @Valid @RequestBody CreateAccountDTO accountDTO
    ) {
        log.info("createAccount");
        return new ResponseEntity<>(
                accountService.createAccount(accountDTO),
                HttpStatus.CREATED
        );
    }

    @GetMapping(Routes.Accounts.ACCOUNT_ID_PARAM)
    public ResponseEntity<AccountDTO> getAccount(
            @PathVariable(name = Routes.Accounts.ACCOUNT_ID) UUID accountId
    ) {
        log.info("getAccount accountId={}", accountId);
        return ResponseEntity.ok(accountService.findAccount(accountId));
    }

    @PatchMapping(Routes.Accounts.ACCOUNT_ID_PARAM)
    public ResponseEntity<AccountDTO> updateAccount(
            @PathVariable(name = Routes.Accounts.ACCOUNT_ID) UUID accountId
    ) {
        //TODO dodelat
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @DeleteMapping(Routes.Accounts.ACCOUNT_ID_PARAM)
    public ResponseEntity<Void> deleteAccount(
            @PathVariable(name = Routes.Accounts.ACCOUNT_ID) UUID accountId
    ) {
        accountService.deleteAccount(accountId);
        return ResponseEntity.noContent().build();
    }

}

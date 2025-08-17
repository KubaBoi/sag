package cz.kuba.sas.sag.ams.controllers;

import cz.kuba.sas.sag.ams.services.AccountService;
import cz.kuba.sas.sag.core.Routes;
import cz.kuba.sas.sag.core.data.models.dtos.accounts.PublicAccountDTO;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(Routes.Accounts.PUBLIC)
public class AccountPublicController {

    private final AccountService accountService;

    @GetMapping
    public ResponseEntity<List<PublicAccountDTO>> getPublicAccounts(
            @RequestParam(defaultValue = "0") @Min(0) Integer page,
            @RequestParam @Min(1) Integer pageSize
    ) {
        log.info("getPublicAccounts page={}, pageSize={}", page, pageSize);
        var accounts = accountService.findAccounts(page, pageSize);

        List<PublicAccountDTO> publicAccounts = new ArrayList<>(accounts.size());
        for (var account : accounts) {
            publicAccounts.add(new PublicAccountDTO(
                    account.id(),
                    account.userName()
            ));
        }
        log.info("getPublicAccounts found {} accounts", accounts.size());
        return ResponseEntity.ok(publicAccounts);
    }

    @GetMapping(Routes.Accounts.ACCOUNT_ID_PARAM)
    public ResponseEntity<PublicAccountDTO> getPublicAccount(
            @PathVariable(name = Routes.Accounts.ACCOUNT_ID) UUID accountId
    ) {
        log.info("getPublicAccount accountId={}", accountId);
        var account = accountService.findAccount(accountId);
        PublicAccountDTO publicAccount = new PublicAccountDTO(
                account.id(),
                account.userName()
        );

        return ResponseEntity.ok(publicAccount);
    }
}

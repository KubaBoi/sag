package cz.kuba.sas.sag.ams.controllers;

import cz.kuba.sas.sag.core.Constants;
import cz.kuba.sas.sag.core.data.models.dtos.accounts.PublicAccountDTO;
import jakarta.validation.constraints.Min;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(Constants.Paths.Accounts.PUBLIC)
public class AccountPublicController {

    @GetMapping
    public ResponseEntity<List<PublicAccountDTO>> getPublicAccounts(
            @RequestParam(defaultValue = "0") @Min(0) Integer page,
            @RequestParam @Min(1) Integer pageSize
    ) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @GetMapping(Constants.Paths.Accounts.ACCOUNT_ID_PARAM)
    public ResponseEntity<PublicAccountDTO> getPublicAccount(
            @PathVariable(name = Constants.Paths.Accounts.ACCOUNT_ID) UUID accountId
    ) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

package cz.kuba.sas.sag.ams.controllers;

import cz.kuba.sas.sag.core.data.models.dtos.accounts.PublicAccountDTO;
import jakarta.validation.constraints.Min;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/public/accounts")
public class AccountPublicController {

    @GetMapping
    public ResponseEntity<List<PublicAccountDTO>> getPublicAccounts(
            @RequestParam(defaultValue = "0") @Min(0) Integer page,
            @RequestParam @Min(1) Integer pageSize
    ) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<PublicAccountDTO> getPublicAccount(
            @PathVariable UUID accountId
    ) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

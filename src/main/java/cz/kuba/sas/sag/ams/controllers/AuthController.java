package cz.kuba.sas.sag.ams.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import cz.kuba.sas.sag.ams.services.AuthService;
import cz.kuba.sas.sag.core.Routes;
import cz.kuba.sas.sag.core.data.models.dtos.login.LoginRequestDTO;
import cz.kuba.sas.sag.core.data.models.dtos.login.LoginResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.AccountNotFoundException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Slf4j
@RestController
@RequestMapping(Routes.Auth.AUTH)
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(Routes.Auth.LOGIN)
    public ResponseEntity<LoginResponseDTO> login(
            @Valid @RequestBody LoginRequestDTO credentials
    ) {
        LoginResponseDTO account;
        try {
            account = authService.login(credentials);
        } catch (AccountNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (NoSuchAlgorithmException | InvalidKeyException | JsonProcessingException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.ok(account);
    }
}

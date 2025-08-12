package cz.kuba.sas.sag.ams.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import cz.kuba.sas.sag.core.data.models.dtos.login.LoginResponseDTO;
import cz.kuba.sas.sag.core.data.models.entities.SasAccount;
import cz.kuba.sas.sag.core.data.mappers.AccountMapper;
import cz.kuba.sas.sag.core.data.models.dtos.accounts.AccountDTO;
import cz.kuba.sas.sag.core.data.models.dtos.login.LoginRequestDTO;
import cz.kuba.sas.sag.core.data.repositories.AccountRepository;
import cz.kuba.sas.sag.core.utils.Jwt;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;

    /**
     * Authenticate account via password
     *
     * @param credentials Account's credentials
     * @return Authenticated account
     */
    public LoginResponseDTO login(LoginRequestDTO credentials) throws AccountNotFoundException, NoSuchAlgorithmException, InvalidKeyException, JsonProcessingException {
        SasAccount account = accountRepository.findByUserName(credentials.userName());
        if (account == null) {
            log.error("Account not found");
            throw new AccountNotFoundException("Account not found");
        }
        if (!passwordEncoder.matches(credentials.password(), account.getPasswordHash())) {
            log.error("Wrong password");
            throw new AccountNotFoundException("Wrong password");
        }

        AccountDTO accountDTO = AccountMapper.toDTO(account);
        Instant now = Instant.now();
        String jwt = new Jwt()
                .payload(new Jwt.Payload()
                        .issuer("SAG")
                        .subject(accountDTO.id().toString())
                        .expiration(now.plus(1, ChronoUnit.HOURS))
                        .issued(now))
                .build("123456789123456789123456798123456789"); // TODO tohle zmenit

        return new LoginResponseDTO(jwt, accountDTO);
    }
}

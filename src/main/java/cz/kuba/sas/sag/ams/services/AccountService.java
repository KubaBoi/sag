package cz.kuba.sas.sag.ams.services;

import cz.kuba.sas.sag.core.data.mappers.AccountMapper;
import cz.kuba.sas.sag.core.data.models.dtos.accounts.AccountDTO;
import cz.kuba.sas.sag.core.data.models.dtos.login.LoginRequestDTO;
import cz.kuba.sas.sag.core.data.models.entities.SasAccount;
import cz.kuba.sas.sag.core.data.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {

    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;

    /**
     * Creates account with authentication via password
     *
     * @param credentials User's credentials
     * @return New account
     */
    public AccountDTO createAccount(LoginRequestDTO credentials) {
        log.info("Creating account {}", credentials.userName());
        SasAccount account = new SasAccount();
        account.userName(credentials.userName());
        account.passwordHash(passwordEncoder.encode(credentials.password()));
        return AccountMapper.toDTO(accountRepository.save(account));
    }
}

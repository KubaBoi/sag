package cz.kuba.sas.sag.ams.services;

import cz.kuba.sas.sag.core.data.mappers.AccountMapper;
import cz.kuba.sas.sag.core.data.models.dtos.accounts.AccountDTO;
import cz.kuba.sas.sag.core.data.models.dtos.accounts.CreateAccountDTO;
import cz.kuba.sas.sag.core.data.models.dtos.accounts.UpdateAccountDTO;
import cz.kuba.sas.sag.core.data.models.entities.SasAccount;
import cz.kuba.sas.sag.core.data.repositories.AccountRepository;
import cz.kuba.sas.sag.core.exceptions.BadRequestException;
import cz.kuba.sas.sag.core.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {

    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;

    /**
     * Get all accounts by pages.
     *
     * @param page Selected page
     * @param pageSize If null, then no limit
     * @return Selected accounts
     */
    public List<AccountDTO> findAccounts(Integer page, Integer pageSize) {
        // TODO add sortBy
        List<SasAccount> accounts;
        if (pageSize == null) {
            accounts = accountRepository.findAll();
        } else {
            Pageable pageable = PageRequest.of(page, pageSize);
            accounts = accountRepository.findAllPaged(pageable);
        }

        return accounts.stream()
                .map(AccountMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Creates new account.
     *
     * @param accountDTO Accounts info and credentials
     * @return New account
     */
    public AccountDTO createAccount(CreateAccountDTO accountDTO)  {
        log.info("Creating account {}", accountDTO.userName());
        SasAccount account = new SasAccount();
        account.userName(account.userName());
        account.email(accountDTO.email());

        if (accountDTO.password().isEmpty() && accountDTO.publicKey().isBlank()) {
            log.error("Password nor public key provided");
            throw new BadRequestException("Password or public key provided");
        }

        if (!accountDTO.password().isEmpty()) {
            log.info("Creating account with password");
            account.passwordHash(passwordEncoder.encode(accountDTO.password()));
        }
        if (!accountDTO.publicKey().isEmpty()) {
            log.info("Creating account with public key");
            account.publicKey(Base64.getDecoder().decode(accountDTO.publicKey()));
        }

        return AccountMapper.toDTO(accountRepository.save(account));
    }

    /**
     * Get account's detail.
     *
     * @param accountId id
     * @return Account detail
     */
    public AccountDTO findAccount(UUID accountId) {
        log.info("Finding account {}", accountId);
        var account = findAccountOrThrow(accountId);
        return AccountMapper.toDTO(account);
    }

    /**
     * Update account's data.
     *
     * @param accountId id
     * @param accountDTO modified data
     * @return updated account
     */
    public AccountDTO updateAccount(UUID accountId, UpdateAccountDTO accountDTO) {
        log.info("Updating account {}", accountId);
        var account = findAccountOrThrow(accountId);

        account
                .userName(accountDTO.userName())
                .email(accountDTO.email());

        if (!accountDTO.password().isEmpty()) {
            log.info("Updating account with password");
            account.passwordHash(passwordEncoder.encode(accountDTO.password()));
        }
        if (!accountDTO.publicKey().isEmpty()) {
            log.info("Updating account with public key");
            account.publicKey(Base64.getDecoder().decode(accountDTO.publicKey()));
        }

        return AccountMapper.toDTO(accountRepository.save(account));
    }

    /**
     * Delete account
     *
     * @param accountId id
     */
    public void deleteAccount(UUID accountId) {
        log.info("Deleting account {}", accountId);
        findAccountOrThrow(accountId);
        accountRepository.deleteById(accountId);
    }

    private SasAccount findAccountOrThrow(UUID accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> {
                    log.error("Account with id {} not found", accountId);
                    return new NotFoundException("Account with id not found");
                });
    }
}

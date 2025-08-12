package cz.kuba.sas.sag.core.data.mappers;

import cz.kuba.sas.sag.core.data.models.dtos.accounts.AccountDTO;
import cz.kuba.sas.sag.core.data.models.entities.SasAccount;

public class AccountMapper {

    public static SasAccount toEntity(AccountDTO account) {
        return new SasAccount()
                .id(account.id())
                .userName(account.userName());
    }

    public static AccountDTO toDTO(SasAccount account) {
        return new AccountDTO()
                .id(account.id())
                .userName(account.userName());
    }
}

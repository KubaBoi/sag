package cz.kuba.sas.sag.core.data.mappers;

import cz.kuba.sas.sag.core.data.models.entities.SasAccount;
import cz.kuba.sas.sag.core.data.models.dtos.accounts.AccountDTO;

public class AccountMapper {

    public static SasAccount toEntity(AccountDTO account) {
        return new SasAccount()
                .setId(account.id())
                .setUserName(account.userName());
    }

    public static AccountDTO toDTO(SasAccount account) {
        return new AccountDTO()
                .id(account.getId())
                .userName(account.getUserName());
    }
}

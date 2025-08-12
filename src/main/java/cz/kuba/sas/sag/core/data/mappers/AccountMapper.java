package cz.kuba.sas.sag.core.data.mappers;

import cz.kuba.sas.sag.core.data.models.entities.SasAccount;
import cz.kuba.sas.sag.core.data.models.dtos.AccountDTO;

public class AccountMapper {

    public static SasAccount toEntity(AccountDTO account) {
        return new SasAccount()
                .setId(account.getId())
                .setUserName(account.getUserName());
    }

    public static AccountDTO toDTO(SasAccount account) {
        return new AccountDTO()
                .setId(account.getId())
                .setUserName(account.getUserName());
    }
}

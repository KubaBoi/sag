package cz.kuba.sas.sag.core.data.mappers;

import cz.kuba.sas.sag.core.data.enums.Role;
import cz.kuba.sas.sag.core.data.models.dtos.accounts.AccountDTO;
import cz.kuba.sas.sag.core.data.models.entities.SasAccount;
import cz.kuba.sas.sag.core.data.models.entities.enums.RoleType;

public class AccountMapper {

    public static SasAccount toEntity(AccountDTO account) {
        return new SasAccount()
                .id(account.id())
                .userName(account.userName())
                .email(account.email())
                .role(toRoleType(account.role()));
    }

    public static AccountDTO toDTO(SasAccount account) {
        return new AccountDTO()
                .id(account.id())
                .userName(account.userName())
                .email(account.email())
                .role(toRole(account.role()));
    }

    public static RoleType toRoleType(Role role) {
        return switch (role) {
            case Admin -> RoleType.Admin;
            case Role.User -> RoleType.User;
        };
    }

    public static Role toRole(RoleType roleType) {
        return switch (roleType) {
            case Admin -> Role.Admin;
            case User -> Role.User;
        };
    }
}

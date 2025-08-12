package cz.kuba.sas.sag.core.data.models.dtos.accounts;

import com.fasterxml.jackson.annotation.JsonProperty;
import cz.kuba.sas.sag.core.data.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;

@Setter
@Getter
@Accessors(chain = true, fluent = true)
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

    @JsonProperty
    private UUID id;
    @JsonProperty
    private String userName;
    @JsonProperty
    private String password;
    @JsonProperty
    private Role role;
}

package cz.kuba.sas.sag.core.data.models.dtos.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import cz.kuba.sas.sag.core.data.models.dtos.accounts.AccountDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true, fluent = true)
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDTO {

    @JsonProperty
    private String token;
    @JsonProperty
    private AccountDTO account;
}

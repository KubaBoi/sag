package cz.kuba.sas.sag.core.data.models.dtos.accounts;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class CreateAccountDTO {

    @NotBlank
    @JsonProperty
    private String userName;

    @NotBlank
    @JsonProperty
    private String email;

    @JsonProperty
    private String password;

    @JsonProperty
    private String publicKey;
}

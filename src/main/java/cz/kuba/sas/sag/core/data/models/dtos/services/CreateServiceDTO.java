package cz.kuba.sas.sag.core.data.models.dtos.services;

import com.fasterxml.jackson.annotation.JsonProperty;
import cz.kuba.sas.sag.core.data.enums.DriverType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.net.URL;

@Setter
@Getter
@Accessors(chain = true, fluent = true)
@AllArgsConstructor
@NoArgsConstructor
public class CreateServiceDTO {

    @NotBlank
    @JsonProperty
    private String prefix;

    @NotBlank
    @JsonProperty
    private String name;

    @NotBlank
    @JsonProperty
    private DriverType driverType;

    @NotBlank
    @JsonProperty
    private String version;

    @JsonProperty
    private String description;

    @JsonProperty
    private URL icon;

    @JsonProperty
    private URL source;
}

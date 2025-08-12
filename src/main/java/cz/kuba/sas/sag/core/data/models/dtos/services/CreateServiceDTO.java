package cz.kuba.sas.sag.core.data.models.dtos.services;

import com.fasterxml.jackson.annotation.JsonProperty;
import cz.kuba.sas.sag.core.data.enums.DriverType;
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

    @NotNull
    @JsonProperty
    private String prefix;

    @NotNull
    @JsonProperty
    private String name;

    @NotNull
    @JsonProperty
    private DriverType driverType;

    @NotNull
    @JsonProperty
    private String version;

    @JsonProperty
    private String description;

    @JsonProperty
    private URL icon;

    @JsonProperty
    private URL source;
}

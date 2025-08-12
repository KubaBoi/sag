package cz.kuba.sas.sag.core.data.models.dtos.services;

import com.fasterxml.jackson.annotation.JsonProperty;
import cz.kuba.sas.sag.core.data.enums.DriverType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.net.URL;
import java.util.UUID;

@Setter
@Getter
@Accessors(chain = true, fluent = true)
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDTO {

    @JsonProperty
    private UUID id;
    @JsonProperty
    private String prefix;
    @JsonProperty
    private String name;
    @JsonProperty
    private String description;
    @JsonProperty
    private URL icon;
    @JsonProperty
    private Integer port;
    @JsonProperty
    private DriverType driverType;
    @JsonProperty
    private String version;
    @JsonProperty
    private URL source;
}

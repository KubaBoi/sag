package cz.kuba.sas.sag.core.data.models.dtos.services;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class PublicServiceDTO {

    @JsonProperty
    private String prefix;
    @JsonProperty
    private String name;
    @JsonProperty
    private String version;
    @JsonProperty
    private String description;
    @JsonProperty
    private URL icon;
}

package cz.kuba.sas.sag.core.data.mappers;

import cz.kuba.sas.sag.core.data.models.entities.SasService;
import cz.kuba.sas.sag.core.data.models.dtos.services.ServiceDTO;

public class ServiceMapper {

    static SasService toEntity(ServiceDTO service) {
        return new SasService()
                .setId(service.id())
                .setPrefix(service.prefix())
                .setName(service.name())
                .setDescription(service.description())
                .setPort(service.port())
                .setDriverType(service.driverType());
    }

    static ServiceDTO toDto(SasService service) {
        return new ServiceDTO()
                .id(service.getId())
                .prefix(service.getPrefix())
                .name(service.getName())
                .description(service.getDescription())
                .port(service.getPort())
                .driverType(service.getDriverType());
    }
}

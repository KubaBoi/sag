package cz.kuba.sas.sag.core.data.mappers;

import cz.kuba.sas.sag.core.data.models.entities.SasService;
import cz.kuba.sas.sag.core.data.models.dtos.services.ServiceDTO;

public class ServiceMapper {

    static SasService toEntity(ServiceDTO service) {
        return new SasService()
                .id(service.id())
                .prefix(service.prefix())
                .name(service.name())
                .description(service.description())
                .port(service.port())
                .driverType(service.driverType());
    }

    static ServiceDTO toDto(SasService service) {
        return new ServiceDTO()
                .id(service.id())
                .prefix(service.prefix())
                .name(service.name())
                .description(service.description())
                .port(service.port())
                .driverType(service.driverType());
    }
}

package cz.kuba.sas.sag.data.mappers;

import cz.kuba.sas.sag.data.models.entities.SasService;
import cz.kuba.sas.sag.data.models.dtos.ServiceDTO;

public class ServiceMapper {

    static SasService toEntity(ServiceDTO service) {
        return new SasService()
                .setId(service.getId())
                .setPrefix(service.getPrefix())
                .setName(service.getName())
                .setDescription(service.getDescription())
                .setPort(service.getPort())
                .setDriverType(service.getDriverType());
    }

    static ServiceDTO toDto(SasService service) {
        return new ServiceDTO()
                .setId(service.getId())
                .setPrefix(service.getPrefix())
                .setName(service.getName())
                .setDescription(service.getDescription())
                .setPort(service.getPort())
                .setDriverType(service.getDriverType());
    }
}

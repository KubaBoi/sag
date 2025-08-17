package cz.kuba.sas.sag.msm.services;

import cz.kuba.sas.sag.core.data.mappers.ServiceMapper;
import cz.kuba.sas.sag.core.data.models.dtos.services.ServiceDTO;
import cz.kuba.sas.sag.core.data.models.entities.SasService;
import cz.kuba.sas.sag.core.data.repositories.ServiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ServiceService {

    private final ServiceRepository serviceRepository;

    /**
     * Get all services by pages.
     *
     * @param page     Selected page
     * @param pageSize If null, then no limit
     * @return Selected services
     */
    public List<ServiceDTO> findServices(Integer page, Integer pageSize) {
        //TODO add sort by
        List<SasService> services;
        if (pageSize == null) {
            services = serviceRepository.findAll();
        } else {
            Pageable pageable = PageRequest.of(page, pageSize);
            services = serviceRepository.findAllPaged(pageable);
        }

        return services.stream()
                .map(ServiceMapper::toDTO)
                .collect(Collectors.toList());
    }
}

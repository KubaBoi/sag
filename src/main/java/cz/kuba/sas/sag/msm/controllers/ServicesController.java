package cz.kuba.sas.sag.msm.controllers;

import cz.kuba.sas.sag.core.Routes;
import cz.kuba.sas.sag.core.data.models.dtos.services.ServiceDTO;
import cz.kuba.sas.sag.msm.services.ServiceService;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(Routes.Services.SYSTEM)
public class ServicesController {

    private final ServiceService serviceService;

    @GetMapping
    public ResponseEntity<List<ServiceDTO>> getServices(
            @RequestParam(defaultValue = "0") @Min(0) Integer page,
            @RequestParam @Min(1) @Nullable Integer pageSize
    ) {
        log.info("getServices page={}, pageSize={}", page, pageSize);
        var services = serviceService.findServices(page, pageSize);
        log.info("getServices found {} services", services.size());
        return ResponseEntity.ok(services);
    }

    @PostMapping
    public ResponseEntity<ServiceDTO> createService() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @GetMapping(Routes.Services.SERVICE_ID_PARAM)
    public ResponseEntity<ServiceDTO> getService(
            @PathVariable(name = Routes.Services.SERVICE_ID) UUID serviceId
    ) {
        log.info("getService serviceId={}", serviceId);
        return ResponseEntity.ok(serviceService.findService(serviceId));
    }

    @PatchMapping(Routes.Services.SERVICE_ID_PARAM)
    public ResponseEntity<ServiceDTO> updateService(
            @PathVariable(name = Routes.Services.SERVICE_ID) UUID serviceId
    ) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @DeleteMapping(Routes.Services.SERVICE_ID_PARAM)
    public ResponseEntity<Void> deleteService(
            @PathVariable(name = Routes.Services.SERVICE_ID) UUID serviceId
    ) {
        log.info("deleteService serviceId={}", serviceId);
        serviceService.deleteService(serviceId);
        return ResponseEntity.noContent().build();
    }
}

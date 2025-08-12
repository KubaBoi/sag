package cz.kuba.sas.sag.msm.controllers;

import cz.kuba.sas.sag.core.data.models.dtos.services.ServiceDTO;
import jakarta.validation.constraints.Min;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/system/services")
public class ServicesController {

    @GetMapping
    public ResponseEntity<ServiceDTO> getServices(
            @RequestParam(defaultValue = "0") @Min(0) Integer page,
            @RequestParam @Min(1) Integer pageSize
    ) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @PostMapping
    public ResponseEntity<ServiceDTO> createService() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @GetMapping("/{serviceId}")
    public ResponseEntity<ServiceDTO> getService(
            @PathVariable UUID serviceId
    ) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @PatchMapping("/{serviceId}")
    public ResponseEntity<ServiceDTO> updateService(
            @PathVariable UUID serviceId
    ) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @DeleteMapping("/{serviceId}")
    public ResponseEntity<Void> deleteService(
            @PathVariable UUID serviceId
    ) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

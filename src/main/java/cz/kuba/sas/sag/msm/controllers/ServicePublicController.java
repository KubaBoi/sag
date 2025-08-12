package cz.kuba.sas.sag.msm.controllers;

import cz.kuba.sas.sag.core.data.models.dtos.services.PublicServiceDTO;
import jakarta.validation.constraints.Min;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/public/services")
public class ServicePublicController {

    @GetMapping
    public ResponseEntity<List<PublicServiceDTO>> getPublicServices(
            @RequestParam(defaultValue = "0") @Min(0) Integer page,
            @RequestParam @Min(1) Integer pageSize
    ) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @GetMapping("/{serviceId}")
    public ResponseEntity<PublicServiceDTO> getPublicService(
            @PathVariable UUID serviceId
    ) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

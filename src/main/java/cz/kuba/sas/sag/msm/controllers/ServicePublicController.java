package cz.kuba.sas.sag.msm.controllers;

import cz.kuba.sas.sag.core.Routes;
import cz.kuba.sas.sag.core.data.models.dtos.services.PublicServiceDTO;
import jakarta.validation.constraints.Min;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(Routes.Services.PUBLIC)
public class ServicePublicController {

    @GetMapping
    public ResponseEntity<List<PublicServiceDTO>> getPublicServices(
            @RequestParam(defaultValue = "0") @Min(0) Integer page,
            @RequestParam @Min(1) Integer pageSize
    ) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @GetMapping(Routes.Services.SERVICE_ID_PARAM)
    public ResponseEntity<PublicServiceDTO> getPublicService(
            @PathVariable(name = Routes.Services.SERVICE_ID) UUID serviceId
    ) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

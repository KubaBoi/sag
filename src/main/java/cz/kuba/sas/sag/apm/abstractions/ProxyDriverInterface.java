package cz.kuba.sas.sag.apm.abstractions;

import cz.kuba.sas.sag.core.data.enums.DriverType;
import cz.kuba.sas.sag.core.data.models.entities.SasService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

/**
 * Interface defying how proxies should work for different {@link DriverType}.
 */
public interface ProxyDriverInterface {

    /**
     * Type of requests which implementation handles.
     */
    DriverType getServiceType();

    /**
     * Send incoming request to the service and returns its response.
     *
     * @param service
     * @param request
     */
    ResponseEntity<byte[]> forward(SasService service, HttpServletRequest request) throws IOException;
}

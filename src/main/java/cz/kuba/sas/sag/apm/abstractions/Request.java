package cz.kuba.sas.sag.apm.abstractions;

import cz.kuba.sas.sag.core.data.models.entities.SasService;
import jakarta.servlet.http.HttpServletRequest;

/**
 * Object representing incoming request.
 *
 * @param service Called service
 * @param request Request data
 */
public record Request(SasService service,
                      HttpServletRequest request) {
}

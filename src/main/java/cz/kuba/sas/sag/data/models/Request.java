package cz.kuba.sas.sag.data.models;

import cz.kuba.sas.sag.data.models.entities.SasService;
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

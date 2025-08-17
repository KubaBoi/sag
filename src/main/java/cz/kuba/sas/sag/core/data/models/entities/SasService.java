package cz.kuba.sas.sag.core.data.models.entities;

import cz.kuba.sas.sag.core.data.enums.DriverType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;

/**
 * Object representing SAS service to reroute requests.
 */
@Entity
@Table(name = "services")
@Getter
@Setter
@Accessors(chain = true, fluent = true)
@AllArgsConstructor
@NoArgsConstructor
public class SasService {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * Unique id od service in the start of url
     */
    @Column(nullable = false, unique = true)
    private String prefix;

    /**
     * Display name
     */
    @Column(nullable = false)
    private String name;

    /**
     * Version of deployed service
     */
    @Column(nullable = false)
    private String version;

    /**
     * Type of service's interface
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DriverType driverType;

    /**
     * Internal port
     */
    @Column(nullable = false, unique = true)
    private Integer port;

    /**
     * Short description
     */
    @Column
    private String description;

    /**
     * Url of source code
     */
    @Column
    private String source;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountId")
    private SasAccount account;


}

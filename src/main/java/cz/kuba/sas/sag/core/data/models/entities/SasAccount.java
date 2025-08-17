package cz.kuba.sas.sag.core.data.models.entities;

import cz.kuba.sas.sag.core.data.models.entities.enums.RoleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@Accessors(chain = true, fluent = true)
@AllArgsConstructor
@NoArgsConstructor
public class SasAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String userName;

    @Column(unique = true, nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private RoleType role;

    @Column
    private String passwordHash;

    @Column
    private byte[] publicKey;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    private Set<SasService> services = new HashSet<>();
}

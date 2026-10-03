package com.karur.mcp_organisation_management_server.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "organisation")
public class OrganisationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organisation_seq")
    @SequenceGenerator(name = "organisation_seq", sequenceName = "organisation_seq_id", initialValue = 1, allocationSize = 1)
    private Long id;

    private String number;
    private String name;
    private String description;
    private String idNameAndValue;
    private String orgRegNumber;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressEntity addressEntity;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "parent_organisation_id")
    private List<OrganisationEntity> childOrganisations;
}
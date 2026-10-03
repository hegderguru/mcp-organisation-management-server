package com.karur.mcp_organisation_management_server.entity;

import jakarta.persistence.*;
import lombok.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq_id", initialValue = 1, allocationSize = 1)
    private Long id;
    private String username;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phone;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private AddressEntity addressEntity;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organisation_id")
    private OrganisationEntity organisationEntity;

}
package com.karur.mcp_organisation_management_server.mode.request;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private Long id;
    private String username;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phone;

    private AddressRequest addressRequest;
    private OrganisationRequest organisationRequest;

}
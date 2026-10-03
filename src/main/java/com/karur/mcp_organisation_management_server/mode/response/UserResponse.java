package com.karur.mcp_organisation_management_server.mode.response;

import com.karur.mcp_organisation_management_server.mode.request.AddressRequest;
import com.karur.mcp_organisation_management_server.mode.request.OrganisationRequest;
import lombok.*;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private Long id;
    private String username;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phone;

    private AddressResponse addressResponse;
    private OrganisationResponse organisationResponse;

}
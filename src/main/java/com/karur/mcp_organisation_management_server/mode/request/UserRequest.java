package com.karur.mcp_organisation_management_server.mode.request;

import com.karur.mcp_organisation_management_server.mode.response.AddressRequest;
import com.karur.mcp_organisation_management_server.mode.response.OrganisationRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
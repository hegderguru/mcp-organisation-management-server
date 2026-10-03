package com.karur.mcp_organisation_management_server.mode.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrganisationResponse {

    private Long id;

    private String number;
    private String name;
    private String description;
    private String idNameAndValue;
    private String orgRegNumber;
    private AddressResponse addressRequest;
    private List<OrganisationResponse> organisationRequests;
}
package com.karur.mcp_organisation_management_server.mode.response;

import lombok.*;

import java.util.List;


@Builder
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
    private AddressResponse addressResponse;
    private List<OrganisationResponse> organisationResponses;
}
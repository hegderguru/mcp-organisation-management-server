package com.karur.mcp_organisation_management_server.mode.request;

import lombok.*;

import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrganisationRequest {

    private Long id;
    @DiffId
    private String number;
    private String name;
    private String description;
    private String idNameAndValue;
    private String orgRegNumber;
    private AddressRequest addressRequest;
    private List<OrganisationRequest> organisationRequests;
}
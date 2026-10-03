package com.karur.mcp_organisation_management_server.mode.request;

import com.karur.mcp_organisation_management_server.entity.AddressEntity;
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
public class OrganisationRequest {

    private Long id;

    private String number;
    private String name;
    private String description;
    private String idNameAndValue;
    private String orgRegNumber;
    private AddressRequest addressRequest;
    private List<OrganisationRequest> organisationRequests;
}
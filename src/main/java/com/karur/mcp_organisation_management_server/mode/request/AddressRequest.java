package com.karur.mcp_organisation_management_server.mode.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {

    private Long id;
    @DiffId
    private String number;
    private String name;
    private String floor;
    private String street;
    private String place;
    private String city;
    private String state;
    private String country;
    private String pinCode;
}

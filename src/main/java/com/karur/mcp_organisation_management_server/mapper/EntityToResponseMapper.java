package com.karur.mcp_organisation_management_server.mapper;

import com.karur.mcp_organisation_management_server.entity.AddressEntity;
import com.karur.mcp_organisation_management_server.entity.OrganisationEntity;
import com.karur.mcp_organisation_management_server.entity.UserEntity;
import com.karur.mcp_organisation_management_server.mode.response.AddressResponse;
import com.karur.mcp_organisation_management_server.mode.response.OrganisationResponse;
import com.karur.mcp_organisation_management_server.mode.response.UserResponse;

public class EntityToResponseMapper {

    public static OrganisationResponse buildOrganisationResponse(OrganisationEntity organisationEntity) {
        return OrganisationResponse.builder()
                .id(organisationEntity.getId())
                .number(organisationEntity.getNumber())
                .name(organisationEntity.getName())
                .orgRegNumber(organisationEntity.getOrgRegNumber())
                .idNameAndValue(organisationEntity.getIdNameAndValue())
                .addressResponse(buildAddressResponse(organisationEntity.getAddressEntity()))
                .organisationResponses(organisationEntity.getChildOrganisations().stream().map(EntityToResponseMapper::buildOrganisationResponse).toList())
                .build();
    }

    public static AddressResponse buildAddressResponse(AddressEntity addressEntity) {
        return AddressResponse.builder()
                .id(addressEntity.getId())
                .number(addressEntity.getNumber())
                .name(addressEntity.getName())
                .floor(addressEntity.getFloor())
                .street(addressEntity.getStreet())
                .place(addressEntity.getPlace())
                .state(addressEntity.getState())
                .country(addressEntity.getCountry())
                .pinCode(addressEntity.getPinCode())
                .build();
    }

    public static UserResponse buildUserResponse(UserEntity userEntity) {
        return UserResponse.builder()
                .id(userEntity.getId())
                .username(userEntity.getUsername())
                .firstName(userEntity.getFirstName())
                .middleName(userEntity.getMiddleName())
                .lastName(userEntity.getLastName())
                .email(userEntity.getEmail())
                .phone(userEntity.getPhone())
                .addressResponse(buildAddressResponse(userEntity.getAddressEntity()))
                .organisationResponse(buildOrganisationResponse(userEntity.getOrganisationEntity()))
                .build();
    }

}

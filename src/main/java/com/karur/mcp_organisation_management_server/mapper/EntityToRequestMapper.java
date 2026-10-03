package com.karur.mcp_organisation_management_server.mapper;

import com.karur.mcp_organisation_management_server.entity.AddressEntity;
import com.karur.mcp_organisation_management_server.entity.OrganisationEntity;
import com.karur.mcp_organisation_management_server.entity.UserEntity;
import com.karur.mcp_organisation_management_server.mode.request.AddressRequest;
import com.karur.mcp_organisation_management_server.mode.request.OrganisationRequest;
import com.karur.mcp_organisation_management_server.mode.request.UserRequest;

public class EntityToRequestMapper {

    public static OrganisationRequest buildOrganisationRequest(OrganisationEntity organisationEntity) {
        return OrganisationRequest.builder()
                .id(organisationEntity.getId())
                .number(organisationEntity.getNumber())
                .name(organisationEntity.getName())
                .orgRegNumber(organisationEntity.getOrgRegNumber())
                .idNameAndValue(organisationEntity.getIdNameAndValue())
                .addressRequest(buildAddressRequest(organisationEntity.getAddressEntity()))
                .organisationRequests(organisationEntity.getChildOrganisationEntities().stream().map(EntityToRequestMapper::buildOrganisationRequest).toList())
                .build();
    }

    public static AddressRequest buildAddressRequest(AddressEntity addressEntity) {
        return AddressRequest.builder()
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

    public static UserRequest buildUserRequest(UserEntity userEntity) {
        return UserRequest.builder()
                .id(userEntity.getId())
                .username(userEntity.getUsername())
                .firstName(userEntity.getFirstName())
                .middleName(userEntity.getMiddleName())
                .lastName(userEntity.getLastName())
                .email(userEntity.getEmail())
                .phone(userEntity.getPhone())
                .addressRequest(buildAddressRequest(userEntity.getAddressEntity()))
                .organisationRequest(buildOrganisationRequest(userEntity.getOrganisationEntity()))
                .build();

    }
}
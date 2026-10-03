package com.karur.mcp_organisation_management_server.mapper;

import com.karur.mcp_organisation_management_server.entity.AddressEntity;
import com.karur.mcp_organisation_management_server.entity.OrganisationEntity;
import com.karur.mcp_organisation_management_server.entity.UserEntity;
import com.karur.mcp_organisation_management_server.mode.request.AddressRequest;
import com.karur.mcp_organisation_management_server.mode.request.OrganisationRequest;
import com.karur.mcp_organisation_management_server.mode.request.UserRequest;

public class RequestToEntityMapper {

    public static OrganisationEntity buildOrganisationRequest(OrganisationRequest organisationRequest) {
        return OrganisationEntity.builder()
                .id(organisationRequest.getId())
                .number(organisationRequest.getNumber())
                .name(organisationRequest.getName())
                .orgRegNumber(organisationRequest.getOrgRegNumber())
                .idNameAndValue(organisationRequest.getIdNameAndValue())
                .build();
    }

    public static AddressEntity buildAddressEntity(AddressRequest addressRequest) {
        return AddressEntity.builder()
                .id(addressRequest.getId())
                .number(addressRequest.getNumber())
                .name(addressRequest.getName())
                .floor(addressRequest.getFloor())
                .street(addressRequest.getStreet())
                .place(addressRequest.getPlace())
                .state(addressRequest.getState())
                .country(addressRequest.getCountry())
                .pinCode(addressRequest.getPinCode())
                .build();
    }

    public static UserEntity buildUserRequest(UserRequest userRequest) {
        return UserEntity.builder()
                .id(userRequest.getId())
                .username(userRequest.getUsername())
                .firstName(userRequest.getFirstName())
                .middleName(userRequest.getMiddleName())
                .lastName(userRequest.getLastName())
                .email(userRequest.getEmail())
                .phone(userRequest.getPhone())
                .build();

    }

    public static OrganisationEntity buildCompleteOrganisationRequest(OrganisationRequest organisationRequest) {
        return OrganisationEntity.builder()
                .id(organisationRequest.getId())
                .number(organisationRequest.getNumber())
                .name(organisationRequest.getName())
                .orgRegNumber(organisationRequest.getOrgRegNumber())
                .idNameAndValue(organisationRequest.getIdNameAndValue())
                .addressEntity(buildCompleteAddressEntity(organisationRequest.getAddressRequest()))
                .childOrganisationEntities(organisationRequest.getOrganisationRequests().stream().map(RequestToEntityMapper::buildCompleteOrganisationRequest).toList())
                .build();
    }

    public static AddressEntity buildCompleteAddressEntity(AddressRequest addressRequest) {
        return AddressEntity.builder()
                .id(addressRequest.getId())
                .number(addressRequest.getNumber())
                .name(addressRequest.getName())
                .floor(addressRequest.getFloor())
                .street(addressRequest.getStreet())
                .place(addressRequest.getPlace())
                .state(addressRequest.getState())
                .country(addressRequest.getCountry())
                .pinCode(addressRequest.getPinCode())
                .build();
    }

    public static UserEntity buildCompleteUserRequest(UserRequest userRequest) {
        return UserEntity.builder()
                .id(userRequest.getId())
                .username(userRequest.getUsername())
                .firstName(userRequest.getFirstName())
                .middleName(userRequest.getMiddleName())
                .lastName(userRequest.getLastName())
                .email(userRequest.getEmail())
                .phone(userRequest.getPhone())
                .addressEntity(buildCompleteAddressEntity(userRequest.getAddressRequest()))
                .organisationEntity(buildCompleteOrganisationRequest(userRequest.getOrganisationRequest()))
                .build();

    }
}

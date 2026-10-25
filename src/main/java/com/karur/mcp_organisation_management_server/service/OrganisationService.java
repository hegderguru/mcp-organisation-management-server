package com.karur.mcp_organisation_management_server.service;

import com.karur.mcp_organisation_management_server.entity.OrganisationEntity;
import com.karur.mcp_organisation_management_server.mapper.EntityToResponseMapper;
import com.karur.mcp_organisation_management_server.mapper.RequestToEntityMapper;
import com.karur.mcp_organisation_management_server.mode.request.OrganisationRequest;
import com.karur.mcp_organisation_management_server.mode.response.OrganisationResponse;
import com.karur.mcp_organisation_management_server.repository.OrganisationRepository;
import org.hibernate.annotations.Audited;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class OrganisationService {

    @Audited
    OrganisationRepository organisationRepository;

    public Mono<OrganisationResponse> createOrganisation(OrganisationRequest organisationRequest) {
        OrganisationEntity organisationEntity = RequestToEntityMapper.buildCompleteOrganisationRequest(organisationRequest);
        OrganisationEntity organisation = organisationRepository.save(organisationEntity);
        return Mono.defer(() -> Mono.just(EntityToResponseMapper.buildOrganisationResponse(organisationEntity)));
    }

}

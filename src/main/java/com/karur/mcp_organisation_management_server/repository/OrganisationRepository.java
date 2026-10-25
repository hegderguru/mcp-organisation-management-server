package com.karur.mcp_organisation_management_server.repository;

import com.karur.mcp_organisation_management_server.entity.OrganisationEntity;
import org.springframework.stereotype.Repository;

@Repository
public class OrganisationRepository {

    private IOrganisationRepository iOrganisationRepository;

    public OrganisationEntity save(OrganisationEntity organisationEntity){
        return iOrganisationRepository.save(organisationEntity);
    }
}

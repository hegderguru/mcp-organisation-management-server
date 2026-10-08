package com.karur.mcp_organisation_management_server.mode.response;

import com.karur.mcp_organisation_management_server.entity.OrganisationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrganisationRepository extends JpaRepository<OrganisationEntity, Long> {
}

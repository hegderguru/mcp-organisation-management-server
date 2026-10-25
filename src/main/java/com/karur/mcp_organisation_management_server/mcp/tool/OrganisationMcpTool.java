package com.karur.mcp_organisation_management_server.mcp.tool;

import com.karur.mcp_organisation_management_server.mode.request.OrganisationRequest;
import com.karur.mcp_organisation_management_server.mode.response.OrganisationResponse;
import com.karur.mcp_organisation_management_server.service.OrganisationService;
import com.karur.mcp_organisation_management_server.util.CommonUtil;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.context.McpAsyncRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class OrganisationMcpTool {

    @Autowired
    OrganisationService organisationService;

    @McpTool(name = "create-organisation",description = "Create a new organisation")
    public Mono<OrganisationResponse> createOrganisation(McpAsyncRequestContext mcpAsyncRequestContext, OrganisationRequest organisationRequest){
        return mcpAsyncRequestContext.info("Request received with %s".formatted(CommonUtil.toString(organisationRequest)))
                .then(organisationService.createOrganisation(organisationRequest));
    }
}

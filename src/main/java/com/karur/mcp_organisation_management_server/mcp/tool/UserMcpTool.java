package com.karur.mcp_organisation_management_server.mcp.tool;

import com.karur.mcp_organisation_management_server.mode.request.UserRequest;
import com.karur.mcp_organisation_management_server.mode.response.UserResponse;
import com.karur.mcp_organisation_management_server.service.UserService;
import com.karur.mcp_organisation_management_server.util.CommonUtil;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.context.McpAsyncRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserMcpTool {

    @Autowired
    UserService userService;

    @McpTool(name = "create-user", description = "Create a new user")
    public Mono<UserResponse> createUser(McpAsyncRequestContext mcpAsyncRequestContext, UserRequest userRequest) {
        return mcpAsyncRequestContext.info("Request received with %s".formatted(CommonUtil.toString(userRequest)))
                .then(userService.createUser(userRequest));
    }
}

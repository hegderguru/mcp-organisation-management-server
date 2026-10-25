package com.karur.mcp_organisation_management_server.service;

import com.karur.mcp_organisation_management_server.entity.UserEntity;
import com.karur.mcp_organisation_management_server.mapper.EntityToResponseMapper;
import com.karur.mcp_organisation_management_server.mapper.RequestToEntityMapper;
import com.karur.mcp_organisation_management_server.mode.request.UserRequest;
import com.karur.mcp_organisation_management_server.mode.response.UserResponse;
import com.karur.mcp_organisation_management_server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserResponse createUser(UserRequest userRequest) {
        UserEntity userEntity = RequestToEntityMapper.buildCompleteUserRequest(userRequest);
        userEntity = userRepository.save(userEntity);
        return EntityToResponseMapper.buildUserResponse(userEntity);
    }

}

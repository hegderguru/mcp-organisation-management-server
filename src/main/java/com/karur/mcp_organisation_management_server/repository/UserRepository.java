package com.karur.mcp_organisation_management_server.repository;

import com.karur.mcp_organisation_management_server.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private IUserRepository iUserRepository;

    public UserEntity save(UserEntity userEntity){
        return iUserRepository.save(userEntity);
    }
}

package com.bahelix.spring_boot_microservice_3_api_gateway.service;

import java.util.Optional;

import com.bahelix.spring_boot_microservice_3_api_gateway.model.Role;
import com.bahelix.spring_boot_microservice_3_api_gateway.model.User;

public interface UserService {

  User saveUser(User user);

  Optional<User> findByUsername(String username);

  void changeRole(Role newRole, String username);

  User findByUsernameReturnToken(String username);

}

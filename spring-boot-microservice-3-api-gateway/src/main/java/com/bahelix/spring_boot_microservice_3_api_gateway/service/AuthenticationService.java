package com.bahelix.spring_boot_microservice_3_api_gateway.service;

import com.bahelix.spring_boot_microservice_3_api_gateway.model.User;

public interface AuthenticationService {

  User signInAndReturnJWT(User signInRequest);

}

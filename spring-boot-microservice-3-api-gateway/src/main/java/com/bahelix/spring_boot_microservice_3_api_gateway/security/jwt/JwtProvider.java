package com.bahelix.spring_boot_microservice_3_api_gateway.security.jwt;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.bahelix.spring_boot_microservice_3_api_gateway.model.User;
import com.bahelix.spring_boot_microservice_3_api_gateway.security.UserPrincipal;

import jakarta.servlet.http.HttpServletRequest;


@Component
public interface JwtProvider {

  String generateToken(UserPrincipal auth);

  String generateToken(User user);

  Authentication getAuthentication(HttpServletRequest request);

  boolean isTokenIsValid(HttpServletRequest request);

}

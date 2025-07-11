package com.bahelix.spring_boot_microservice_3_api_gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bahelix.spring_boot_microservice_3_api_gateway.model.Role;
import com.bahelix.spring_boot_microservice_3_api_gateway.security.UserPrincipal;
import com.bahelix.spring_boot_microservice_3_api_gateway.service.UserService;



@RestController
@RequestMapping("api/user")
public class UserController {

  @Autowired
  private UserService userService;


  @PutMapping("change/{role}")
  public ResponseEntity<?> changeRole(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable Role role) {

    userService.changeRole(role, userPrincipal.getUsername());

    return ResponseEntity.ok(true);
  }


  @GetMapping
  public ResponseEntity<?> getCurrentUser(@AuthenticationPrincipal UserPrincipal userPrincipal) {

    return new ResponseEntity<>(userService.findByUsernameReturnToken(userPrincipal.getUsername()), HttpStatus.OK);
  }

}

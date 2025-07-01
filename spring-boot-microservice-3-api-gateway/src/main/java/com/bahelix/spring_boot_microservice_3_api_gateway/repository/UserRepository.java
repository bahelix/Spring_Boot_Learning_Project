package com.bahelix.spring_boot_microservice_3_api_gateway.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bahelix.spring_boot_microservice_3_api_gateway.model.Role;
import com.bahelix.spring_boot_microservice_3_api_gateway.model.User;


public interface UserRepository extends JpaRepository<User, Long> {

  //findBy + nombreCampo
  Optional<User> findByUsername(String username);

  @Modifying
  @Query("update User set role=:role where username=:username")
  void updateUserRole(@Param("username") String username, @Param("role") Role role);

}

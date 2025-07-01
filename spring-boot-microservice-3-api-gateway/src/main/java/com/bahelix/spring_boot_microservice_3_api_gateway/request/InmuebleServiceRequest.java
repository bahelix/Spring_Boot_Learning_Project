package com.bahelix.spring_boot_microservice_3_api_gateway.request;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
  value = "inmuble-service",
  path = "/api/inmueble",
  url = "${inmueble.service.url}",
  configuration = FeignConfiguration.class
)
public interface InmuebleServiceRequest {

  @PostMapping
  Object saveInmueble(@RequestBody Object requestBody);

  @DeleteMapping("{inmuebleId}")
  void deleteInmueble(@PathVariable("inmuebleId") Long inmuebleId);

  @GetMapping()
  List<Object> getAllInmuebles();

}

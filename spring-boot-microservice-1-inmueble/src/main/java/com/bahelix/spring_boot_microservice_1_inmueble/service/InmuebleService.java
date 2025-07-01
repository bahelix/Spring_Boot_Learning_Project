package com.bahelix.spring_boot_microservice_1_inmueble.service;

import com.bahelix.spring_boot_microservice_1_inmueble.model.Inmueble;

import java.util.List;

public interface InmuebleService {

    Inmueble saveInmueble(Inmueble inmueble);

    void deleteInmueble(Long inmuebleId);

    List<Inmueble> findAllInmuebles();
}

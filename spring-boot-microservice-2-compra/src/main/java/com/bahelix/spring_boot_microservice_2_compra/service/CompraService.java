package com.bahelix.spring_boot_microservice_2_compra.service;

import java.util.List;

import com.bahelix.spring_boot_microservice_2_compra.model.Compra;

public interface CompraService {

  Compra saveCompra(Compra compra);

  List<Compra> findAllComprasOfUser(Long userId);

}

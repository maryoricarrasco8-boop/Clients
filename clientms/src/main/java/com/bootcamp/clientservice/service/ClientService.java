package com.bootcamp.clientservice.service;

import com.bootcamp.clientservice.model.Client;
import java.util.List;
import java.util.Optional;

public interface ClientService {
  List<Client> findAll();
  Optional<Client> findById(Long id);
  Client create(Client c);
  Client update(Long id, Client c);
  void delete(Long id);
}

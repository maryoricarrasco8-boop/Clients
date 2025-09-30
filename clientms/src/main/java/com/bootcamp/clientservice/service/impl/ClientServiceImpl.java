package com.bootcamp.clientservice.service.impl;

import com.bootcamp.clientservice.model.Client;
import com.bootcamp.clientservice.repository.ClientRepository;
import com.bootcamp.clientservice.service.ClientService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

  private final ClientRepository repo;

  public ClientServiceImpl(ClientRepository repo) {
    this.repo = repo;
  }

  @Override
  public List<Client> findAll() { return repo.findAll(); }

  @Override
  public Optional<Client> findById(Long id) { return repo.findById(id); }

  @Override
  public Client create(Client c) { return repo.save(c); }

  @Override
  public Client update(Long id, Client c) {
    return repo.findById(id).map(db -> {
      db.setDocumentType(c.getDocumentType());
      db.setDocumentNumber(c.getDocumentNumber());
      db.setFirstName(c.getFirstName());
      db.setLastName(c.getLastName());
      db.setEmail(c.getEmail());
      db.setPhone(c.getPhone());
      return repo.save(db);
    }).orElseThrow(() -> new RuntimeException("Client not found"));
  }

  @Override
  public void delete(Long id) { repo.deleteById(id); }
}

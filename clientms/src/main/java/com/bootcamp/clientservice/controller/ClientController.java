package com.bootcamp.clientservice.controller;

import com.bootcamp.clientservice.model.Client;
import com.bootcamp.clientservice.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

  private final ClientService service;

  public ClientController(ClientService service) {
    this.service = service;
  }

  @GetMapping
  public List<Client> getAll() { return service.findAll(); }

  @GetMapping("/{id}")
  public ResponseEntity<Client> getById(@PathVariable Long id) {
    return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Client> create(@RequestBody Client c) {
    Client created = service.create(c);
    return ResponseEntity.created(URI.create("/api/clients/" + created.getId())).body(created);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client c) {
    return ResponseEntity.ok(service.update(id, c));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}

package com.bootcamp.clientservice.service;

import com.bootcamp.clientservice.model.Client;
import com.bootcamp.clientservice.repository.ClientRepository;
import com.bootcamp.clientservice.service.impl.ClientServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientServiceTest {
  @Test
  void listClients_ok() {
    ClientRepository repo = Mockito.mock(ClientRepository.class);
    Mockito.when(repo.findAll()).thenReturn(Collections.emptyList());
    ClientService service = new ClientServiceImpl(repo);
    assertEquals(0, service.findAll().size());
  }
}

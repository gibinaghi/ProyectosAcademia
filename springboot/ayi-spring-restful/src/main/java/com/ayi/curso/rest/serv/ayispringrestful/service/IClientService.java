package com.ayi.curso.rest.serv.ayispringrestful.service;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.ClientRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.ClientUpdateRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.ClientResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IClientService {

    //Get all
    List<ClientResponse> findAllClient() throws ReadAccessException;

    //Get by id
    ClientResponse findClientById(Long idClient) throws ReadAccessException;

    //Create client, client detail and address
    ClientResponse createClient(ClientRequest clientRequest);

   //Update
    ClientResponse updateClient(Long idClient, ClientUpdateRequest clientRequest)
    throws ReadAccessException ;

    //Delete
    void deleteClient(Long idClient);
}

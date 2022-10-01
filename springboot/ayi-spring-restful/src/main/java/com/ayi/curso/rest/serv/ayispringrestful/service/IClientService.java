package com.ayi.curso.rest.serv.ayispringrestful.service;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.AddressRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.ClientRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.AddressResponse;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.ClientResponse;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.ReadAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IClientService {

    /*//Get all
    List<ClientResponse> findAllClient() throws ReadAccessException;*/

    //Get by id
    ClientResponse findClientById(Long idClient) throws ReadAccessException;

    /*//Create
    ClientResponse createClient(ClientRequest clientRequest);

    //Update
    ClientResponse updateClientById(Long idClient, ClientRequest clientRequest);*/

    //Delete
    void deleteClient(Long idClient);
}

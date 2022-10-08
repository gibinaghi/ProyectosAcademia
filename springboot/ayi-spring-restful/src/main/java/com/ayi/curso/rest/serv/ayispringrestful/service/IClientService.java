package com.ayi.curso.rest.serv.ayispringrestful.service;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.ClientRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.ClientUpdateRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.ClientResponse;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.BadRequestException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.InternalException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IClientService {

    //Get all
    List<ClientResponse> findAllClient()
            throws NotFoundException, InternalException;

    //Get by id
    ClientResponse findClientById(Long idClient)
            throws BadRequestException, InternalException;

    //Create client, client detail and address
    ClientResponse createClient(ClientRequest clientRequest);

   //Update
    ClientResponse updateClient(Long idClient, ClientUpdateRequest clientRequest)
            throws NotFoundException, InternalException, BadRequestException;

    //Delete
    void deleteClient(Long idClient)
            throws BadRequestException, InternalException, NotFoundException;
}

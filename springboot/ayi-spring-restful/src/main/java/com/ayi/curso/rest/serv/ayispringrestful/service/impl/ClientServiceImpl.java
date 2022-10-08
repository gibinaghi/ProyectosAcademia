package com.ayi.curso.rest.serv.ayispringrestful.service.impl;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.ClientDetaiUpdatelRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.ClientRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.ClientUpdateRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.ClientDetailResponse;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.ClientResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Address;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Client;
import com.ayi.curso.rest.serv.ayispringrestful.entity.ClientDetail;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.ReadAccessException;
import com.ayi.curso.rest.serv.ayispringrestful.mapper.IClientMapper;
import com.ayi.curso.rest.serv.ayispringrestful.repository.IClientRepository;
import com.ayi.curso.rest.serv.ayispringrestful.service.IClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.ayi.curso.rest.serv.ayispringrestful.constants.Exceptions.*;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements IClientService {
    private IClientRepository clientRepository;

    private IClientMapper clientMapper;

    //Get all
    @Override
    @Transactional
    public List<ClientResponse> findAllClient() throws ReadAccessException {

        List<Client> clientEntityList = clientRepository.findAll();

        if(clientEntityList== null) {            //.lenght == 0
            throw new ReadAccessException(EXCEPTION_DATA_NULL);
        }

        List<ClientResponse> clientListResponse = new ArrayList<>();
        clientEntityList.forEach(client -> {
            ClientResponse clientResponse = clientMapper.convertEntityToDto(client);
            clientListResponse.add(clientResponse);
        });

        return clientListResponse ;
    }

    //Get by id
    @Override
    @Transactional
    public ClientResponse findClientById(Long idClient) throws ReadAccessException {
        if(idClient == null || idClient < 0){
            throw new ReadAccessException(EXCEPTION_ID_NULL);
        }


        ClientResponse clientResponse;
        Optional<Client> entityClient = clientRepository.findById(idClient);

        if (!entityClient.isPresent()) {
            throw new ReadAccessException(EXCEPTION_ID_NOT_FOUND );
        }

        clientResponse = clientMapper.convertEntityToDto(entityClient.get());
        return clientResponse;
    }

    //Create client, client detail and address
    @Override
    @Transactional
    public ClientResponse createClient(ClientRequest clientRequest) {
        Client client  = clientMapper.convertDtoToEntity(clientRequest);

        //set address and client detail in client
        List<Address> address = client.getAddresses();
        ClientDetail clientDetail = client.getClientDetail();

        client.setAddresses(address);
        client.setClientDetail(clientDetail);

        //Save
        client = clientRepository.save(client);

        return clientMapper.convertEntityToDto(client);
    }

    //Update
    @Override
    public ClientResponse updateClient(Long idClient, ClientUpdateRequest clientRequest)
            throws ReadAccessException {
        Client clientToUpdate = clientRepository.findById(idClient).get();
        //control si no exite el id

        //poner control de si existe y distinto de null q setee lo q existe
        clientToUpdate.setName(clientRequest.getName());
        clientToUpdate.setLastname(clientRequest.getLastname());
        clientToUpdate.setDocumentNumber(clientRequest.getDocumentNumber());

        //Save update
        Client clientUpdated = clientRepository.save(clientToUpdate);

        return clientMapper.convertEntityToDto(clientUpdated);
    }

    //Delete
    @Override
    public void deleteClient(Long idClient){
        Optional<Client> entityClient = clientRepository.findById(idClient);

        if (entityClient.isPresent()) {
            clientRepository.deleteById(idClient);
        } else {
            throw new RuntimeException(EXCEPTION_ID_NOT_FOUND );
        }
    }
}

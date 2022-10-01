package com.ayi.curso.rest.serv.ayispringrestful.service.impl;

import com.ayi.curso.rest.serv.ayispringrestful.dto.response.ClientDetailResponse;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.ClientResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Client;
import com.ayi.curso.rest.serv.ayispringrestful.entity.ClientDetail;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.ReadAccessException;
import com.ayi.curso.rest.serv.ayispringrestful.mapper.IClientMapper;
import com.ayi.curso.rest.serv.ayispringrestful.repository.IClientRepository;
import com.ayi.curso.rest.serv.ayispringrestful.service.IClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements IClientService {
    private IClientRepository clientRepository;

    private IClientMapper clientMapper;

    //Get all

    //Get by id
    @Override
    @Transactional
    public ClientResponse findClientById(Long idClient) throws ReadAccessException {
        if(idClient == null || idClient < 0){
            throw new ReadAccessException("El id es nulo o vacío.");
        }


        ClientResponse clientResponse;
        Optional<Client> entityClent = clientRepository.findById(idClient);

        if (!entityClent.isPresent()) {
            throw new ReadAccessException("Error. ID not found.");
        }

        clientResponse = clientMapper.convertEntityToDto(entityClent.get());
        return clientResponse;
    }

    //Create

    //Update

    //Delete
    @Override
    public void deleteClient(Long idClient){
        Optional<Client> entityClient = clientRepository.findById(idClient);

        if (entityClient.isPresent()) {
            clientRepository.deleteById(idClient);
        } else {
            throw new RuntimeException("Error. ID not found.");
        }
    }
}

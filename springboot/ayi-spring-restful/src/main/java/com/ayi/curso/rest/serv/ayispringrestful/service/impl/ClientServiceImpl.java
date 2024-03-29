package com.ayi.curso.rest.serv.ayispringrestful.service.impl;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.ClientCreateRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.ClientUpdateRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.ClientResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Address;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Client;
import com.ayi.curso.rest.serv.ayispringrestful.entity.ClientDetail;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.BadRequestException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.InternalException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.NotFoundException;
import com.ayi.curso.rest.serv.ayispringrestful.mapper.IAddressMapper;
import com.ayi.curso.rest.serv.ayispringrestful.mapper.IClientDetailMapper;
import com.ayi.curso.rest.serv.ayispringrestful.mapper.IClientMapper;
import com.ayi.curso.rest.serv.ayispringrestful.repository.IClientRepository;
import com.ayi.curso.rest.serv.ayispringrestful.service.IClientService;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
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
    private IClientDetailMapper clientDetailMapper;
    private IAddressMapper addressMapper;

    //Get all
    @Override
    @Transactional
    public List<ClientResponse> findAllClient()
            throws NotFoundException, InternalException {

        List<Client> clientEntityList = null;
        try {
            clientEntityList = clientRepository.findAll();
        } catch (Exception ex) {
            throw  new InternalException(INTERNAL, ex);
        }

        if(CollectionUtils.isEmpty(clientEntityList)) {
            throw new NotFoundException(EXCEPTION_DATA_NULL);
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
    public ClientResponse findClientById(Long idClient)
            throws BadRequestException, InternalException, NotFoundException {

        if(idClient == null || idClient < 0){
            throw new BadRequestException(EXCEPTION_ID_NOT_VALID);
        }

        ClientResponse clientResponse;
        Optional<Client> entityClient = null;
        try {
            entityClient = clientRepository.findById(idClient);
        } catch (Exception ex)  {
            throw new InternalException(INTERNAL, ex);
        }

        if(!entityClient.isPresent()){
            throw new NotFoundException(EXCEPTION_ID_NOT_FOUND);
        }

        clientResponse = clientMapper.convertEntityToDto(entityClient.get());
        return clientResponse;
    }

    //Create client, client detail and address
    @Override
    @Transactional
    public ClientResponse createClient(ClientCreateRequest clientRequest) {
        Client clientEntity  = clientMapper.convertDtoToEntity(clientRequest.getClientRequest());
        ClientDetail clientDetail = clientDetailMapper.convertDtoToEntity(clientRequest.getClientDetailRequest());
        Address address = addressMapper.convertDtoToEntity(clientRequest.getAddressRequest());

        //Create client detail and address in Client
        clientDetail.setClient(clientEntity);
        address.setClient(clientEntity);

        clientEntity.setClientDetail(clientDetail);
        clientEntity.getAddresses().add(address);

        //Save
        Client dataClient = clientRepository.save(clientEntity);

        return clientMapper.convertEntityToDto(dataClient);
    }

    //Update
    @Override
    public ClientResponse updateClient(Long idClient, ClientUpdateRequest clientRequest)
            throws NotFoundException, InternalException, BadRequestException {

        if(idClient == null || idClient < 0){
            throw new BadRequestException(EXCEPTION_ID_NOT_VALID);
        }

        Client clientToUpdate = null;
        try {
            clientToUpdate = clientRepository.findById(idClient).get();
        } catch (Exception ex)  {
            throw  new InternalException(INTERNAL, ex);
        }

        if(clientToUpdate == null){
            throw new NotFoundException(EXCEPTION_DATA_NULL );
        }

        //Control data exist
        if(StringUtils.isNotEmpty(clientRequest.getName())){
            clientToUpdate.setName(clientRequest.getName());
        }
        if(StringUtils.isNotEmpty(clientRequest.getLastname())){
            clientToUpdate.setLastname(clientRequest.getLastname());
        }
        if(StringUtils.isNotEmpty(clientRequest.getDocumentNumber())){
            clientToUpdate.setDocumentNumber(clientRequest.getDocumentNumber());
        }

        //Save update
        Client clientUpdated = clientRepository.save(clientToUpdate);

        return clientMapper.convertEntityToDto(clientUpdated);
    }

    //Delete
    @Override
    public void deleteClient(Long idClient)
            throws BadRequestException, InternalException, NotFoundException {

        if(idClient == null || idClient < 0){
            throw new BadRequestException(EXCEPTION_ID_NOT_VALID);
        }

        Optional<Client> entityClient;
        try {
            entityClient = clientRepository.findById(idClient);
        } catch (Exception ex) {
            throw  new InternalException(INTERNAL, ex);
        }

        if (entityClient.isPresent()) {
            clientRepository.deleteById(idClient);
        } else {
            throw new NotFoundException(EXCEPTION_ID_NULL);
        }
    }
}

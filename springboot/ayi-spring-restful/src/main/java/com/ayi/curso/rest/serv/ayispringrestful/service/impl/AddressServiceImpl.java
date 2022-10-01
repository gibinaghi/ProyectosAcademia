package com.ayi.curso.rest.serv.ayispringrestful.service.impl;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.AddressRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.AddressResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Address;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Client;
import com.ayi.curso.rest.serv.ayispringrestful.mapper.IAddressMapper;
import com.ayi.curso.rest.serv.ayispringrestful.repository.IAddressRepository;
import com.ayi.curso.rest.serv.ayispringrestful.repository.IClientRepository;
import com.ayi.curso.rest.serv.ayispringrestful.service.IAddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements IAddressService {
    private IAddressRepository addressRepository;
    private IClientRepository clientRepository;

    private IAddressMapper addressMapper;

    //Create
    @Override
    @Transactional
    public AddressResponse createAddress(AddressRequest request) {
        Address address = addressMapper.convertDtoToEntity(request);

        //Find client entity for id
        //Long clientId = address.getClient().getIdClient();
        //Optional<Address> clientEntity = clientRepository.findById(clientId);

        Client client = address.getClient();

//        BIDIRECCIONALIDAD EN LA RELACIÓN PARA ACTUALIZAR LA LISTA DE ADDRESS DEL CLIENTE??
        address.setClient(client);

        //Set Client entity in Address
        //address.setClient(clientEntity);
        address = addressRepository.save(address);

        return addressMapper.convertEntityToDto(address);
    }
}

package com.ayi.curso.rest.serv.ayispringrestful.service.impl;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.AddressWithoutClientRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.AddressRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.AddressResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Address;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Client;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.ReadAccessException;
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

    //Get all -> agregar paginacion si alcanzo

    //Get by id
    @Override
    @Transactional
    public AddressResponse findAddressById(Long idAddress) throws ReadAccessException {
        if(idAddress == null || idAddress < 0){
            throw new ReadAccessException("El id es nulo o vacío.");
        }


        AddressResponse addressResponse;
        Optional<Address> entityAddress = addressRepository.findById(idAddress);

        if (!entityAddress.isPresent()) {
            throw new ReadAccessException("Error. ID not found.");
        }

        addressResponse = addressMapper.convertEntityToDto(entityAddress.get());
        return addressResponse;
    }

    //Create
    @Override
    @Transactional
    public AddressResponse createAddress(AddressWithoutClientRequest addressRequest, Long idClient) {
        Address address = addressMapper.convertDtoToEntityWithoutClient(addressRequest);

        Client client = clientRepository.findById(idClient).get();

        //Set client in address
        address.setClient(client);

        address = addressRepository.save(address);

        return addressMapper.convertEntityToDto(address);
    }

    //Create address and client
    @Override
    @Transactional
    public AddressResponse createAddressAndClient(AddressRequest addressRequest) {
        Address address = addressMapper.convertDtoToEntity(addressRequest);

        Client client = address.getClient();

        //BIDIRECCIONALIDAD EN LA RELACIÓN PARA ACTUALIZAR LA LISTA DE ADDRESS DEL CLIENTE??
        address.setClient(client);

        address = addressRepository.save(address);

        return addressMapper.convertEntityToDto(address);
    }

    //Update

    //Delete
    @Override
    public void deleteAddress(Long idAddress){
        Optional<Address> entityAddress = addressRepository.findById(idAddress);

        if (entityAddress.isPresent()) {
            addressRepository.deleteById(idAddress);
        } else {
            throw new RuntimeException("Error. ID not found.");
        }
    }

}

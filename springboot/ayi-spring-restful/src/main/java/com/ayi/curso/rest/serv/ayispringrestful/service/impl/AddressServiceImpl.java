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

import static com.ayi.curso.rest.serv.ayispringrestful.constants.Exceptions.EXCEPTION_ID_NOT_FOUND;
import static com.ayi.curso.rest.serv.ayispringrestful.constants.Exceptions.EXCEPTION_ID_NULL;

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
            throw new ReadAccessException(EXCEPTION_ID_NULL);
        }


        AddressResponse addressResponse;
        Optional<Address> entityAddress = addressRepository.findById(idAddress);

        if (!entityAddress.isPresent()) {
            throw new ReadAccessException(EXCEPTION_ID_NOT_FOUND);
        }

        addressResponse = addressMapper.convertEntityToDto(entityAddress.get());
        return addressResponse;
    }

    //Create address and set client
    @Override
    @Transactional
    public AddressResponse createAddress(AddressWithoutClientRequest addressRequest, Long idClient) {
        Address address = addressMapper.convertDtoToEntityWithoutClient(addressRequest);

        Client client = clientRepository.findById(idClient).get();

        //Set client in address
        address.setClient(client);

        //Save
        address = addressRepository.save(address);

        return addressMapper.convertEntityToDto(address);
    }

    //Create address and client
    @Override
    @Transactional
    public AddressResponse createAddressAndClient(AddressRequest addressRequest) {
        Address address = addressMapper.convertDtoToEntity(addressRequest);

        //Set client in address
        Client client = address.getClient();

        address.setClient(client);

        //Save
        address = addressRepository.save(address);

        return addressMapper.convertEntityToDto(address);
    }

    //Update

    //Delete
    //falta borrar tambien cliente y detalle cliente
    @Override
    public void deleteAddress(Long idAddress){
        Optional<Address> entityAddress = addressRepository.findById(idAddress);

        if (entityAddress.isPresent()) {
            addressRepository.deleteById(idAddress);
        } else {
            throw new RuntimeException(EXCEPTION_ID_NOT_FOUND);
        }
    }

}

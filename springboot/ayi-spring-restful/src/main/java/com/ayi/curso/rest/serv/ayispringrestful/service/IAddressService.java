package com.ayi.curso.rest.serv.ayispringrestful.service;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.AddressWithoutClientRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.AddressRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.AddressResponse;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.ReadAccessException;
import org.springframework.stereotype.Service;

@Service
public interface IAddressService {

    /*//Get all
    List<AddressResponse> findAllAddress()  throws ReadAccessException;*/

    //Get by id
    AddressResponse findAddressById(Long idAddress) throws ReadAccessException;

    //Create
    AddressResponse createAddress(AddressWithoutClientRequest addressRequest, Long idClient);

    //Create address and client
    AddressResponse createAddressAndClient(AddressRequest addressRequest);

    /*//Update
    AddressResponse updateAddressById(Long idAddress, AddressRequest addressRequest);*/

    //Delete
    void deleteAddress(Long idAddress);
}

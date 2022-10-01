package com.ayi.curso.rest.serv.ayispringrestful.service;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.AddressRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.AddressResponse;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.ReadAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAddressService {

    /*//Get all
    List<AddressResponse> findAllAddress()  throws ReadAccessException;*/

    //Get by id
    AddressResponse findAddressById(Long idAddress) throws ReadAccessException;

    //Create
    AddressResponse createAddress(AddressRequest addressRequest);

    /*//Update
    AddressResponse updateAddressById(Long idAddress, AddressRequest addressRequest);*/

    //Delete
    void deleteAddress(Long idAddress);
}

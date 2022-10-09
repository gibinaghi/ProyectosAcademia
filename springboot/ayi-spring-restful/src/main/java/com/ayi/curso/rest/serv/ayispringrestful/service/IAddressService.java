package com.ayi.curso.rest.serv.ayispringrestful.service;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.AddressCreateRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.AddressUpdateRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.AddressRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.AddressResponse;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.BadRequestException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.InternalException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAddressService {

    //Get all
    List<AddressResponse> findAllAddress()
            throws NotFoundException, InternalException;

    //Get by id
    AddressResponse findAddressById(Long idAddress)
            throws BadRequestException, InternalException, NotFoundException;

    //Create address and set client
    AddressResponse createAddress(AddressRequest addressRequest, Long idClient)
            throws BadRequestException, InternalException;

    //Create address and client
    AddressResponse createAddressAndClient(AddressCreateRequest addressRequest);

    //Update
    AddressResponse updateAddress(Long idAddress, AddressUpdateRequest addressRequest)
            throws NotFoundException, InternalException, BadRequestException;

    //Delete
    void deleteAddress(Long idAddress)
            throws BadRequestException, InternalException, NotFoundException;
}

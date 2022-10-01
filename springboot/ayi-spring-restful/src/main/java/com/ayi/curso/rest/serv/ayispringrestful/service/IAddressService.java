package com.ayi.curso.rest.serv.ayispringrestful.service;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.AddressRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.AddressResponse;
import org.springframework.stereotype.Service;

@Service
public interface IAddressService {
    AddressResponse createAddress(AddressRequest request);
}

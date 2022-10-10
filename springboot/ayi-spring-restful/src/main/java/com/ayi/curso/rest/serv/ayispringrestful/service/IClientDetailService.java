package com.ayi.curso.rest.serv.ayispringrestful.service;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.ClientDetaiUpdatelRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.ClientDetailCreateRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.ClientDetailResponse;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.BadRequestException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.InternalException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IClientDetailService {
    //Get all
    List<ClientDetailResponse> findAllClientDetail()
            throws NotFoundException, InternalException;

    //Get by id
    ClientDetailResponse findClientDetailById(Long idClientDetail)
            throws BadRequestException, InternalException, NotFoundException;

    //Create client detail and client
    ClientDetailResponse createClientDetail(ClientDetailCreateRequest clientDetailRequest);

    //Update
    ClientDetailResponse updateClientDetail(
            Long idClientDetail, ClientDetaiUpdatelRequest clientDetailRequest)
            throws NotFoundException, InternalException, BadRequestException;

    //Delete
    void deleteClientDetail(Long idClientDetail)
            throws BadRequestException, InternalException, NotFoundException;
}

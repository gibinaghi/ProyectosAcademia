package com.ayi.curso.rest.serv.ayispringrestful.service;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.ClientDetaiUpdatelRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.ClientDetailRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.ClientDetailResponse;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.ReadAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IClientDetailService {
    //Get all
    List<ClientDetailResponse> findAllClientDetail() throws ReadAccessException;

    //Get by id
    ClientDetailResponse findClientDetailById(Long idClientDetail) throws ReadAccessException;

    //Create client detail and client
    ClientDetailResponse createClientDetail(ClientDetailRequest clientDetailRequest);

    //Update
    ClientDetailResponse updateClientDetail(
            Long idClientDetail, ClientDetaiUpdatelRequest clientDetailRequest)
            throws ReadAccessException ;

    //Delete
    void deleteClientDetail(Long idClientDetail);
}

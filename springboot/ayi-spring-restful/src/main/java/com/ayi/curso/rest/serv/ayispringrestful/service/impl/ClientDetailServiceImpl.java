package com.ayi.curso.rest.serv.ayispringrestful.service.impl;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.AddressRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.AddressResponse;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.ClientDetailResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Address;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Client;
import com.ayi.curso.rest.serv.ayispringrestful.entity.ClientDetail;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.ReadAccessException;
import com.ayi.curso.rest.serv.ayispringrestful.mapper.IClientDetailMapper;
import com.ayi.curso.rest.serv.ayispringrestful.repository.IClientDetailRepository;
import com.ayi.curso.rest.serv.ayispringrestful.service.IClientDetailService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientDetailServiceImpl implements IClientDetailService {
    private IClientDetailRepository clientDetailRepository;

    private IClientDetailMapper clientDetailMapper;

    //Get all

    //Get by id
    @Override
    @Transactional
    public ClientDetailResponse findClientDetailById(Long idClientDetail) throws ReadAccessException {
        if(idClientDetail == null || idClientDetail < 0){
            throw new ReadAccessException("El id es nulo o vacío.");
        }


        ClientDetailResponse clientDetailResponse;
        Optional<ClientDetail> entityClientDetail = clientDetailRepository.findById(idClientDetail);

        if (!entityClientDetail.isPresent()) {
            throw new ReadAccessException("Error. ID not found.");
        }

        clientDetailResponse = clientDetailMapper.convertEntityToDto(entityClientDetail.get());
        return clientDetailResponse;
    }

    //Create

    //Update

    //Delete
    @Override
    public void deleteClientDetail(Long idClientDetail){
        Optional<ClientDetail> entityClientDetail = clientDetailRepository.findById(idClientDetail);

        if (entityClientDetail.isPresent()) {
            clientDetailRepository.deleteById(idClientDetail);
        } else {
            throw new RuntimeException("Error. ID not found.");
        }
    }
}

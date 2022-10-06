package com.ayi.curso.rest.serv.ayispringrestful.service.impl;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.AddressRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.AddressWithoutClientRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.ClientDetailRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.AddressResponse;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.ClientDetailResponse;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.ClientResponse;
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

import static com.ayi.curso.rest.serv.ayispringrestful.constants.Exceptions.EXCEPTION_ID_NOT_FOUND;
import static com.ayi.curso.rest.serv.ayispringrestful.constants.Exceptions.EXCEPTION_ID_NULL;

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
            throw new ReadAccessException(EXCEPTION_ID_NULL);
        }


        ClientDetailResponse clientDetailResponse;
        Optional<ClientDetail> entityClientDetail = clientDetailRepository.findById(idClientDetail);

        if (!entityClientDetail.isPresent()) {
            throw new ReadAccessException(EXCEPTION_ID_NOT_FOUND);
        }

        clientDetailResponse = clientDetailMapper.convertEntityToDto(entityClientDetail.get());
        return clientDetailResponse;
    }

    //Create client detail and client
    @Override
    @Transactional
    public ClientDetailResponse createClientDetail(ClientDetailRequest clientDetailRequest) {
        ClientDetail clientDetail = clientDetailMapper.convertDtoToEntity(clientDetailRequest);


        //Set client in client detail
        Client client = clientDetail.getClient();

        clientDetail.setClient(client);

        //Save
        clientDetail = clientDetailRepository.save(clientDetail);

        return clientDetailMapper.convertEntityToDto(clientDetail);
    }

    //Update

    //Delete
    @Override
    public void deleteClientDetail(Long idClientDetail){
        Optional<ClientDetail> entityClientDetail = clientDetailRepository.findById(idClientDetail);

        if (entityClientDetail.isPresent()) {
            clientDetailRepository.deleteById(idClientDetail);
        } else {
            throw new RuntimeException(EXCEPTION_ID_NOT_FOUND);
        }
    }
}

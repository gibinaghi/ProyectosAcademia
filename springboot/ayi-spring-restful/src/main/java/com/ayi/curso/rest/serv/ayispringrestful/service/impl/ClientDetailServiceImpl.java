package com.ayi.curso.rest.serv.ayispringrestful.service.impl;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.ClientDetaiUpdatelRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.ClientDetailCreateRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.ClientDetailResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Client;
import com.ayi.curso.rest.serv.ayispringrestful.entity.ClientDetail;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.BadRequestException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.InternalException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.NotFoundException;
import com.ayi.curso.rest.serv.ayispringrestful.mapper.IClientDetailMapper;
import com.ayi.curso.rest.serv.ayispringrestful.mapper.IClientMapper;
import com.ayi.curso.rest.serv.ayispringrestful.repository.IClientDetailRepository;
import com.ayi.curso.rest.serv.ayispringrestful.service.IClientDetailService;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.ayi.curso.rest.serv.ayispringrestful.constants.Exceptions.*;

@Service
@AllArgsConstructor
public class ClientDetailServiceImpl implements IClientDetailService {
    private IClientDetailRepository clientDetailRepository;

    private IClientDetailMapper clientDetailMapper;
    private IClientMapper clientMapper;

    //Get all
    @Override
    @Transactional
    public List<ClientDetailResponse> findAllClientDetail()
            throws NotFoundException, InternalException {

        List<ClientDetail> clientEntityList = null;
        try {
            clientEntityList = clientDetailRepository.findAll();
        } catch (Exception ex) {
            throw  new InternalException(INTERNAL, ex);
        }

        if(CollectionUtils.isEmpty(clientEntityList)) {
            throw new NotFoundException(EXCEPTION_DATA_NULL);
        }

        List<ClientDetailResponse> clientListResponse = new ArrayList<>();
        clientEntityList.forEach(client -> {
            ClientDetailResponse clientResponse = clientDetailMapper.convertEntityToDto(client);
            clientListResponse.add(clientResponse);
        });

        return clientListResponse ;
    }

    //Get by id
    @Override
    @Transactional
    public ClientDetailResponse findClientDetailById(Long idClientDetail)
            throws BadRequestException, InternalException, NotFoundException {

        if(idClientDetail == null || idClientDetail < 0){
            throw new BadRequestException(EXCEPTION_ID_NOT_VALID);
        }

        ClientDetailResponse clientDetailResponse;
        Optional<ClientDetail> entityClientDetail = null;
        try {
            entityClientDetail = clientDetailRepository.findById(idClientDetail);
        } catch (Exception ex)  {
            throw new InternalException(INTERNAL, ex);
        }

        if(!entityClientDetail.isPresent()){
            throw new NotFoundException(EXCEPTION_ID_NOT_FOUND);
        }

        clientDetailResponse = clientDetailMapper.convertEntityToDto(entityClientDetail.get());
        return clientDetailResponse;
    }

    //Create client detail and client
    @Override
    @Transactional
    public ClientDetailResponse createClientDetail(ClientDetailCreateRequest clientDetailRequest) {
        ClientDetail clientDetailEntity = clientDetailMapper.convertDtoToEntity(clientDetailRequest.getClientDetailRequest());
        Client client = clientMapper.convertDtoToEntity(clientDetailRequest.getClientRequest());

        //Create client in client detail
        clientDetailEntity.setClient(client);

        //Save
        clientDetailEntity = clientDetailRepository.save(clientDetailEntity);

        return clientDetailMapper.convertEntityToDto(clientDetailEntity);
    }

    //Update
    @Override
    public ClientDetailResponse updateClientDetail(
            Long idClientDetail, ClientDetaiUpdatelRequest clientDetailRequest)
            throws NotFoundException, InternalException, BadRequestException {

        if(idClientDetail == null || idClientDetail < 0){
            throw new BadRequestException(EXCEPTION_ID_NOT_VALID);
        }

        ClientDetail clientToUpdate = null;
        try {
            clientToUpdate = clientDetailRepository.findById(idClientDetail).get();
        } catch (Exception ex)  {
            throw  new InternalException(INTERNAL, ex);
        }

        if(clientToUpdate == null){
            throw new NotFoundException(EXCEPTION_DATA_NULL );
        }

        //Control data exist
        if(null != clientDetailRequest.getPrime()){
            clientToUpdate.setPrime(clientDetailRequest.getPrime());
        }
        if(null != clientDetailRequest.getAcumulatedPoints()){
            clientToUpdate.setAcumulatedPoints(clientDetailRequest.getAcumulatedPoints());
        }

        //Save update
        ClientDetail clientUpdated = clientDetailRepository.save(clientToUpdate);

        return clientDetailMapper.convertEntityToDto(clientUpdated);
    }

    //Delete
    @Override
    public void deleteClientDetail(Long idClientDetail)
            throws BadRequestException, InternalException, NotFoundException {

        if(idClientDetail == null || idClientDetail < 0){
            throw new BadRequestException(EXCEPTION_ID_NOT_VALID);
        }

        Optional<ClientDetail> entityClientDetail;
        try {
            entityClientDetail = clientDetailRepository.findById(idClientDetail);
        } catch (Exception ex) {
            throw  new InternalException(INTERNAL, ex);
        }

        if (entityClientDetail.isPresent()) {
            clientDetailRepository.deleteById(idClientDetail);
        } else {
            throw new NotFoundException(EXCEPTION_ID_NULL);
        }
    }
}

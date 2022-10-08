package com.ayi.curso.rest.serv.ayispringrestful.service.impl;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.ClientDetaiUpdatelRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.ClientDetailRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.ClientDetailResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Client;
import com.ayi.curso.rest.serv.ayispringrestful.entity.ClientDetail;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.ReadAccessException;
import com.ayi.curso.rest.serv.ayispringrestful.mapper.IClientDetailMapper;
import com.ayi.curso.rest.serv.ayispringrestful.repository.IClientDetailRepository;
import com.ayi.curso.rest.serv.ayispringrestful.service.IClientDetailService;
import lombok.AllArgsConstructor;
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

    //Get all
    @Override
    @Transactional
    public List<ClientDetailResponse> findAllClientDetail() throws ReadAccessException {

        List<ClientDetail> clientEntityList = clientDetailRepository.findAll();

        if(clientEntityList== null) {            //.lenght == 0
            throw new ReadAccessException(EXCEPTION_DATA_NULL);
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
    //falta crear la direccion o asignarle una direccion
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
    @Override
    public ClientDetailResponse updateClientDetail(
            Long idClientDetail, ClientDetaiUpdatelRequest clientDetailRequest)
            throws ReadAccessException {
        ClientDetail clientToUpdate = clientDetailRepository.findById(idClientDetail).get();
        //control si no exite el id

        //poner control de si existe y distinto de null q setee lo q existe
        clientToUpdate.setPrime(clientDetailRequest.getPrime());
        clientToUpdate.setAcumulatedPoints(clientDetailRequest.getAcumulatedPoints());

        //Save update
        ClientDetail clientUpdated = clientDetailRepository.save(clientToUpdate);

        return clientDetailMapper.convertEntityToDto(clientUpdated);
    }

    //Delete
    //falta borrar tambien direccion y detalle cliente
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

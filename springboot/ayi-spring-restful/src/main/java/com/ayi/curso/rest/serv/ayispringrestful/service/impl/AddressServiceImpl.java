package com.ayi.curso.rest.serv.ayispringrestful.service.impl;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.AddressUpdateRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.AddressWithoutClientRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.AddressRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.AddressResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Address;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Client;
import com.ayi.curso.rest.serv.ayispringrestful.mapper.IAddressMapper;
import com.ayi.curso.rest.serv.ayispringrestful.repository.IAddressRepository;
import com.ayi.curso.rest.serv.ayispringrestful.repository.IClientRepository;
import com.ayi.curso.rest.serv.ayispringrestful.service.IAddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.ayi.curso.rest.serv.ayispringrestful.constants.Exceptions.*;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements IAddressService {
    private IAddressRepository addressRepository;
    private IClientRepository clientRepository;

    private IAddressMapper addressMapper;

    //Get all -> agregar paginacion si alcanzo
    @Override
    @Transactional
    public List<AddressResponse> findAllAddress() {

        List<Address> addressEntityList = addressRepository.findAll();

        if(addressEntityList == null) {            //.lenght == 0
            throw new ReadAccessException(EXCEPTION_DATA_NULL);
        }

        List<AddressResponse> addressListResponse = new ArrayList<>();
        addressEntityList.forEach(address -> {
            AddressResponse addressResponse = addressMapper.convertEntityToDto(address);
            addressListResponse.add(addressResponse);
        });

        return addressListResponse ;
    }

    //Get by id
    @Override
    @Transactional
    public AddressResponse findAddressById(Long idAddress) throws ReadAccessException {
        if(idAddress == null || idAddress < 0){
            throw new ReadAccessException(EXCEPTION_ID_NULL);
        }


        AddressResponse addressResponse;
        Optional<Address> entityAddress = addressRepository.findById(idAddress);

        if (!entityAddress.isPresent()) {
            throw new ReadAccessException(EXCEPTION_ID_NOT_FOUND);
        }

        addressResponse = addressMapper.convertEntityToDto(entityAddress.get());
        return addressResponse;
    }

    //Create address and set client
    @Override
    @Transactional
    public AddressResponse createAddress(AddressWithoutClientRequest addressRequest, Long idClient) {
        Address address = addressMapper.convertDtoToEntityWithoutClient(addressRequest);

        Client client = clientRepository.findById(idClient).get();

        //Set client in address
        address.setClient(client);

        //Save
        address = addressRepository.save(address);

        return addressMapper.convertEntityToDto(address);
    }

    //Create address and client
    @Override
    @Transactional
    public AddressResponse createAddressAndClient(AddressRequest addressRequest) {
        Address address = addressMapper.convertDtoToEntity(addressRequest);

        //Set client in address
        Client client = address.getClient();

        address.setClient(client);

        //Save
        address = addressRepository.save(address);

        return addressMapper.convertEntityToDto(address);
    }

    //Update
    @Override
    //@Transactional  -> que hace??
    public AddressResponse updateAddress(Long idAddress, AddressUpdateRequest addressRequest)
            throws ReadAccessException  {
        if(idAddress == null || idAddress < 0){
            throw new ReadAccessException(EXCEPTION_ID_NOT_VALID);
        }

        Address addressToUpdate = addressRepository.findById(idAddress).get();
        if(addressToUpdate == null){
            throw new ReadAccessException(EXCEPTION_DATA_NULL);
        }

        //poner control de si existe y distinto de null q setee lo q existe
        addressToUpdate.setStreet(addressRequest.getStreet());
        addressToUpdate.setStreetNumber(addressRequest.getStreetNumber());
        addressToUpdate.setFloor(addressRequest.getFloor());
        addressToUpdate.setPostalCode(addressRequest.getPostalCode());
        addressToUpdate.setDistrict(addressRequest.getDistrict());
        addressToUpdate.setCity(addressRequest.getCity());
        addressToUpdate.setCountry(addressRequest.getCountry());

        //Save update
        Address addressUpdated = addressRepository.save(addressToUpdate);

        return addressMapper.convertEntityToDto(addressUpdated);
    }

    //Delete
    //falta borrar tambien cliente y detalle cliente
    @Override
    public void deleteAddress(Long idAddress){
        Optional<Address> entityAddress = addressRepository.findById(idAddress);

        if (entityAddress.isPresent()) {
            addressRepository.deleteById(idAddress);
        } else {
            throw new RuntimeException(EXCEPTION_ID_NOT_FOUND);
        }
    }

}

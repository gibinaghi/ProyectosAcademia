package com.ayi.curso.rest.serv.ayispringrestful.service.impl;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.AddressCreateRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.AddressUpdateRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.AddressRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.ClientRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.AddressResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Address;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Client;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.BadRequestException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.InternalException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.NotFoundException;
import com.ayi.curso.rest.serv.ayispringrestful.mapper.IAddressMapper;
import com.ayi.curso.rest.serv.ayispringrestful.mapper.IClientMapper;
import com.ayi.curso.rest.serv.ayispringrestful.repository.IAddressRepository;
import com.ayi.curso.rest.serv.ayispringrestful.repository.IClientRepository;
import com.ayi.curso.rest.serv.ayispringrestful.service.IAddressService;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
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
    private IClientMapper clientMapper;

    //Get all
    @Override
    @Transactional
    public List<AddressResponse> findAllAddress()
            throws NotFoundException, InternalException {

        List<Address> addressEntityList = null;
        try {
            addressEntityList = addressRepository.findAll();
        } catch (Exception ex) {
            throw new InternalException(INTERNAL, ex);
        }

        if(CollectionUtils.isEmpty(addressEntityList)) {
            throw new NotFoundException(EXCEPTION_DATA_NULL);
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
    public AddressResponse findAddressById(Long idAddress)
            throws BadRequestException, InternalException, NotFoundException  {

        if(idAddress == null || idAddress < 0){
            throw new BadRequestException(EXCEPTION_ID_NOT_VALID);
        }

        AddressResponse addressResponse;
        Optional<Address> entityAddress = null;
        try {
            entityAddress = addressRepository.findById(idAddress);
        } catch (Exception ex)  {
            throw new InternalException(INTERNAL, ex);
        }

        if(!entityAddress.isPresent()){
            throw new NotFoundException(EXCEPTION_ID_NOT_FOUND);
        }

        addressResponse = addressMapper.convertEntityToDto(entityAddress.get());
        return addressResponse;
    }

    //Create address and set client
    @Override
    @Transactional
    public AddressResponse createAddress(AddressRequest addressRequest, Long idClient)
            throws BadRequestException, InternalException {

        if(idClient == null || idClient < 0){
            throw new BadRequestException(EXCEPTION_ID_NOT_VALID);
        }

        Address address = addressMapper.convertDtoToEntity(addressRequest);

        Client client = null;
        try {
            client = clientRepository.findById(idClient).get();
        } catch (Exception ex)  {
            throw new InternalException(INTERNAL, ex);
        }

        if(client == null){
            throw new BadRequestException(EXCEPTION_ID_NOT_VALID);
        }

        //Set client in address
        address.setClient(client);

        //Save
        address = addressRepository.save(address);

        return addressMapper.convertEntityToDto(address);
    }

    //Create address and client
    @Override
    @Transactional
    public AddressResponse createAddressAndClient(AddressCreateRequest addressRequest) {
        Address addressEntity = addressMapper.convertDtoToEntity(addressRequest.getAddressRequest());
        Client client = clientMapper.convertDtoToEntity(addressRequest.getClientRequest());

        //Create client in address
        addressEntity.setClient(client);

        //Save
        addressEntity = addressRepository.save(addressEntity);

        return addressMapper.convertEntityToDto(addressEntity);
    }

    //Update
    @Override
    //@Transactional  -> que hace??
    public AddressResponse updateAddress(Long idAddress, AddressUpdateRequest addressRequest)
            throws NotFoundException, InternalException, BadRequestException  {

        if(idAddress == null || idAddress < 0){
            throw new BadRequestException(EXCEPTION_ID_NOT_VALID);
        }

        Address addressToUpdate = null;
        try {
            addressToUpdate = addressRepository.findById(idAddress).get();
        } catch (Exception ex)  {
            throw new InternalException(INTERNAL, ex);
        }

        if(addressToUpdate == null){
            throw new NotFoundException(EXCEPTION_DATA_NULL );
        }

        //Control data exist
        if(StringUtils.isNotEmpty(addressRequest.getStreet())){
            addressToUpdate.setStreet(addressRequest.getStreet());
        }
        if(StringUtils.isNotEmpty(addressRequest.getStreetNumber())){
            addressToUpdate.setStreetNumber(addressRequest.getStreetNumber());
        }
        if(null != addressRequest.getFloor()){
            addressToUpdate.setFloor(addressRequest.getFloor());
        }
        if(null != addressRequest.getPostalCode()){
            addressToUpdate.setPostalCode(addressRequest.getPostalCode());
        }
        if(StringUtils.isNotEmpty(addressRequest.getDistrict())){
            addressToUpdate.setDistrict(addressRequest.getDistrict());
        }
        if(StringUtils.isNotEmpty(addressRequest.getCity())){
            addressToUpdate.setCity(addressRequest.getCity());
        }
        if(StringUtils.isNotEmpty(addressRequest.getCountry())){
            addressToUpdate.setCountry(addressRequest.getCountry());
        }

        //Save update
        Address addressUpdated = addressRepository.save(addressToUpdate);

        return addressMapper.convertEntityToDto(addressUpdated);
    }

    //Delete
    @Override
    public void deleteAddress(Long idAddress)
            throws BadRequestException, InternalException, NotFoundException {

        if(idAddress == null || idAddress < 0){
            throw new BadRequestException(EXCEPTION_ID_NOT_VALID);
        }

        Optional<Address> entityAddress = null;
        try {
            entityAddress = addressRepository.findById(idAddress);
        } catch (Exception ex) {
            throw new InternalException(INTERNAL, ex);
        }

        if (entityAddress.isPresent()) {
            addressRepository.deleteById(idAddress);
        } else {
            throw new NotFoundException(EXCEPTION_ID_NULL);
        }
    }

}

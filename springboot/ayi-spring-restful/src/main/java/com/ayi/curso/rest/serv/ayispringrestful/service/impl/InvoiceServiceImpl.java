package com.ayi.curso.rest.serv.ayispringrestful.service.impl;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.InvoiceCreateRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.InvoiceRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.InvoiceUpdateRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.InvoiceResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Address;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Client;
import com.ayi.curso.rest.serv.ayispringrestful.entity.ClientDetail;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Invoice;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.BadRequestException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.InternalException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.NotFoundException;
import com.ayi.curso.rest.serv.ayispringrestful.mapper.IAddressMapper;
import com.ayi.curso.rest.serv.ayispringrestful.mapper.IClientDetailMapper;
import com.ayi.curso.rest.serv.ayispringrestful.mapper.IClientMapper;
import com.ayi.curso.rest.serv.ayispringrestful.mapper.IInvoiceMapper;
import com.ayi.curso.rest.serv.ayispringrestful.repository.IClientRepository;
import com.ayi.curso.rest.serv.ayispringrestful.repository.IInvoiceRepository;
import com.ayi.curso.rest.serv.ayispringrestful.service.IInvoiceService;
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
public class InvoiceServiceImpl implements IInvoiceService {
    private IInvoiceRepository invoiceRepository;
    private IClientRepository clientRepository;

    private IInvoiceMapper invoiceMapper;
    private IAddressMapper addressMapper;
    private IClientMapper clientMapper;
    private IClientDetailMapper clientDetailMapper;

    //Get all
    @Override
    @Transactional
    public List<InvoiceResponse> findAllInvoice()
            throws NotFoundException, InternalException {

        List<Invoice> invoiceEntityList = null;
        try {
            invoiceEntityList = invoiceRepository.findAll();
        } catch (Exception ex) {
        throw  new InternalException(INTERNAL, ex);
        }

        if(CollectionUtils.isEmpty(invoiceEntityList)) {
            throw new NotFoundException(EXCEPTION_DATA_NULL);
        }

        List<InvoiceResponse> invoiceListResponse = new ArrayList<>();
        invoiceEntityList.forEach(invoice -> {
            InvoiceResponse invoiceResponse = invoiceMapper.convertEntityToDto(invoice);
            invoiceListResponse.add(invoiceResponse);
        });

        return invoiceListResponse ;
    }

    //Get by id
    @Override
    @Transactional
    public InvoiceResponse findInvoiceById(Long idInvoice)
            throws BadRequestException, InternalException, NotFoundException {

        if(idInvoice == null || idInvoice < 0){
            throw new BadRequestException(EXCEPTION_ID_NOT_VALID);
        }

        InvoiceResponse invoiceResponse;
        Optional<Invoice> entityInvoice = null;
        try {
            entityInvoice = invoiceRepository.findById(idInvoice);
        } catch (Exception ex)  {
            throw new InternalException(INTERNAL, ex);
        }

        if(!entityInvoice.isPresent()){
            throw new NotFoundException(EXCEPTION_ID_NOT_FOUND);
        }

        invoiceResponse= invoiceMapper.convertEntityToDto(entityInvoice.get());
        return invoiceResponse;
    }

    //Create invoice and set client, detail client and address
    @Override
    @Transactional
    public InvoiceResponse createInvoiceSetClient(InvoiceRequest invoiceRequest, Long idClient)
            throws BadRequestException, InternalException {

        if(idClient == null || idClient < 0){
            throw new BadRequestException(EXCEPTION_ID_NOT_VALID);
        }

        Invoice invoice = invoiceMapper.convertDtoToEntity(invoiceRequest);

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
        invoice.setClient(client);

        //Save
        invoice = invoiceRepository.save(invoice);

        return invoiceMapper.convertEntityToDto(invoice);
    }

    //Create invoice, client, detail client, address
    @Override
    @Transactional
    public InvoiceResponse createInvoice(InvoiceCreateRequest invoiceRequest){
        Invoice invoiceEntity = invoiceMapper.convertDtoToEntity(invoiceRequest.getInvoiceRequest());
        Address address = addressMapper.convertDtoToEntity(invoiceRequest.getAddressRequest());
        Client client = clientMapper.convertDtoToEntity(invoiceRequest.getClientRequest());
        ClientDetail clientDetail = clientDetailMapper.convertDtoToEntity(invoiceRequest.getClientDetailRequest());

        //Create client, client detail and address in Invoice
        address.setClient(client);
        clientDetail.setClient(client);

        invoiceEntity.setClient(client);
        invoiceEntity.getClient().getAddresses().add(address);
        invoiceEntity.getClient().setClientDetail(clientDetail);

        //Save
        invoiceEntity = invoiceRepository.save(invoiceEntity);

        return invoiceMapper.convertEntityToDto(invoiceEntity);
    }

    //Update
    @Override
    public InvoiceResponse updateInvoice(Long idInvoice, InvoiceUpdateRequest invoiceRequest)
            throws NotFoundException, InternalException, BadRequestException {

        if(idInvoice == null || idInvoice < 0){
            throw new BadRequestException(EXCEPTION_ID_NOT_VALID);
        }

        Invoice invoiceToUpdate = null;
        try {
            invoiceToUpdate = invoiceRepository.findById(idInvoice).get();
        } catch (Exception ex)  {
            throw  new InternalException(INTERNAL, ex);
        }

        if(invoiceToUpdate == null){
            throw new NotFoundException(EXCEPTION_DATA_NULL );
        }

        //Control data exist
        if(StringUtils.isNotEmpty(invoiceRequest.getDescription())){
            invoiceToUpdate.setDescription(invoiceRequest.getDescription());
        }
        if(null != invoiceRequest.getTotal()){
            invoiceToUpdate.setTotal(invoiceRequest.getTotal());
        }

        //Save update
        Invoice invoiceUpdated = invoiceRepository.save(invoiceToUpdate);

        return invoiceMapper.convertEntityToDto(invoiceUpdated);
    }

    //Delete
    @Override
    public void deleteInvoice(Long idInvoice)
            throws BadRequestException, InternalException, NotFoundException {

        if(idInvoice == null || idInvoice < 0){
            throw new BadRequestException(EXCEPTION_ID_NOT_VALID);
        }

        Optional<Invoice> entityInvoice;
        try {
            entityInvoice = invoiceRepository.findById(idInvoice);
        } catch (Exception ex) {
            throw  new InternalException(INTERNAL, ex);
        }

        if (entityInvoice.isPresent()) {
            invoiceRepository.deleteById(idInvoice);
        } else {
            throw new NotFoundException(EXCEPTION_ID_NULL);
        }
    }
}

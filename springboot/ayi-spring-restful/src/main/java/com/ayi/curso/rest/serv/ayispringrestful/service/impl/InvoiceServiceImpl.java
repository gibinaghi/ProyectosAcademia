package com.ayi.curso.rest.serv.ayispringrestful.service.impl;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.InvoiceRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.InvoiceResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Client;
import com.ayi.curso.rest.serv.ayispringrestful.entity.ClientDetail;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Invoice;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.ReadAccessException;
import com.ayi.curso.rest.serv.ayispringrestful.mapper.IInvoiceMapper;
import com.ayi.curso.rest.serv.ayispringrestful.repository.IInvoiceRepository;
import com.ayi.curso.rest.serv.ayispringrestful.service.IInvoiceService;
import lombok.AllArgsConstructor;
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

    private IInvoiceMapper invoiceMapper;

    //Get all invoice, client, detail cliente and address
    //agregar falta paginación
    @Override
    @Transactional
    public List<InvoiceResponse> findAllInvoice() throws ReadAccessException {

        List<Invoice> invoiceEntityList = invoiceRepository.findAll();

        if(invoiceEntityList == null) {            //.lenght == 0
            throw new ReadAccessException(EXCEPTION_LIST_NULL);
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
    public InvoiceResponse findInvoiceById(Long idInvoice) throws ReadAccessException {
        if(idInvoice == null || idInvoice < 0){
            throw new ReadAccessException(EXCEPTION_ID_NOT_FOUND );
        }


        InvoiceResponse invoiceResponse;
        Optional<Invoice> entityInvoice = invoiceRepository.findById(idInvoice);

        if (!entityInvoice.isPresent()) {
            throw new ReadAccessException(EXCEPTION_ID_NULL);
        }

        invoiceResponse= invoiceMapper.convertEntityToDto(entityInvoice.get());
        return invoiceResponse;
    }

    //Create invoice and set client, detail client and anddress

    //Create invoice, client, detail client, address
    @Override
    @Transactional
    public InvoiceResponse createInvoice(InvoiceRequest invoiceRequest){
        Invoice invoice = invoiceMapper.convertDtoToEntity(invoiceRequest);

        //Set client detail in invoice
        Client client = invoice.getClient();
        ClientDetail clientDetail = client.getClientDetail();

        client.setClientDetail(clientDetail);
        invoice.setClient(client);

        //Save
        invoice = invoiceRepository.save(invoice);

        return invoiceMapper.convertEntityToDto(invoice);
    }

    //Update
    //debe ser un patch - crear dto

    //Delete
    @Override
    public void deleteInvoice(Long idInvoice){
        Optional<Invoice> entityInvoice = invoiceRepository.findById(idInvoice);

        if (entityInvoice.isPresent()) {
            invoiceRepository.deleteById(idInvoice);
        } else {
            throw new RuntimeException(EXCEPTION_ID_NULL);
        }
    }
}

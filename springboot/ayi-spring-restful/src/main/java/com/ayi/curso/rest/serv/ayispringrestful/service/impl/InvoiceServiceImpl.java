package com.ayi.curso.rest.serv.ayispringrestful.service.impl;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.ClientRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.InvoiceRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.ClientResponse;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.InvoiceResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Address;
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
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class InvoiceServiceImpl implements IInvoiceService {
    private IInvoiceRepository invoiceRepository;

    private IInvoiceMapper invoiceMapper;

    //Get all

    //Get by id
    @Override
    @Transactional
    public InvoiceResponse findInvoiceById(Long idInvoice) throws ReadAccessException {
        if(idInvoice == null || idInvoice < 0){
            throw new ReadAccessException("El id es nulo o vacío.");
        }


        InvoiceResponse invoiceResponse;
        Optional<Invoice> entityInvoice = invoiceRepository.findById(idInvoice);

        if (!entityInvoice.isPresent()) {
            throw new ReadAccessException("Error. ID not found.");
        }

        invoiceResponse= invoiceMapper.convertEntityToDto(entityInvoice.get());
        return invoiceResponse;
    }

    //Create invoice and client detail
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

    //Delete
    @Override
    public void deleteInvoice(Long idInvoice){
        Optional<Invoice> entityInvoice = invoiceRepository.findById(idInvoice);

        if (entityInvoice.isPresent()) {
            invoiceRepository.deleteById(idInvoice);
        } else {
            throw new RuntimeException("Error. ID not found.");
        }
    }
}

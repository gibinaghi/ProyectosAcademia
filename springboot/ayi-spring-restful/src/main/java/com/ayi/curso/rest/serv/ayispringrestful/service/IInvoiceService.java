package com.ayi.curso.rest.serv.ayispringrestful.service;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.InvoiceCreateRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.InvoiceRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.InvoiceUpdateRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.InvoiceResponse;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.BadRequestException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.InternalException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IInvoiceService {
    //Get all
    List<InvoiceResponse> findAllInvoice()
            throws NotFoundException, InternalException;

    //Get by id
    InvoiceResponse findInvoiceById(Long idInvoice)
            throws BadRequestException, InternalException, NotFoundException;

    //Create invoice, client, detail client, address
    InvoiceResponse createInvoice(InvoiceCreateRequest invoiceRequest);

    //Create invoice and set client, detail client and address
    InvoiceResponse createInvoiceSetClient(InvoiceRequest invoiceRequest, Long idClient)
            throws BadRequestException, InternalException;

    //Update
    InvoiceResponse updateInvoice(Long idInvoice, InvoiceUpdateRequest invoiceRequest)
            throws NotFoundException, InternalException, BadRequestException;

    //Delete
    void deleteInvoice(Long idInvoice)
            throws BadRequestException, InternalException, NotFoundException;
}

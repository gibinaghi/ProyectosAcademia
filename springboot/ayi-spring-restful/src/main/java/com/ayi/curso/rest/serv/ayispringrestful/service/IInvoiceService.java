package com.ayi.curso.rest.serv.ayispringrestful.service;

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
    //Get all invoice, client, detail cliente and address
    List<InvoiceResponse> findAllInvoice()
            throws NotFoundException, InternalException;

    //Get by id
    InvoiceResponse findInvoiceById(Long idInvoice)
            throws BadRequestException, InternalException;

    //Create invoice, client, detail client, address
    InvoiceResponse createInvoice(InvoiceRequest invoiceRequest);

    //Update
    InvoiceResponse updateInvoice(Long idInvoice, InvoiceUpdateRequest invoiceRequest)
            throws NotFoundException, InternalException, BadRequestException;

    //Delete
    void deleteInvoice(Long idInvoice);
}

package com.ayi.curso.rest.serv.ayispringrestful.service;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.ClientDetailRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.InvoiceRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.ClientDetailResponse;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.InvoiceResponse;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.ReadAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IInvoiceService {
    //Get all invoice, client, detail cliente and address
    List<InvoiceResponse> findAllInvoice() throws ReadAccessException;

    //Get by id
    InvoiceResponse findInvoiceById(Long idInvoice) throws ReadAccessException;

    //Create invoice, client, detail client, address
    InvoiceResponse createInvoice(InvoiceRequest invoiceRequest);

    /*//Update
    InvoiceResponse updateInvoiceById(Long idInvoice, InvoiceRequest invoiceRequest);*/

    //Delete
    void deleteInvoice(Long idInvoice);
}

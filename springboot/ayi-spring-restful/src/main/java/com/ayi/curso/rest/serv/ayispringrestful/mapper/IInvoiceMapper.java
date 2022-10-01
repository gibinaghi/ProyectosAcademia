package com.ayi.curso.rest.serv.ayispringrestful.mapper;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.InvoiceRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.InvoiceResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Invoice;

public interface IInvoiceMapper {
    Invoice convertDtoToEntity(InvoiceRequest request);

    InvoiceResponse convertEntityToDto(Invoice entity);
}

package com.ayi.curso.rest.serv.ayispringrestful.mapper.impl;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.InvoiceRequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.InvoiceResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Invoice;
import com.ayi.curso.rest.serv.ayispringrestful.mapper.IInvoiceMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InvoiceMapperImpl implements IInvoiceMapper {

    private final ModelMapper modelMapper;

    @Override
    public Invoice convertDtoToEntity(InvoiceRequest request)
    {
        return modelMapper.map(request, Invoice.class);
    }

    @Override
    public InvoiceResponse convertEntityToDto(Invoice entity)
    {
        return modelMapper.map(entity, InvoiceResponse.class);
    }
}
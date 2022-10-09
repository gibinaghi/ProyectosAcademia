package com.ayi.curso.rest.serv.ayispringrestful.dto.request;

import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(
        value = "Create - Invoice, Client, Client detail and address",
        description = "Represents data need invoice, client, client detail and address"
)
public class InvoiceCreateRequest {
    private InvoiceRequest invoiceRequest;
    private ClientRequest clientRequest;
    private ClientDetailRequest clientDetailRequest;
    private AddressRequest addressRequest;
}

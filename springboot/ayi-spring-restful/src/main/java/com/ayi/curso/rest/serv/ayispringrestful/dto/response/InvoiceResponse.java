package com.ayi.curso.rest.serv.ayispringrestful.dto.response;

import com.ayi.curso.rest.serv.ayispringrestful.dto.response.ClientResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(
        value = "Invoice Response",
        description = "Represents invoice and client data"
)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class InvoiceResponse {

    @ApiModelProperty(position = 1, notes = "Invoice id")
    private Long idInvoice;

    @ApiModelProperty(position = 2, notes = "Invoice description")
    private String description;

    @ApiModelProperty(position = 3, notes = "Invoice total")
    private Double total;

    @ApiModelProperty(position = 4, required = true, notes = "Client who owns the invoice")
    @JsonIgnoreProperties(value = "invoices")
    private ClientResponse client;
}

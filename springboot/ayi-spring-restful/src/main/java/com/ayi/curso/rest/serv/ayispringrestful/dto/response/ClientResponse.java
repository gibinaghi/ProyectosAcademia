package com.ayi.curso.rest.serv.ayispringrestful.dto.response;

import com.ayi.curso.rest.serv.ayispringrestful.dto.response.AddressResponse;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.ClientDetailResponse;
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
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(
        value = "Client Response",
        description = "Represents the client, client detail, invoice and address data"
)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ClientResponse {

    @ApiModelProperty(position = 1, notes = "Client id.")
    private Long idClient;

    @ApiModelProperty(position = 2, notes = "The first name of the client.")
    private String name;

    @ApiModelProperty(position = 3, notes = "The last name of the client.")
    private String lastname;

    @ApiModelProperty(position = 4, notes = "The document number of the client.")
    private String documentNumber;

    @ApiModelProperty(position = 5, notes = "The client detail.")
    @JsonIgnoreProperties(value = "client")
    private ClientDetailResponse clientDetail;

    @ApiModelProperty(position = 6, notes = "The addresses of the client.")
    @JsonIgnoreProperties(value = "client")
    private List<AddressResponse> addresses;

    @ApiModelProperty(position = 7, notes = "The invoices of the client.")
    @JsonIgnoreProperties(value = "client")
    private List<InvoiceResponse> invoices;
}

package com.ayi.curso.rest.serv.ayispringrestful.dto.request;

import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(
        value = "Create - Client, Client detail and address",
        description = "Represents data need create client, client detail and address"
)
public class ClientCreateRequest {
    private ClientRequest clientRequest;

    private ClientDetailRequest clientDetailRequest;

    private AddressRequest addressRequest;
}

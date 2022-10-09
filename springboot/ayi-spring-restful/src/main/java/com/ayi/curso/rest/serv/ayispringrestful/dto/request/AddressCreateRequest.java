package com.ayi.curso.rest.serv.ayispringrestful.dto.request;

import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(
        value = "Create - Address and client Request",
        description = "Represents data need create address and client"
)
public class AddressCreateRequest {
    private AddressRequest addressRequest;
    private ClientRequest clientRequest;
}

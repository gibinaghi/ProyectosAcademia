package com.ayi.curso.rest.serv.ayispringrestful.dto.request;

import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(
        value = "Create - Client detail and client",
        description = "Represents data need create detail client and client"
)
public class ClientDetailCreateRequest {
     private ClientDetailRequest clientDetailRequest;

     private ClientRequest clientRequest;
}

package com.ayi.curso.rest.serv.ayispringrestful.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(
        value = "Update- Client Request",
        description = "Represents client data"
)
public class ClientUpdateRequest {

    @Pattern(regexp = "[a-zA-Z ]{2,50}", message = "Only allows letters, minimum 2, maximum 50")
    @ApiModelProperty(position = 1, notes = "The first name is optional.")
    private String name;

    @Pattern(regexp = "[a-zA-Z ]{2,20}", message = "Only allows letters, minimum 2, maximum 20")
    @ApiModelProperty(position = 2, notes = "The last name is optional.")
    private String lastname;

    @Pattern(regexp = "[0-9]{8}", message = "The format document is 11222333")
    //@Pattern(regexp = "/^(\d{2}\.{1}\d{3}\.\d{3})|(\d{2}\s{1}\d{3}\s\d{3})$/g", message = "The format document is 11.111.111")
    @ApiModelProperty(position = 3, notes = "The document number is optional.")
    private String documentNumber;  //integer
}
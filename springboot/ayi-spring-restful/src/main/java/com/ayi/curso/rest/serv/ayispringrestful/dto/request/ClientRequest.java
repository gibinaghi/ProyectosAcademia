package com.ayi.curso.rest.serv.ayispringrestful.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(
        value = "Data Client",
        description = "Represents client"
)
public class ClientRequest {
    @NotNull(message = "Name can not be null.")
    @Pattern(regexp = "[a-zA-Z ]{2,50}", message = "Only allows letters, minimum 2, maximum 50")
    @ApiModelProperty(position = 1, required = true, notes = "Non empty value, The first name is required.")
    private String name;

    @NotNull(message = "Lastname can not be null.")
    @Pattern(regexp = "[a-zA-Z ]{2,20}", message = "Only allows letters, minimum 2, maximum 20")
    @ApiModelProperty(position = 2, required = true, notes = "Non empty value, The last name is required.")
    private String lastname;

    @NotNull(message = "Document number can not be null.")
    @Pattern(regexp = "[0-9]{8}", message = "The format document is 11222333")
    //@Pattern(regexp = "/^(\d{2}\.{1}\d{3}\.\d{3})|(\d{2}\s{1}\d{3}\s\d{3})$/g", message = "The format document is 11.111.111")
    @ApiModelProperty(position = 3, required = true, notes = "Non negative value, The document number is required.")
    private String documentNumber;  //integer
}
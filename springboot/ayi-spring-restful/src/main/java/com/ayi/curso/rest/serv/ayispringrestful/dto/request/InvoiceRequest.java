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
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(
        value = "Invoice Request",
        description = "Represents invoice and client data"
)
public class InvoiceRequest implements Serializable {

    @NotNull(message = "Description can not be null.")
    @Pattern(regexp = "[a-zA-Z ]{2,100}", message = "Only allows letters, minimum 2, maximum 100")
    @ApiModelProperty(position = 1, required = true, notes = "Invoice description.")
    private String description;

    @NotNull(message = "Non negative value, total can not be null")
    @ApiModelProperty(position = 2, required = true, notes = "Non negative value, total can not be null")
    private Double total;

    //    @NotNull(message = "Client can not be null")
    @ApiModelProperty(position = 3, required = true, notes = "Client who owns the invoice")
    private ClientRequest client;
}


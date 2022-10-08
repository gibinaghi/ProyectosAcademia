package com.ayi.curso.rest.serv.ayispringrestful.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(
        value = "Update - Invoice Request",
        description = "Represents invoice data"
)
public class InvoiceUpdateRequest implements Serializable {
    @Pattern(regexp = "[a-zA-Z ]{2,100}", message = "Only allows letters, minimum 2, maximum 100")
    @ApiModelProperty(position = 1, required = true, notes = "Invoice description.")
    private String description;

    @ApiModelProperty(position = 2, required = true, notes = "Non negative value, total can not be null")
    private Double total;

}

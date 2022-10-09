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
        value = "Data Invoice",
        description = "Represents invoice data"
)
public class InvoiceRequest {

    @NotNull(message = "Description can not be null.")
    @Pattern(regexp = "[a-zA-Z ]{2,100}", message = "Only allows letters, minimum 2, maximum 100")
    @ApiModelProperty(position = 1, required = true, notes = "Not null value, is required")
    private String description;

    @NotNull(message = "Non negative value, total can not be null")
    @ApiModelProperty(position = 2, required = true, notes = "Non negative value, total can not be null, is required")
    private Double total;
}


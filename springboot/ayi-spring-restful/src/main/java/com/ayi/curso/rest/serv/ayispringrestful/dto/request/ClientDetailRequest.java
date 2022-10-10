package com.ayi.curso.rest.serv.ayispringrestful.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(
        value = "Data Client detail",
        description = "Represents client detail data"
)
public class ClientDetailRequest {

    @NotNull(message = "Prime value can not be null.")
    @ApiModelProperty(position = 1, required = true, notes = "Not null value, prime is required")
    private Boolean prime;

    @ApiModelProperty(position = 2, notes = "The acumulated point is optional")
    @Pattern(regexp = "[0-9]{3}", message = "Only number, 3 digits")
    private Long acumulatedPoints;
}
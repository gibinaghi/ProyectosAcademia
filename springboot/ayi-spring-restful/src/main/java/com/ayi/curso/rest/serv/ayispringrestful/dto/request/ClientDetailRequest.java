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
        value = "Client detail Request",
        description = "Represents client detail and client data"
)
public class ClientDetailRequest implements Serializable {

    @NotNull(message = "Prime value can not be null.")
    @ApiModelProperty(position = 1, required = true, notes = "Boolean data")
    private Boolean prime;

    @ApiModelProperty(position = 2, notes = "Acumulated points of the client")
    @Pattern(regexp = "[0-9]{3}", message = "Only number, 3 digits")
    private Long acumulatedPoints;

    //    @NotNull(message = "Client can not be null.")
    @ApiModelProperty(position = 3, required = true, notes = "Client owner of the points")
    private ClientRequest client;
}
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
        value = "Update - Client detail Request",
        description = "Represents client detail"
)
public class ClientDetaiUpdatelRequest implements Serializable {

    @ApiModelProperty(position = 1, notes = "The prime is optional")
    private Boolean prime;

    @ApiModelProperty(position = 2, notes = "The acumulated point is optional")
    @Pattern(regexp = "[0-9]{3}", message = "Only number, 3 digits")
    private Long acumulatedPoints;
}
package com.ayi.curso.rest.serv.ayispringrestful.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(
        value = "Data Created Lending",
        description = "Represents data need created lending"
)
public class LendingCreateDTORequest {

    @NotNull(message = "date_out can not be null.")
    @ApiModelProperty(position = 1, required = true, notes = "Not null value, date out is required")
    private String date_out;

    @NotNull(message = "date_return can not be null.")
    @ApiModelProperty(position = 2, required = true, notes = "Not null value, date return is required")
    private String date_return;
}

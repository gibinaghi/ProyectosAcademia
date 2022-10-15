package com.ayi.curso.rest.serv.ayispringrestful.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(
        value = "Data Created User",
        description = "Represents data need created user"
)
public class UserCreateDTORequest {

    @NotNull(message = "Name can not be null.")
    @ApiModelProperty(position = 1, required = true, notes = "Not null value, name is required")
    private String name;

    @NotNull(message = "Last name can not be null.")
    @ApiModelProperty(position = 2, required = true, notes = "Not null value, last name is required")
    private String last_name;

    @NotNull(message = "DNI can not be null.")
    @ApiModelProperty(position = 3, required = true, notes = "Not null value, DNI is required")
    //@Pattern(regexp = "[a-zA-Z ]{2,20}", message = "Only allows letters, minimum 2, maximum 20")
    private String dni;

    @ApiModelProperty(position = 4, notes = "Not null value, address is optional")
    private String address;

    @ApiModelProperty(position = 5, notes = "Not null value, phone is optional")
    private String phone;

}
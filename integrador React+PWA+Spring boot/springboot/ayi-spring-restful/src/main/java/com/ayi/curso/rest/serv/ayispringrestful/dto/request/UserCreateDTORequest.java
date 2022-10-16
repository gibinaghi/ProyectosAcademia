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
    @Pattern(regexp = "[0-9]{8}", message = "Only allows numbers, format 11222333")
    private String dni;

    @ApiModelProperty(position = 4, notes = "Address is optional")
    private String address;

    @ApiModelProperty(position = 5, notes = "Phone is optional")
    private String phone;

}

package com.ayi.curso.rest.serv.ayispringrestful.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(
        value = "Data Update User",
        description = "Represents data need update user"
)
public class UserUpdateDTORequest {

    @ApiModelProperty(position = 1, notes = "Name is optional")
    private String name;

    @ApiModelProperty(position = 2, notes = "Last name is optional")
    private String last_name;

    @ApiModelProperty(position = 3, notes = "DNI is optional")
    @Pattern(regexp = "[0-9]{8}", message = "Only allows numbers, format 11222333")
    private String dni;

    @ApiModelProperty(position = 4, notes = "Address is optional")
    private String address;

    @ApiModelProperty(position = 5, notes = "Phone is optional")
    private String phone;

}

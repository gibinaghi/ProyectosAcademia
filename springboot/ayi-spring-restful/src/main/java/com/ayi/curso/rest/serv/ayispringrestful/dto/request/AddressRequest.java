package com.ayi.curso.rest.serv.ayispringrestful.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(
        value = "Address Request",
        description = "Represents address data"
)
public class AddressRequest implements Serializable {

    @NotNull(message = "Street can not be null.")
    @ApiModelProperty(position = 1, required = true, notes = "Not null value, street is required")
    private String street;

    @ApiModelProperty(position = 2, required = true, notes = "Not null value, street number is required")
    private String streetNumber;

    @ApiModelProperty(position = 3, required = true, notes = "Not null value, floor is required")
    private Integer floor;

    @NotNull(message = "Postal code can not be null")
    @ApiModelProperty(position = 4, required = true, notes = "Not null value, postal code is required")
    private Integer postalCode;

    @NotNull(message = "District can not be null.")
    @ApiModelProperty(position = 5, required = true, notes = "Not null value, district is required")
    private String district;

    @NotNull(message = "City can not be null.")
    @ApiModelProperty(position = 6, required = true, notes = "Not null value, city is required")
    private String city;

    @NotNull(message = "Country can not be null.")
    @ApiModelProperty(position = 7, required = true, notes = "Not null value, country is required")
    private String country;

    //aca deberia ingresar solo el id de cliente
    //    @NotNull(message = "Client can not be null")
    @ApiModelProperty(position = 8, required = true, notes = "Not null value, client is required.")
    private ClientRequest client;
}

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
        value = "Create - Address Request",
        description = "Represents address data and idClient"
)
public class AddressWithoutClientRequest implements Serializable {
    @NotNull(message = "Street can not be null.")
    @Pattern(regexp = "[a-zA-Z ]{2,20}", message = "Only allows letters, minimum 2, maximum 20")
    @ApiModelProperty(position = 1, required = true, notes = "Not null value, street is required")
    private String street;

    //@Null -> como digo que es opcional???, default null
    @ApiModelProperty(position = 2, required = true, notes = "Street number is optional")
    @Pattern(regexp = "[a-zA-Z ]{2,20}", message = "Only allows letters, minimum 2, maximum 20")
    private String streetNumber;

    @ApiModelProperty(position = 3, required = true, notes = "Floor is optional")
    @Pattern(regexp = "[0-9]{2}", message = "Only number, 2 digits")
    private Integer floor;

    @NotNull(message = "Postal code can not be null")
    @Pattern(regexp = "[0-9]{4}", message = "Only number, 4 digits")
    @ApiModelProperty(position = 4, required = true, notes = "Not null value, postal code is required")
    private Integer postalCode;

    @NotNull(message = "District can not be null.")
    @Pattern(regexp = "[a-zA-Z ]{2,20}", message = "Only allows letters, minimum 2, maximum 20")
    @ApiModelProperty(position = 5, required = true, notes = "Not null value, district is required")
    private String district;

    @NotNull(message = "City can not be null.")
    @Pattern(regexp = "[a-zA-Z ]{2,20}", message = "Only allows letters, minimum 2, maximum 20")
    @ApiModelProperty(position = 6, required = true, notes = "Not null value, city is required")
    private String city;

    @NotNull(message = "Country can not be null.")
    @Pattern(regexp = "[a-zA-Z ]{2,20}", message = "Only allows letters, minimum 2, maximum 20")
    @ApiModelProperty(position = 7, required = true, notes = "Not null value, country is required")
    private String country;
}

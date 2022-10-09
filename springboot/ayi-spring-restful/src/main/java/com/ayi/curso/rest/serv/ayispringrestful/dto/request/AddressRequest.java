package com.ayi.curso.rest.serv.ayispringrestful.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(
        value = "Data Address",
        description = "Represents address data"
)
public class AddressRequest {

    @NotNull(message = "Street can not be null.")
    @Pattern(regexp = "[a-zA-Z ]{2,20}", message = "Only allows letters, minimum 2, maximum 20")
    @ApiModelProperty(position = 1, required = true, notes = "Not null value, street is required")
    private String street;

    @ApiModelProperty(position = 2, notes = "Street number is optional.")
    @Pattern(regexp = "[a-zA-Z ]{2,20}", message = "Only allows letters, minimum 2, maximum 20")
    private String streetNumber;

    @ApiModelProperty(position = 3, notes = "Floor is optional. Not negative value")
    @Pattern(regexp = "[0-9]{2}", message = "Only number, 2 digits")
    private Integer floor;

    @NotNull(message = "Postal code can not be null or negative")
    @Pattern(regexp = "[0-9]{4}", message = "Only number, 4 digits")
    @ApiModelProperty(position = 4, required = true, notes = "Not null or negative value, postal code is required")
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

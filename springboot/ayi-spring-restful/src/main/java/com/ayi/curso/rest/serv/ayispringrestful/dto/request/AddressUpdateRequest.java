package com.ayi.curso.rest.serv.ayispringrestful.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(
        value = "Update - Address Request",
        description = "Represents address data"
)
public class AddressUpdateRequest implements Serializable {

    @Pattern(regexp = "[a-zA-Z ]{2,20}", message = "Only allows letters, minimum 2, maximum 20")
    @ApiModelProperty(position = 1, notes = "The street is optional")
    private String street;

    @ApiModelProperty(position = 2, notes = "The street number is optional")
    @Pattern(regexp = "[a-zA-Z ]{2,20}", message = "Only allows letters, minimum 2, maximum 20")
    private String streetNumber;

    @ApiModelProperty(position = 3, notes = "The floor is optional")
    @Pattern(regexp = "[0-9]{2}", message = "Only number, 2 digits")
    private Integer floor;

    @Pattern(regexp = "[0-9]{4}", message = "Only number, 4 digits")
    @ApiModelProperty(position = 4, notes = "The postal code is optional")
    private Integer postalCode;

    @Pattern(regexp = "[a-zA-Z ]{2,20}", message = "Only allows letters, minimum 2, maximum 20")
    @ApiModelProperty(position = 5, notes = "The district is optional")
    private String district;

    @Pattern(regexp = "[a-zA-Z ]{2,20}", message = "Only allows letters, minimum 2, maximum 20")
    @ApiModelProperty(position = 6, notes = "The city is optional")
    private String city;

    @Pattern(regexp = "[a-zA-Z ]{2,20}", message = "Only allows letters, minimum 2, maximum 20")
    @ApiModelProperty(position = 7, notes = "The country is optional")
    private String country;
}

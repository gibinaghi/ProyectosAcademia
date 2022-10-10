package com.ayi.curso.rest.serv.ayispringrestful.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(
        value = "Address Response",
        description = "Response of address and client."
)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AddressResponse {

    @ApiModelProperty(position = 1, notes = "Address id.")
    private Long idAddress;

    @ApiModelProperty(position = 2, notes = "Street address.")
    private String street;

    @ApiModelProperty(position = 3, notes = "Street number.")
    private String streetNumber;

    @ApiModelProperty(position = 4, notes = "Floor number, if it apply.")
    private Integer floor;

    @ApiModelProperty(position = 5, notes = "Postal code.")
    private Integer postalCode;

    @ApiModelProperty(position = 6, notes = "District name.")
    private String district;

    @ApiModelProperty(position = 7, notes = "City name.")
    private String city;

    @ApiModelProperty(position = 8, notes = "Country name.")
    private String country;

    @ApiModelProperty(position = 9, notes = "Client.")
    @JsonIgnoreProperties(value = "addresses")
    private ClientResponse client;
}

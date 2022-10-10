package com.ayi.curso.rest.serv.ayispringrestful.dto.response;

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
        value = "Client Detail Response",
        description = "Response of client detail and client."
)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ClientDetailResponse {

    @ApiModelProperty(position = 1, notes = "The client detail id.")
    private Long idClientDetail;

    @ApiModelProperty(position = 2, notes = "Category of client(vip or not vip)")
    private Boolean prime;

    @ApiModelProperty(position = 3, notes = "Acumulated points of the client.")
    private Long acumulatedPoints;

    @ApiModelProperty(position = 4, notes = "Data client.")
    @JsonIgnoreProperties(value = "clientDetail")
    private ClientResponse clientResponse;

}

package com.ayi.curso.rest.serv.ayispringrestful.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(
        value = "Response user",
        description = "Represents response user"
)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserDTOResponse {

    @ApiModelProperty(position = 1, notes = "Id")
    private long id;

    @ApiModelProperty(position = 2, notes = "Name")
    private String name;

    @ApiModelProperty(position = 3, notes = "Last name")
    private String last_name;

    @ApiModelProperty(position = 4, notes = "DNI")
    private String dni;

    @ApiModelProperty(position = 5, notes = "Address")
    private String address;

    @ApiModelProperty(position = 6, notes = "Phone")
    private String phone;

}

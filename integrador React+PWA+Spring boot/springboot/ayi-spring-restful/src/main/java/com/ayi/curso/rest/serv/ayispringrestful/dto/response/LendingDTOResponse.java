package com.ayi.curso.rest.serv.ayispringrestful.dto.response;

import com.ayi.curso.rest.serv.ayispringrestful.entity.Books;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Users;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(
        value = "Response lending",
        description = "Represents response lending"
)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LendingDTOResponse {

    @ApiModelProperty(position = 1, notes = "Id")
    private long id;

    @ApiModelProperty(position = 2, notes = "Date out")
    private String date_out;

    @ApiModelProperty(position = 3, notes = "Date return")
    private String date_return;

    @ApiModelProperty(position = 4, notes = "User")
    @JsonIgnoreProperties(value = "lendings")
    private Users users;

    @ApiModelProperty(position = 5, notes = "Book")
    @JsonIgnoreProperties(value = "lendings")
    private Books books;

}

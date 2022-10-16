package com.ayi.curso.rest.serv.ayispringrestful.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(
        value = "Response book",
        description = "Represents response book"
)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BookDTOResponse {

    @ApiModelProperty(position = 1, notes = "Id")
    private long id;

    @ApiModelProperty(position = 2, notes = "Title")
    private String title;

    @ApiModelProperty(position = 3, notes = "Author")
    @Column(name = "author")
    private String author;

    @ApiModelProperty(position = 4, notes = "Category")
    @Column(name = "category")
    private String category;

    @ApiModelProperty(position = 5, notes = "Edition")
    @Column(name = "edition")
    private String edition;

    @ApiModelProperty(position = 6, notes = "Idiom")
    @Column(name = "idiom")
    private String idiom;

    @ApiModelProperty(position = 7, notes = "Stock")
    @Column(name = "stock")
    private Integer stock;

}

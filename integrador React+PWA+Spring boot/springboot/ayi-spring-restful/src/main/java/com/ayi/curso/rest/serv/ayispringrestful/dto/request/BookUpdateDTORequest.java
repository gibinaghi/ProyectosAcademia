package com.ayi.curso.rest.serv.ayispringrestful.dto.request;

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
        value = "Data Update Book",
        description = "Represents data need update book"
)
public class BookUpdateDTORequest {

    @ApiModelProperty(position = 1, notes = "Title is optional")
    private String title;

    @ApiModelProperty(position = 2, notes = "Author is optional")
    @Column(name = "author")
    private String author;

    @ApiModelProperty(position = 3, notes = "Category is optional")
    @Column(name = "category")
    private String category;

    @ApiModelProperty(position = 4, notes = "Edition is optional")
    @Column(name = "edition")
    private String edition;

    @ApiModelProperty(position = 5, notes = "Idiom is optional")
    @Column(name = "idiom")
    private String idiom;

    @ApiModelProperty(position = 6, notes = "Stock is optional")
    @Column(name = "stock")
    private Integer stock;


}

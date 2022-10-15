package com.ayi.curso.rest.serv.ayispringrestful.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(
        value = "Data Created Book",
        description = "Represents data need created book"
)
public class BookCreateDTORequest {

    @NotNull(message = "Title can not be null.")
    @ApiModelProperty(position = 1, required = true, notes = "Not null value, title is required")
    private String title;

    @NotNull(message = "Author can not be null.")
    @ApiModelProperty(position = 2, required = true, notes = "Not null value, author is required")
    @Column(name = "author")
    private String author;

    @NotNull(message = "Category can not be null.")
    @ApiModelProperty(position = 3, required = true, notes = "Not null value, category is required")
    @Column(name = "category")
    private String category;

    @NotNull(message = "Edition can not be null.")
    @ApiModelProperty(position = 4, required = true, notes = "Not null value, edition is required")
    @Column(name = "edition")
    private String edition;

    @NotNull(message = "Idiom can not be null.")
    @ApiModelProperty(position = 5, required = true, notes = "Not null value, idiom is required")
    @Column(name = "idiom")
    private String idiom;

    @NotNull(message = "Stock can not be null.")
    @ApiModelProperty(position = 6, required = true, notes = "Not null value, stock is required")
    @Column(name = "stock")
    private Integer stock;

    @NotNull(message = "Available can not be null.")
    @ApiModelProperty(position = 7, required = true, notes = "Not null value, available is required")
    @Column(name = "available")
    private Integer available;

}
